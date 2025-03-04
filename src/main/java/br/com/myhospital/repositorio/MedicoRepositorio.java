package br.com.myhospital.repositorio;

import br.com.myhospital.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico, Long> {
}
