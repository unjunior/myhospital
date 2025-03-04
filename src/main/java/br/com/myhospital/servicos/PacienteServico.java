package br.com.myhospital.servicos;

import br.com.myhospital.dto.PacienteDto;
import br.com.myhospital.entidades.Paciente;
import br.com.myhospital.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
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
}
