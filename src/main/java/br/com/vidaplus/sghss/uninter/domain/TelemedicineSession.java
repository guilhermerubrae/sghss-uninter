package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * sessão de telemedicina (registro simplificado)
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Entity
@Table(name = "telemedicine_sessions")
public class TelemedicineSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private String sessionUrl; // link para reunião (simulado)

    public TelemedicineSession() {}

    public TelemedicineSession(Consulta consulta, LocalDateTime startedAt, LocalDateTime endedAt, String sessionUrl) {
        this.consulta = consulta;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.sessionUrl = sessionUrl;
    }

    public UUID getId() { return id; }
    public Consulta getConsulta() { return consulta; }
    public void setConsulta(Consulta consulta) { this.consulta = consulta; }
    public LocalDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }
    public LocalDateTime getEndedAt() { return endedAt; }
    public void setEndedAt(LocalDateTime endedAt) { this.endedAt = endedAt; }
    public String getSessionUrl() { return sessionUrl; }
    public void setSessionUrl(String sessionUrl) { this.sessionUrl = sessionUrl; }
}
