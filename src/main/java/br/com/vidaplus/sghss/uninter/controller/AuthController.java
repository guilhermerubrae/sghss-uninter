package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Usuario;
import br.com.vidaplus.sghss.uninter.service.UsuarioService;
import br.com.vidaplus.sghss.uninter.util.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
 * controlador simples de autenticação que gera tokens temporários (protótipo)
 * header: x-auth-token
 * author: guilherme abreu
 * comentários em minúsculas
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    public AuthController(UsuarioService usuarioService, TokenService tokenService) {
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body) {
        String username = body.get("username");
        String password = body.get("password");
        Usuario u = usuarioService.findByUsername(username);
        if (u == null || !u.getPassword().equals(password)) {
            return ResponseEntity.status(401).body("invalid credentials");
        }
        String token = tokenService.issueToken(username, u.getRole());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
