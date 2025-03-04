package br.com.myhospital.dto;

import br.com.myhospital.entidades.CarteiraSaude;
import br.com.myhospital.entidades.Consulta;
import br.com.myhospital.entidades.Paciente;
import br.com.myhospital.enumerados.Sexo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class PacienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private Sexo sexo;
    private CarteiraSaude carteira;
    private List<Consulta> consultas = new ArrayList<>();

    public PacienteDto() {
    }

    public PacienteDto(Long id, String nome, String cpf, Sexo sexo, CarteiraSaude carteira) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.carteira = carteira;
    }
    public PacienteDto(Paciente entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        sexo = entity.getSexo();
        carteira = entity.getCarteira();
    }

}
