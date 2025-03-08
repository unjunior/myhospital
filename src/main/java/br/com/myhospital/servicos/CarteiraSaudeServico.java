package br.com.myhospital.servicos;

import br.com.myhospital.dto.CarteiraSaudeDto;
import br.com.myhospital.dto.ConsultaDto;
import br.com.myhospital.entidades.CarteiraSaude;
import br.com.myhospital.entidades.Consulta;
import br.com.myhospital.repositorio.CarteiraSaudeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarteiraSaudeServico {

    @Autowired
    private CarteiraSaudeRepositorio carteiraSaudeRepositorio;

    @Transactional(readOnly = true)
    public CarteiraSaudeDto findById(Long id){
        Optional<CarteiraSaude> result = carteiraSaudeRepositorio.findById(id);
        CarteiraSaude carteiraSaude = result.get();
        return new CarteiraSaudeDto(carteiraSaude);
    }

    @Transactional
    public Page<CarteiraSaudeDto> findAll(Pageable pageable) {
        Page<CarteiraSaude> result = carteiraSaudeRepositorio.findAll(pageable);
        return result.map(x -> new CarteiraSaudeDto(x));
    }
}
