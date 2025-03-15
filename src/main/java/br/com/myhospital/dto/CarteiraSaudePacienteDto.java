package br.com.myhospital.dto;

import br.com.myhospital.entidades.CarteiraSaude;

import java.time.LocalDate;

public class CarteiraSaudePacienteDto {

    private Long id;
    private String numeroCarteira;
    private LocalDate emissao;
    private PacienteDto paciente;

    public CarteiraSaudePacienteDto() {
    }

    public CarteiraSaudePacienteDto(Long id, String numeroCarteira, LocalDate emissao, PacienteDto paciente) {
        this.id = id;
        this.numeroCarteira = numeroCarteira;
        this.emissao = emissao;
        this.paciente = paciente;
    }

    public CarteiraSaudePacienteDto(CarteiraSaude entity) {
        id = entity.getId();
        numeroCarteira = entity.getNumeroCarteira();
        emissao = entity.getEmissao();
        if(entity.getPaciente() != null){
            paciente = new PacienteDto(entity.getPaciente());
        }
    }

    public Long getId() {
        return id;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }
}
