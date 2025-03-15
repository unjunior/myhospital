package br.com.myhospital.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_carteira")
public class CarteiraSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroCarteira;

    @OneToOne(mappedBy = "carteira", cascade = CascadeType.ALL)
    @JsonBackReference
    private Paciente paciente;
    private LocalDate emissao;

    public CarteiraSaude() {
    }

    public CarteiraSaude(Long id, String numeroCarteira, Paciente paciente, LocalDate emissao) {
        this.id = id;
        this.numeroCarteira = numeroCarteira;
        this.paciente = paciente;
        this.emissao = emissao;
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
