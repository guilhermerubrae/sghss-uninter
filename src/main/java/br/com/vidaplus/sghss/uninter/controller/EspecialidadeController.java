package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Especialidade;
import br.com.vidaplus.sghss.uninter.service.EspecialidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para especialidades
@RestController
@RequestMapping("/api/v1/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService service;

    public EspecialidadeController(EspecialidadeService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Especialidade> create(@RequestBody Especialidade e) { return ResponseEntity.ok(service.save(e)); }

    @GetMapping
    public ResponseEntity<List<Especialidade>> all() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> get(@PathVariable UUID id) { return ResponseEntity.ok(service.findById(id)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
