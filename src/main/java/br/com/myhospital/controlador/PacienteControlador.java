package br.com.myhospital.controlador;

import br.com.myhospital.dto.MedicoDto;
import br.com.myhospital.dto.PacienteDto;
import br.com.myhospital.servicos.PacienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteControlador {

    @Autowired
    private PacienteServico pacienteServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteDto> findById(@PathVariable Long id){
        PacienteDto dto = pacienteServico.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDto>> findAll(Pageable pageable){
        Page<PacienteDto> list = pacienteServico.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<PacienteDto> insert (@RequestBody PacienteDto dto){
        dto = pacienteServico.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PacienteDto> update (@PathVariable Long id, @RequestBody PacienteDto dto){
        dto = pacienteServico.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        pacienteServico.delete(id);
        return ResponseEntity.noContent().build();
    }
}
