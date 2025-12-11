package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * prescrição / receita digital
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    private LocalDateTime issuedAt;

    @Column(length = 2000)
    private String content; // medicamentos e orientações

    public Prescription() {}

    public Prescription(Consulta consulta, Profissional profissional, LocalDateTime issuedAt, String content) {
        this.consulta = consulta;
        this.profissional = profissional;
        this.issuedAt = issuedAt;
        this.content = content;
    }

    public UUID getId() { return id; }
    public Consulta getConsulta() { return consulta; }
    public void setConsulta(Consulta consulta) { this.consulta = consulta; }
    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }
    public LocalDateTime getIssuedAt() { return issuedAt; }
    public void setIssuedAt(LocalDateTime issuedAt) { this.issuedAt = issuedAt; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
