package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Profissional;
import br.com.vidaplus.sghss.uninter.service.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para profissionais
@RestController
@RequestMapping("/api/v1/profissionais")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Profissional> create(@RequestBody Profissional p) { return ResponseEntity.ok(service.save(p)); }

    @GetMapping
    public ResponseEntity<List<Profissional>> all() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> get(@PathVariable UUID id) { return ResponseEntity.ok(service.findById(id)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
