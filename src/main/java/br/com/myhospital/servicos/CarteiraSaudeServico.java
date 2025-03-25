package br.com.myhospital.servicos;

import br.com.myhospital.dto.CarteiraSaudeDto;
import br.com.myhospital.dto.CarteiraSaudePacienteDto;
import br.com.myhospital.entidades.CarteiraSaude;
import br.com.myhospital.entidades.Paciente;
import br.com.myhospital.repositorio.CarteiraSaudeRepositorio;
import br.com.myhospital.repositorio.PacienteRepositorio;
import br.com.myhospital.servicos.exceptions.DatabaseExceptionServico;
import br.com.myhospital.servicos.exceptions.ExceptionsGenericasServico;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarteiraSaudeServico {

    @Autowired
    private CarteiraSaudeRepositorio carteiraSaudeRepositorio;

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional(readOnly = true)
    public CarteiraSaudeDto findById(Long id){
        CarteiraSaude carteiraSaude = carteiraSaudeRepositorio.findById(id).orElseThrow(
                ()-> new ExceptionsGenericasServico("Carteira de saúde não encontrada!")
        );
        return new CarteiraSaudeDto(carteiraSaude);
    }

    @Transactional
    public Page<CarteiraSaudeDto> findAll(Pageable pageable) {
        Page<CarteiraSaude> result = carteiraSaudeRepositorio.findAll(pageable);
        return result.map(x -> new CarteiraSaudeDto(x));
    }

    @Transactional
    public CarteiraSaudePacienteDto insert (CarteiraSaudePacienteDto dto){

        CarteiraSaude carteiraSaude = new CarteiraSaude();
        carteiraSaude.setNumeroCarteira(dto.getNumeroCarteira());
        carteiraSaude.setEmissao(dto.getEmissao());

        carteiraSaude = carteiraSaudeRepositorio.save(carteiraSaude);

        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setNome(dto.getPaciente().getNome());
        paciente.setCpf(dto.getPaciente().getCpf());
        paciente.setSexo(dto.getPaciente().getSexo());

        paciente.setCarteira(carteiraSaude);
        pacienteRepositorio.save(paciente);

        carteiraSaude.setPaciente(paciente);
        carteiraSaudeRepositorio.save(carteiraSaude);

        return new CarteiraSaudePacienteDto(carteiraSaude);
    }

    @Transactional
    public CarteiraSaudeDto update (Long id, CarteiraSaudeDto dto){
        try {
            CarteiraSaude entity = carteiraSaudeRepositorio.getReferenceById(id);
            entity.setNumeroCarteira(dto.getNumeroCarteira());
            entity.setEmissao(dto.getEmissao());

            return  new CarteiraSaudeDto(entity);
        }
        catch (EntityNotFoundException e){
            throw new ExceptionsGenericasServico("ID da carteira de saúde não encontrado para atualização!");
        }
    }

    @Transactional
    public void delete(Long id){
        if(!carteiraSaudeRepositorio.existsById(id)){
            throw new ExceptionsGenericasServico("Carteira de saúde não encontrada!");
        }
        try{
            carteiraSaudeRepositorio.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            new DatabaseExceptionServico("Falha de integridade referencial");
        }
    }
}
