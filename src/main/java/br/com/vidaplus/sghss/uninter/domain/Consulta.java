package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * entidade para representar consultas / agendamentos médicos
 * contém paciente, profissional, data/hora e status da consulta
 * author: guilherme abreu
 */
@Entity
@Table(name = "consultas") // define o nome da tabela no banco
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @ManyToOne // relação muitos-para-um com paciente
    @JoinColumn(name = "paciente_id", nullable = false) // define a coluna de join no banco
    private Paciente paciente;

    @ManyToOne // relação muitos-para-um com profissional
    @JoinColumn(name = "profissional_id", nullable = false) // define a coluna de join no banco
    private Profissional profissional;

    private LocalDateTime dataHora; // data e hora da consulta

    private String status; // status da consulta: agendado, cancelado, realizado

    public Consulta() {} // construtor padrão necessário para o JPA

    public Consulta(Paciente paciente, Profissional profissional, LocalDateTime dataHora, String status) { 
        this.paciente = paciente; // define o paciente
        this.profissional = profissional; // define o profissional
        this.dataHora = dataHora; // define a data/hora
        this.status = status; // define o status da consulta
    }

    public UUID getId() { return id; } // retorna o id da consulta
    public Paciente getPaciente() { return paciente; } // retorna o paciente da consulta
    public void setPaciente(Paciente paciente) { this.paciente = paciente; } // define o paciente
    public Profissional getProfissional() { return profissional; } // retorna o profissional da consulta
    public void setProfissional(Profissional profissional) { this.profissional = profissional; } // define o profissional
    public LocalDateTime getDataHora() { return dataHora; } // retorna a data/hora
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; } // define a data/hora
    public String getStatus() { return status; } // retorna o status
    public void setStatus(String status) { this.status = status; } // define o status
}
