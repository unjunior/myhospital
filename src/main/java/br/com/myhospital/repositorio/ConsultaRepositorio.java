package br.com.myhospital.repositorio;

import br.com.myhospital.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepositorio extends JpaRepository<Consulta, Long> {
}
