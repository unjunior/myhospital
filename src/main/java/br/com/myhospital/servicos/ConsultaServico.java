package br.com.myhospital.servicos;

import br.com.myhospital.dto.ConsultaDto;
import br.com.myhospital.dto.ConsultaPacienteMedicoDto;
import br.com.myhospital.dto.MedicoDto;
import br.com.myhospital.dto.PacienteDto;
import br.com.myhospital.entidades.Consulta;
import br.com.myhospital.entidades.Medico;
import br.com.myhospital.entidades.Paciente;
import br.com.myhospital.repositorio.ConsultaRepositorio;
import br.com.myhospital.repositorio.MedicoRepositorio;
import br.com.myhospital.repositorio.PacienteRepositorio;
import br.com.myhospital.servicos.exceptions.ExceptionsGenericasServico;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConsultaServico {

    @Autowired
    private ConsultaRepositorio consultaRepositorio;

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Transactional(readOnly = true)
    public ConsultaDto findById (Long id){

        Consulta consulta = consultaRepositorio.findById(id).orElseThrow(
                () -> new ExceptionsGenericasServico("Consulta não encontrada!")
        );

        return new ConsultaDto(consulta);
    }

    @Transactional
    public Page<ConsultaDto> findAll(Pageable pageable) {
        Page<Consulta> result = consultaRepositorio.findAll(pageable);
        return result.map(x -> new ConsultaDto(x));
    }

    @Transactional
    public ConsultaPacienteMedicoDto insert(ConsultaPacienteMedicoDto dto){

        Paciente p = pacienteRepositorio.getReferenceById(dto.getPaciente().getId());
        Medico m = medicoRepositorio.getReferenceById(dto.getMedico().getId());

        Consulta consulta = new Consulta();
        consulta.setHorario(dto.getHorario());
        consulta.setPaciente(p);
        consulta.setMedico(m);
        consulta = consultaRepositorio.save(consulta);

        return new ConsultaPacienteMedicoDto(consulta);
    }

    @Transactional
    public ConsultaPacienteMedicoDto update (Long id, ConsultaPacienteMedicoDto dto){
        try {
            Consulta entity = consultaRepositorio.getReferenceById(id);
            entity.setHorario(dto.getHorario());

            Paciente p = pacienteRepositorio.getReferenceById(dto.getPaciente().getId());
            entity.setPaciente(p);
            Medico m = medicoRepositorio.getReferenceById(dto.getMedico().getId());
            entity.setMedico(m);

            entity = consultaRepositorio.save(entity);
            return new ConsultaPacienteMedicoDto(entity);
        }
        catch (EntityNotFoundException e){
            throw new ExceptionsGenericasServico("Consulta não encontrada para atualização");
        }
    }

    @Transactional
    public void delete(Long id){
        consultaRepositorio.deleteById(id);
    }
}
