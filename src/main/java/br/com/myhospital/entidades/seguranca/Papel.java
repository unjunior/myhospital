package br.com.myhospital.entidades.seguranca;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name = "tb_papel")
public class Papel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String permissao;

    public Papel() {
    }

    public Papel(Long id, String permissao) {
        this.id = id;
        this.permissao = permissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Papel other = (Papel) obj;
        return Objects.equals(permissao, other.permissao);
    }

    @Override
    public String getAuthority() {
        return permissao;
    }
}
