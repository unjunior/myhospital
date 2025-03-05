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
    private Long carteiraId;
   // private List<Consulta> consultas = new ArrayList<>();

    public PacienteDto() {
    }

    public PacienteDto(Long id, String nome, String cpf, Sexo sexo, Long carteiraId) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.carteiraId = carteiraId;
    }
    public PacienteDto(Paciente entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        sexo = entity.getSexo();
        if (entity.getCarteira() != null) {
            carteiraId = entity.getCarteira().getId();
        }

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Long getCarteiraId() {
        return carteiraId;
    }
}
