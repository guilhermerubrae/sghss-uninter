package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.util.UUID;

/*
 * entidade para representar pacientes
 * contém nome, documento (cpf), email e data de nascimento
 * author: guilherme abreu
 */
@Entity
@Table(name = "pacientes") // define o nome da tabela no banco
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @Column(nullable = false) // coluna obrigatória
    private String nome; // nome do paciente

    @Column(nullable = false, unique = true) // coluna obrigatória e única
    private String idNumber; // cpf ou outro documento

    private String email; // email do paciente

    private String birthDate; // data de nascimento do paciente

    public Paciente() {} // construtor padrão necessário para o JPA

    public Paciente(String nome, String idNumber, String email, String birthDate) {
        this.nome = nome; // define o nome
        this.idNumber = idNumber; // define o documento
        this.email = email; // define o email
        this.birthDate = birthDate; // define a data de nascimento
    }

    public UUID getId() { return id; } // retorna o id do paciente
    public String getNome() { return nome; } // retorna o nome
    public void setNome(String nome) { this.nome = nome; } // define o nome
    public String getIdNumber() { return idNumber; } // retorna o documento
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; } // define o documento
    public String getEmail() { return email; } // retorna o email
    public void setEmail(String email) { this.email = email; } // define o email
    public String getBirthDate() { return birthDate; } // retorna a data de nascimento
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; } // define a data de nascimento
}
