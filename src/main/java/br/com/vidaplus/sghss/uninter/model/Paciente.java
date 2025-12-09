package br.com.vidaplus.sghss.uninter.model;

import jakarta.persistence.*;

/*
 * entidade paciente
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String idNumber;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(length = 150)
    private String email;

    private String birthDate;

    public Paciente() {}

    public Paciente(String nome, String idNumber, String email, String birthDate) {
        this.nome = nome;
        this.idNumber = idNumber;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() { return id; }
    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
}
