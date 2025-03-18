package br.com.myhospital.controlador;

import br.com.myhospital.dto.ConsultaDto;
import br.com.myhospital.dto.ConsultaPacienteMedicoDto;
import br.com.myhospital.dto.MedicoDto;
import br.com.myhospital.dto.PacienteDto;
import br.com.myhospital.servicos.ConsultaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<ConsultaPacienteMedicoDto> insert (@RequestBody ConsultaPacienteMedicoDto dto){
        dto = consultaServico.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultaPacienteMedicoDto> update (@PathVariable Long id, @RequestBody ConsultaPacienteMedicoDto dto){
        dto = consultaServico.update(id, dto);
        return ResponseEntity.ok(dto);
    }
}
