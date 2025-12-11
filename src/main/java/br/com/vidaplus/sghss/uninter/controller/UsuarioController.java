package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Usuario;
import br.com.vidaplus.sghss.uninter.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

// controller para usuarios (criar e buscar)
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario u) { return ResponseEntity.ok(service.save(u)); }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<Usuario> byUsername(@PathVariable String username) { return ResponseEntity.ok(service.findByUsername(username)); }
}
