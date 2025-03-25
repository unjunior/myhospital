package br.com.myhospital.servicos;

import br.com.myhospital.dto.MedicoDto;
import br.com.myhospital.entidades.Medico;
import br.com.myhospital.repositorio.MedicoRepositorio;
import br.com.myhospital.servicos.exceptions.ExceptionsGenericasServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoServico {

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Transactional(readOnly = true)
    public MedicoDto findById (Long id){
        Medico medico = medicoRepositorio.findById(id).orElseThrow(
                () ->  new ExceptionsGenericasServico("O id do médico não foi encontrado!")
        );
        return new MedicoDto(medico);
    }

    @Transactional
    public Page<MedicoDto> findAll(Pageable pageable) {
        Page<Medico> result = medicoRepositorio.findAll(pageable);
        return result.map(x -> new MedicoDto(x));
    }

    @Transactional
    public MedicoDto insert (MedicoDto dto){
        Medico entity = new Medico();
        entity.setNome(dto.getNome());
        entity.setEspecialidade(dto.getEspecialidade());
        entity.setCrm(dto.getCrm());

        entity = medicoRepositorio.save(entity);
        return new MedicoDto(entity);
    }

    @Transactional
    public MedicoDto update (Long id, MedicoDto dto){
        Medico entity = medicoRepositorio.getReferenceById(id);
        entity.setNome(dto.getNome());
        entity.setCrm(dto.getCrm());
        entity.setEspecialidade(dto.getEspecialidade());

        entity = medicoRepositorio.save(entity);
        return  new MedicoDto(entity);
    }

    @Transactional
    public void delete(Long id){
        medicoRepositorio.deleteById(id);
    }
}
