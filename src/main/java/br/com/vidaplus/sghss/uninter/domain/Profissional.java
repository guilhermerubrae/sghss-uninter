package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.util.UUID;

/*
 * entidade para representar profissionais de saúde
 * contém nome, registro, email, telefone, status e especialidade
 * author: guilherme abreu
 */
@Entity
@Table(name = "profissionais") // define o nome da tabela no banco
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @Column(nullable = false) // coluna obrigatória
    private String name; // nome do profissional

    @Column(nullable = false, unique = true) // coluna obrigatória e única
    private String registry; // registro profissional

    @Column(nullable = false, unique = true) // coluna obrigatória e única
    private String email; // email do profissional

    private String phone; // telefone do profissional

    @Column(nullable = false) // coluna obrigatória
    private String status; // status do profissional (ativo, inativo etc.)

    @ManyToOne // relação muitos-para-um com especialidade
    @JoinColumn(name = "especialidade_id") // define a coluna de join no banco
    private Especialidade especialidade; // especialidade do profissional

    public Profissional() {} // construtor padrão necessário para o JPA

    public Profissional(String name, String registry, String email, String phone, String status, Especialidade especialidade) {
        this.name = name; // define o nome
        this.registry = registry; // define o registro
        this.email = email; // define o email
        this.phone = phone; // define o telefone
        this.status = status; // define o status
        this.especialidade = especialidade; // define a especialidade
    }

    public UUID getId() { return id; } // retorna o id
    public String getName() { return name; } // retorna o nome
    public void setName(String name) { this.name = name; } // define o nome
    public String getRegistry() { return registry; } // retorna o registro
    public void setRegistry(String registry) { this.registry = registry; } // define o registro
    public String getEmail() { return email; } // retorna o email
    public void setEmail(String email) { this.email = email; } // define o email
    public String getPhone() { return phone; } // retorna o telefone
    public void setPhone(String phone) { this.phone = phone; } // define o telefone
    public String getStatus() { return status; } // retorna o status
    public void setStatus(String status) { this.status = status; } // define o status
    public Especialidade getEspecialidade() { return especialidade; } // retorna a especialidade
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; } // define a especialidade
}
