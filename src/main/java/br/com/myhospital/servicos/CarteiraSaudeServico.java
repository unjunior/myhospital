package br.com.myhospital.servicos;

import br.com.myhospital.dto.CarteiraSaudeDto;
import br.com.myhospital.dto.CarteiraSaudePacienteDto;
import br.com.myhospital.dto.ConsultaDto;
import br.com.myhospital.entidades.CarteiraSaude;
import br.com.myhospital.entidades.Consulta;
import br.com.myhospital.entidades.Paciente;
import br.com.myhospital.repositorio.CarteiraSaudeRepositorio;
import br.com.myhospital.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarteiraSaudeServico {

    @Autowired
    private CarteiraSaudeRepositorio carteiraSaudeRepositorio;

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional(readOnly = true)
    public CarteiraSaudeDto findById(Long id){
        Optional<CarteiraSaude> result = carteiraSaudeRepositorio.findById(id);
        CarteiraSaude carteiraSaude = result.get();
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
}
