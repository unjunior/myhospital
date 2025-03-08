package br.com.myhospital.servicos;

import br.com.myhospital.dto.ConsultaDto;
import br.com.myhospital.dto.PacienteDto;
import br.com.myhospital.entidades.Consulta;
import br.com.myhospital.entidades.Paciente;
import br.com.myhospital.repositorio.ConsultaRepositorio;
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

    @Transactional(readOnly = true)
    public ConsultaDto findById (Long id){

        Optional<Consulta> result = consultaRepositorio.findById(id);
        Consulta consulta = result.get();
        return new ConsultaDto(consulta);
    }

    @Transactional
    public Page<ConsultaDto> findAll(Pageable pageable) {
        Page<Consulta> result = consultaRepositorio.findAll(pageable);
        return result.map(x -> new ConsultaDto(x));
    }
}
