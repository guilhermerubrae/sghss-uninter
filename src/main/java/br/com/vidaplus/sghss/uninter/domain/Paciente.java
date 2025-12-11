package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.util.UUID;

/*
 * paciente - entidade base já existente no projeto
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String idNumber; // cpf/documento

    private String email;

    private String birthDate;

    public Paciente() {}

    public Paciente(String nome, String idNumber, String email, String birthDate) {
        this.nome = nome;
        this.idNumber = idNumber;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
}
