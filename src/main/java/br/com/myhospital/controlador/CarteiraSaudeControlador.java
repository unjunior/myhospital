package br.com.myhospital.controlador;

import br.com.myhospital.dto.CarteiraSaudeDto;
import br.com.myhospital.dto.ConsultaDto;
import br.com.myhospital.servicos.CarteiraSaudeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carteira")
public class CarteiraSaudeControlador {

    @Autowired
    private CarteiraSaudeServico carteiraSaudeServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarteiraSaudeDto> findById(@PathVariable Long id){
        CarteiraSaudeDto dto = carteiraSaudeServico.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<CarteiraSaudeDto>> findAll(Pageable pageable){
        Page<CarteiraSaudeDto> list = carteiraSaudeServico.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }
}
