package br.com.myhospital.repositorio;

import br.com.myhospital.entidades.CarteiraSaude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraSaudeRepositorio extends JpaRepository<CarteiraSaude, Long> {
}
