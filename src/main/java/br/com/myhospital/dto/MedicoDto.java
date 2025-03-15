package br.com.myhospital.dto;

import br.com.myhospital.entidades.Consulta;
import br.com.myhospital.entidades.Medico;
import br.com.myhospital.enuns.Especialidade;

import java.util.ArrayList;
import java.util.List;

public class MedicoDto {

    private Long id;
    private String nome;
    private Especialidade especialidade;
    private String crm;
    private List<Long> consultaIds;

    public MedicoDto() {
    }

    public MedicoDto(Long id, String nome, Especialidade especialidade, String crm) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;

    }

    public MedicoDto(Long id, String nome, Especialidade especialidade, String crm, List<Long> consultaIds) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.consultaIds = consultaIds;
    }

    public MedicoDto(Medico entity) {
        id = entity.getId();
        nome = entity.getNome();
        especialidade = entity.getEspecialidade();
        crm = entity.getCrm();
        this.consultaIds = new ArrayList<>();
        for(Consulta consulta : entity.getConsultas()){
            this.consultaIds.add(consulta.getId());
        }
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

    public List<Long> getConsultaIds() {
        return consultaIds;
    }
}
