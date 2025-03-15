package br.com.myhospital.entidades;

import br.com.myhospital.enuns.Sexo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(optional = true)
    @MapsId
    @JoinColumn(name = "carteira_id")
    @JsonManagedReference
    private CarteiraSaude carteira;

    @OneToMany(mappedBy = "paciente")
    @JsonManagedReference
    private List<Consulta> consultas = new ArrayList<>();

    public Paciente() {
    }

    public Paciente(Long id, String nome, String cpf, Sexo sexo, CarteiraSaude carteira) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.carteira = carteira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarteiraSaude getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraSaude carteira) {
        this.carteira = carteira;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
