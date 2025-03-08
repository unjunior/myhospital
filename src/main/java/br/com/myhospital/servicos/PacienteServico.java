package br.com.myhospital.servicos;

import br.com.myhospital.dto.MedicoDto;
import br.com.myhospital.dto.PacienteDto;
import br.com.myhospital.entidades.Medico;
import br.com.myhospital.entidades.Paciente;
import br.com.myhospital.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PacienteServico {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional(readOnly = true)
    public PacienteDto findById(Long id){

        Optional<Paciente> result = pacienteRepositorio.findById(id);
        Paciente paciente = result.get();
        return new PacienteDto(paciente);
    }

    @Transactional
    public Page<PacienteDto> findAll(Pageable pageable) {
        Page<Paciente> result = pacienteRepositorio.findAll(pageable);
        return result.map(x -> new PacienteDto(x));
    }
}
