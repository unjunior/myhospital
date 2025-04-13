package br.com.myhospital.servicos.seguranca;

import br.com.myhospital.entidades.seguranca.Usuario;
import br.com.myhospital.repositorio.seguranca.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario == null){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuario;
    }
}
