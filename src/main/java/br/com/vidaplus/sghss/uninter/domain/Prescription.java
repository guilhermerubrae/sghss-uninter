package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * entidade para representar prescrições médicas (receitas digitais)
 * contém consulta, profissional, data de emissão e conteúdo da prescrição
 * author: guilherme abreu
 */
@Entity
@Table(name = "prescriptions") // define o nome da tabela no banco
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @ManyToOne // relação muitos-para-um com consulta
    @JoinColumn(name = "consulta_id") // define a coluna de join no banco
    private Consulta consulta;

    @ManyToOne // relação muitos-para-um com profissional
    @JoinColumn(name = "profissional_id") // define a coluna de join no banco
    private Profissional profissional;

    private LocalDateTime issuedAt; // data/hora de emissão da prescrição

    @Column(length = 2000) // limite de caracteres para o conteúdo da prescrição
    private String content; // medicamentos e orientações

    public Prescription() {} // construtor padrão necessário para o JPA

    public Prescription(Consulta consulta, Profissional profissional, LocalDateTime issuedAt, String content) { 
        this.consulta = consulta; // define a consulta
        this.profissional = profissional; // define o profissional
        this.issuedAt = issuedAt; // define a data de emissão
        this.content = content; // define o conteúdo da prescrição
    }

    public UUID getId() { return id; } // retorna o id da prescrição
    public Consulta getConsulta() { return consulta; } // retorna a consulta
    public void setConsulta(Consulta consulta) { this.consulta = consulta; } // define a consulta
    public Profissional getProfissional() { return profissional; } // retorna o profissional
    public void setProfissional(Profissional profissional) { this.profissional = profissional; } // define o profissional
    public LocalDateTime getIssuedAt() { return issuedAt; } // retorna a data de emissão
    public void setIssuedAt(LocalDateTime issuedAt) { this.issuedAt = issuedAt; } // define a data de emissão
    public String getContent() { return content; } // retorna o conteúdo da prescrição
    public void setContent(String content) { this.content = content; } // define o conteúdo da prescrição
}
