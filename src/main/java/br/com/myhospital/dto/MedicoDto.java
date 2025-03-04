package br.com.myhospital.dto;

import br.com.myhospital.entidades.Medico;
import br.com.myhospital.enuns.Especialidade;

public class MedicoDto {

    private Long id;
    private String nome;
    private Especialidade especialidade;
    private String crm;

    public MedicoDto() {
    }

    public MedicoDto(Long id, String nome, Especialidade especialidade, String crm) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public MedicoDto(Medico entity) {
        id = entity.getId();
        nome = entity.getNome();
        especialidade = entity.getEspecialidade();
        crm = entity.getCrm();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }
}
