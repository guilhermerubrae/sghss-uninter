package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * entidade para representar internações hospitalares
 * contém paciente, leito, data de admissão e alta
 * author: guilherme abreu
 */
@Entity
@Table(name = "hospitalizations") // define o nome da tabela no banco
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @ManyToOne // relação muitos-para-um com paciente
    @JoinColumn(name = "paciente_id", nullable = false) // define a coluna de join no banco
    private Paciente paciente;

    @ManyToOne // relação muitos-para-um com leito
    @JoinColumn(name = "bed_id") // coluna de join opcional, pois nem sempre o leito está definido
    private Bed bed;

    private LocalDateTime admissionAt; // data/hora da admissão

    private LocalDateTime dischargeAt; // data/hora da alta

    public Hospitalization() {} // construtor padrão necessário para o JPA

    public Hospitalization(Paciente paciente, Bed bed, LocalDateTime admissionAt, LocalDateTime dischargeAt) { 
        this.paciente = paciente; // define o paciente
        this.bed = bed; // define o leito
        this.admissionAt = admissionAt; // define a data de admissão
        this.dischargeAt = dischargeAt; // define a data de alta
    }

    public UUID getId() { return id; } // retorna o id da internação
    public Paciente getPaciente() { return paciente; } // retorna o paciente
    public void setPaciente(Paciente paciente) { this.paciente = paciente; } // define o paciente
    public Bed getBed() { return bed; } // retorna o leito
    public void setBed(Bed bed) { this.bed = bed; } // define o leito
    public LocalDateTime getAdmissionAt() { return admissionAt; } // retorna a data de admissão
    public void setAdmissionAt(LocalDateTime admissionAt) { this.admissionAt = admissionAt; } // define a data de admissão
    public LocalDateTime getDischargeAt() { return dischargeAt; } // retorna a data de alta
    public void setDischargeAt(LocalDateTime dischargeAt) { this.dischargeAt = dischargeAt; } // define a data de alta
}
