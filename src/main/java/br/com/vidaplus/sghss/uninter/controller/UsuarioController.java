package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Usuario;
import br.com.vidaplus.sghss.uninter.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/*
 * controlador para gerenciar usuários do sistema
 * permite criar usuários e buscar por username
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/usuarios") // define a rota base do controlador
public class UsuarioController {

    private final UsuarioService service; // serviço que contém a lógica de negócio dos usuários

    public UsuarioController(UsuarioService service) { 
        this.service = service; // injeta o serviço de usuários no controlador
    }

    @PostMapping // mapeia requisições POST para criar um novo usuário
    public ResponseEntity<Usuario> create(@RequestBody Usuario u) { 
        return ResponseEntity.ok(service.save(u)); // salva o usuário e retorna o objeto criado
    }

    @GetMapping("/by-username/{username}") // mapeia requisições GET para buscar um usuário pelo username
    public ResponseEntity<Usuario> byUsername(@PathVariable String username) { 
        return ResponseEntity.ok(service.findByUsername(username)); // retorna o usuário encontrado pelo username
    }
}
