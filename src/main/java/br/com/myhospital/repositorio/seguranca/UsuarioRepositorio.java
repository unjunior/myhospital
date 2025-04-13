package br.com.myhospital.repositorio.seguranca;

import br.com.myhospital.entidades.seguranca.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
