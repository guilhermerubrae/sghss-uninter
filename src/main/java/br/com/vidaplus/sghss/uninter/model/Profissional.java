package br.com.vidaplus.sghss.uninter.model;

import jakarta.persistence.*;

/*
 * entidade profissional (médico, enfermeiro, técnico etc.)
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Entity
@Table(name = "profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(length = 80)
    private String registroProfissional;

    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    public Profissional() {}

    public Profissional(String nome, String registroProfissional, Especialidade especialidade) {
        this.nome = nome;
        this.registroProfissional = registroProfissional;
        this.especialidade = especialidade;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getRegistroProfissional() { return registroProfissional; }
    public void setRegistroProfissional(String registroProfissional) { this.registroProfissional = registroProfissional; }
    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }
}
