package br.com.vidaplus.sghss.uninter.domain;

import jakarta.persistence.*;
import java.util.UUID;

/*
 * entidade para representar usuários para autenticação simples
 * contém username, senha e role
 * author: guilherme abreu
 */
@Entity
@Table(name = "usuarios") // define o nome da tabela no banco
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera automaticamente um id do tipo UUID
    private UUID id;

    @Column(nullable = false, unique = true) // coluna obrigatória e única
    private String username; // nome de usuário para login

    @Column(nullable = false) // coluna obrigatória
    private String password; // senha (em produção, deve ser hash)

    @Column(nullable = false) // coluna obrigatória
    private String role; // perfil do usuário (ex: ROLE_ADMIN, ROLE_PROFISSIONAL, ROLE_PATIENT)

    public Usuario() {} // construtor padrão necessário para o JPA

    public Usuario(String username, String password, String role) {
        this.username = username; // define o username
        this.password = password; // define a senha
        this.role = role; // define a role
    }

    public UUID getId() { return id; } // retorna o id do usuário
    public String getUsername() { return username; } // retorna o username
    public void setUsername(String username) { this.username = username; } // define o username
    public String getPassword() { return password; } // retorna a senha
    public void setPassword(String password) { this.password = password; } // define a senha
    public String getRole() { return role; } // retorna a role
    public void setRole(String role) { this.role = role; } // define a role
}
