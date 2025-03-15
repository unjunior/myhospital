package br.com.myhospital.controlador;

import br.com.myhospital.dto.MedicoDto;
import br.com.myhospital.servicos.MedicoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/medico")
public class MedicoControlador {

    @Autowired
    private MedicoServico medicoServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoDto> findById(@PathVariable Long id){
        MedicoDto dto = medicoServico.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDto>> findAll(Pageable pageable){
        Page<MedicoDto> list = medicoServico.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<MedicoDto> insert (@RequestBody MedicoDto dto){
        dto = medicoServico.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}
