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
 */
@RestController
@RequestMapping("/api/v1/auth") // define a rota base do controlador
public class AuthController {

    private final UsuarioService usuarioService; // serviço para consultar dados do usuário
    private final TokenService tokenService; // serviço para criar e validar tokens

    public AuthController(UsuarioService usuarioService, TokenService tokenService) {
        this.usuarioService = usuarioService; // injeta o serviço de usuário
        this.tokenService = tokenService; // injeta o serviço de token
    }

    @PostMapping("/login") // define que este método responde a requisições POST na rota /login
    public ResponseEntity<?> login(@RequestBody Map<String,String> body) {
        String username = body.get("username"); // pega o username enviado no corpo da requisição
        String password = body.get("password"); // pega a senha enviada no corpo da requisição

        Usuario u = usuarioService.findByUsername(username); // busca o usuário no banco pelo username

        if (u == null || !u.getPassword().equals(password)) { // verifica se o usuário existe e se a senha está correta
            return ResponseEntity.status(401).body("invalid credentials"); // retorna 401 se for inválido
        }

        String token = tokenService.issueToken(username, u.getRole()); // gera um token para o usuário

        return ResponseEntity.ok(Map.of("token", token)); // retorna o token em um json para o cliente
    }
}
