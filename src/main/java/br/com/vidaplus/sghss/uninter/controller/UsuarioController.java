package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.model.Usuario;
import br.com.vidaplus.sghss.uninter.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario u) {
        return ResponseEntity.ok(service.salvar(u));
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<Usuario> porNome(@PathVariable String username) {
        return ResponseEntity.ok(service.buscarPorUsername(username));
    }
}
