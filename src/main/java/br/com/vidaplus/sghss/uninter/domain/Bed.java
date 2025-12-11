package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.util.UUID;

/*
 * controle de leitos simples
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Entity
@Table(name = "beds")
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String ward; // ala/setor

    @Column(nullable = false)
    private boolean occupied;

    public Bed() {}

    public Bed(String code, String ward, boolean occupied) {
        this.code = code;
        this.ward = ward;
        this.occupied = occupied;
    }

    public UUID getId() { return id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }
    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }
}
