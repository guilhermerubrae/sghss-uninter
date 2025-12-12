package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.util.UUID;

/*
 * entidade para representar leitos no hospital
 * contém código, ala/setor e se está ocupado ou não
 * author: guilherme abreu
 */
@Entity
@Table(name = "beds") // define o nome da tabela no banco
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @Column(nullable = false) // coluna obrigatória
    private String code; // código do leito

    @Column(nullable = false) // coluna obrigatória
    private String ward; // ala ou setor do leito

    @Column(nullable = false) // coluna obrigatória
    private boolean occupied; // indica se o leito está ocupado

    public Bed() {} // construtor padrão necessário para o JPA

    public Bed(String code, String ward, boolean occupied) { // construtor para facilitar criação de objetos
        this.code = code;
        this.ward = ward;
        this.occupied = occupied;
    }

    public UUID getId() { return id; } // retorna o id do leito
    public String getCode() { return code; } // retorna o código do leito
    public void setCode(String code) { this.code = code; } // define o código do leito
    public String getWard() { return ward; } // retorna a ala/setor
    public void setWard(String ward) { this.ward = ward; } // define a ala/setor
    public boolean isOccupied() { return occupied; } // retorna se o leito está ocupado
    public void setOccupied(boolean occupied) { this.occupied = occupied; } // define se o leito está ocupado
}
