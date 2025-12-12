package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.util.UUID;

/*
 * entidade para representar especialidades médicas
 * contém apenas o nome da especialidade
 * author: guilherme abreu
 */
@Entity
@Table(name = "especialidades") // define o nome da tabela no banco
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @Column(nullable = false) // coluna obrigatória
    private String nome; // nome da especialidade

    public Especialidade() {} // construtor padrão necessário para o JPA

    public Especialidade(String nome) { 
        this.nome = nome; // define o nome da especialidade
    }

    public UUID getId() { return id; } // retorna o id
    public String getNome() { return nome; } // retorna o nome da especialidade
    public void setNome(String nome) { this.nome = nome; } // define o nome da especialidade
}
