package br.com.myhospital.controlador;

import br.com.myhospital.dto.MedicoDto;
import br.com.myhospital.dto.PacienteDto;
import br.com.myhospital.servicos.PacienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
