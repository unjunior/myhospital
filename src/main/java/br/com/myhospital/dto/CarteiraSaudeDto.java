package br.com.myhospital.dto;

import br.com.myhospital.entidades.CarteiraSaude;
import br.com.myhospital.entidades.Paciente;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CarteiraSaudeDto {

    private Long id;

    @Column(unique = true)
    private String numeroCarteira;

    private LocalDate emissao;
    private Long pacienteId;

    public CarteiraSaudeDto() {
    }

    public CarteiraSaudeDto(Long id, String numeroCarteira, LocalDate emissao, Long pacienteId) {
        this.id = id;
        this.numeroCarteira = numeroCarteira;
        this.emissao = emissao;
        this.pacienteId = pacienteId;
    }

    public CarteiraSaudeDto(CarteiraSaude entity) {
        id = entity.getId();
        numeroCarteira = entity.getNumeroCarteira();
        emissao = entity.getEmissao();

        if(entity.getPaciente() != null){
            pacienteId = entity.getPaciente().getId();
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

    public Long getPacienteId() {
        return pacienteId;
    }
}
