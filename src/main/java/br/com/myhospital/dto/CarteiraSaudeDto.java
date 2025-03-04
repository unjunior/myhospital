package br.com.myhospital.dto;

import br.com.myhospital.entidades.CarteiraSaude;
import br.com.myhospital.entidades.Paciente;

import java.time.LocalDate;

public class CarteiraSaudeDto {

    private Long id;
    private String numeroCarteira;
    private Paciente paciente;
    private LocalDate emissao;

    public CarteiraSaudeDto() {
    }

    public CarteiraSaudeDto(Long id, String numeroCarteira, Paciente paciente, LocalDate emissao) {
        this.id = id;
        this.numeroCarteira = numeroCarteira;
        this.paciente = paciente;
        this.emissao = emissao;
    }

    public CarteiraSaudeDto(CarteiraSaude entity) {
        id = entity.getId();
        numeroCarteira = entity.getNumeroCarteira();
        paciente = entity.getPaciente();
        emissao = entity.getEmissao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDate emissao) {
        this.emissao = emissao;
    }
}
