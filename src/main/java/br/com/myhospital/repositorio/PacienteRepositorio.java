package br.com.myhospital.repositorio;

import br.com.myhospital.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {
}
