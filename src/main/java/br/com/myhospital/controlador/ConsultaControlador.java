package br.com.myhospital.controlador;

import br.com.myhospital.dto.ConsultaDto;
import br.com.myhospital.dto.PacienteDto;
import br.com.myhospital.servicos.ConsultaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultaControlador {

    @Autowired
    private ConsultaServico consultaServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConsultaDto> findById(@PathVariable Long id){
        ConsultaDto dto = consultaServico.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaDto>> findAll(Pageable pageable){
        Page<ConsultaDto> list = consultaServico.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }
}
