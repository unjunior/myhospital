package br.com.myhospital.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_carteira")
public class CarteiraSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true)
    private String numeroCarteira;

    @OneToOne
    @MapsId
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public CarteiraSaude() {
    }

    public CarteiraSaude(Long id, String numeroCarteira, Paciente paciente) {
        this.id = id;
        this.numeroCarteira = numeroCarteira;
        this.paciente = paciente;
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
}
