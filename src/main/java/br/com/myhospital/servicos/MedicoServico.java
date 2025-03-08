package br.com.myhospital.servicos;

import br.com.myhospital.dto.MedicoDto;
import br.com.myhospital.entidades.Medico;
import br.com.myhospital.repositorio.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MedicoServico {

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Transactional(readOnly = true)
    public MedicoDto findById (Long id){
        Optional<Medico> result = medicoRepositorio.findById(id);
        Medico medico = result.get();
        return new MedicoDto(medico);
    }

    @Transactional
    public Page<MedicoDto> findAll(Pageable pageable) {
        Page<Medico> result = medicoRepositorio.findAll(pageable);
        return result.map(x -> new MedicoDto(x));
    }
}
