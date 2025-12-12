package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * entidade para representar prontuários médicos (medical records)
 * contém paciente, profissional, data de criação e notas médicas
 * author: guilherme abreu
 */
@Entity
@Table(name = "medical_records") // define o nome da tabela no banco
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @ManyToOne // relação muitos-para-um com paciente
    @JoinColumn(name = "paciente_id", nullable = false) // coluna obrigatória
    private Paciente paciente;

    @ManyToOne // relação muitos-para-um com profissional
    @JoinColumn(name = "profissional_id") // coluna opcional, nem sempre terá profissional associado
    private Profissional profissional;

    private LocalDateTime createdAt; // data/hora de criação do prontuário

    @Column(length = 4000) // limite de caracteres para notas médicas
    private String notes; // notas do prontuário

    public MedicalRecord() {} // construtor padrão necessário para o JPA

    public MedicalRecord(Paciente paciente, Profissional profissional, LocalDateTime createdAt, String notes) { 
        this.paciente = paciente; // define o paciente
        this.profissional = profissional; // define o profissional
        this.createdAt = createdAt; // define a data de criação
        this.notes = notes; // define as notas médicas
    }

    public UUID getId() { return id; } // retorna o id do prontuário
    public Paciente getPaciente() { return paciente; } // retorna o paciente
    public void setPaciente(Paciente paciente) { this.paciente = paciente; } // define o paciente
    public Profissional getProfissional() { return profissional; } // retorna o profissional
    public void setProfissional(Profissional profissional) { this.profissional = profissional; } // define o profissional
    public LocalDateTime getCreatedAt() { return createdAt; } // retorna a data de criação
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; } // define a data de criação
    public String getNotes() { return notes; } // retorna as notas médicas
    public void setNotes(String notes) { this.notes = notes; } // define as notas médicas
}
