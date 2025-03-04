package br.com.myhospital.servicos;

import br.com.myhospital.dto.ConsultaDto;
import br.com.myhospital.entidades.Consulta;
import br.com.myhospital.repositorio.ConsultaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
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
}
