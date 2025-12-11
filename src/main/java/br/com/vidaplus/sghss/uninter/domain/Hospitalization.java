package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * internação / hospitalization
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Entity
@Table(name = "hospitalizations")
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;

    private LocalDateTime admissionAt;

    private LocalDateTime dischargeAt;

    public Hospitalization() {}

    public Hospitalization(Paciente paciente, Bed bed, LocalDateTime admissionAt, LocalDateTime dischargeAt) {
        this.paciente = paciente;
        this.bed = bed;
        this.admissionAt = admissionAt;
        this.dischargeAt = dischargeAt;
    }

    public UUID getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Bed getBed() { return bed; }
    public void setBed(Bed bed) { this.bed = bed; }
    public LocalDateTime getAdmissionAt() { return admissionAt; }
    public void setAdmissionAt(LocalDateTime admissionAt) { this.admissionAt = admissionAt; }
    public LocalDateTime getDischargeAt() { return dischargeAt; }
    public void setDischargeAt(LocalDateTime dischargeAt) { this.dischargeAt = dischargeAt; }
}
