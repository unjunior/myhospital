package br.com.myhospital.servicos;

import br.com.myhospital.dto.PacienteDto;
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
public class PacienteServico {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private CarteiraSaudeRepositorio carteiraSaudeRepositorio;

    @Transactional(readOnly = true)
    public PacienteDto findById(Long id){

        Paciente paciente = pacienteRepositorio.findById(id).orElseThrow(
                ()-> new ExceptionsGenericasServico("Id do paciente não foi encontrado!")
        );

        return new PacienteDto(paciente);
    }

    @Transactional
    public Page<PacienteDto> findAll(Pageable pageable) {
        Page<Paciente> result = pacienteRepositorio.findAll(pageable);
        return result.map(x -> new PacienteDto(x));
    }

    @Transactional
    public PacienteDto insert(PacienteDto dto){
        Paciente entity = new Paciente();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setSexo(dto.getSexo());

        if(dto.getCarteiraId() != null){
            CarteiraSaude carteiraSaude = carteiraSaudeRepositorio.findById(dto.getCarteiraId())
                    .orElseThrow(() -> new EntityNotFoundException("Carteira não encontrada"));
            entity.setCarteira(carteiraSaude);
        }

        entity = pacienteRepositorio.save(entity);
        return new PacienteDto(entity);
    }

    @Transactional
    public PacienteDto update (Long id, PacienteDto dto){
        try{
            Paciente entity = pacienteRepositorio.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity.setCpf(dto.getCpf());
            entity.setSexo(dto.getSexo());

            entity = pacienteRepositorio.save(entity);
            return new PacienteDto(entity);
        }
        catch (EntityNotFoundException e){
            throw new ExceptionsGenericasServico("ID do paciente não encontrado para atualização!");
        }
    }

    @Transactional
    public void delete(Long id){
        if(!pacienteRepositorio.existsById(id)){
            throw new ExceptionsGenericasServico("Paciente não encontrado!");
        }
        try{
            pacienteRepositorio.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            new DatabaseExceptionServico("Falha de integridade referencial");
        }

    }
}
