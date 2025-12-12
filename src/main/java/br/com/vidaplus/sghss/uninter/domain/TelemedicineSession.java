package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * entidade para representar sessões de telemedicina (registros simplificados)
 * contém consulta associada, horários de início/fim e link da sessão
 * author: guilherme abreu
 */
@Entity
@Table(name = "telemedicine_sessions") // define o nome da tabela no banco
public class TelemedicineSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @ManyToOne // relação muitos-para-um com consulta
    @JoinColumn(name = "consulta_id") // define a coluna de join no banco
    private Consulta consulta; // consulta associada à sessão

    private LocalDateTime startedAt; // data/hora de início da sessão

    private LocalDateTime endedAt; // data/hora de término da sessão

    private String sessionUrl; // link para reunião (simulado)

    public TelemedicineSession() {} // construtor padrão necessário para o JPA

    public TelemedicineSession(Consulta consulta, LocalDateTime startedAt, LocalDateTime endedAt, String sessionUrl) { 
        this.consulta = consulta; // define a consulta
        this.startedAt = startedAt; // define o início da sessão
        this.endedAt = endedAt; // define o término da sessão
        this.sessionUrl = sessionUrl; // define o link da sessão
    }

    public UUID getId() { return id; } // retorna o id da sessão
    public Consulta getConsulta() { return consulta; } // retorna a consulta associada
    public void setConsulta(Consulta consulta) { this.consulta = consulta; } // define a consulta
    public LocalDateTime getStartedAt() { return startedAt; } // retorna o horário de início
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; } // define o horário de início
    public LocalDateTime getEndedAt() { return endedAt; } // retorna o horário de término
    public void setEndedAt(LocalDateTime endedAt) { this.endedAt = endedAt; } // define o horário de término
    public String getSessionUrl() { return sessionUrl; } // retorna o link da sessão
    public void setSessionUrl(String sessionUrl) { this.sessionUrl = sessionUrl; } // define o link da sessão
}
