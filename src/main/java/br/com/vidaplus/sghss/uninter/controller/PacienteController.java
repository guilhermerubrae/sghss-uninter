package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Paciente;
import br.com.vidaplus.sghss.uninter.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para pacientes
@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente p) { return ResponseEntity.ok(service.save(p)); }

    @GetMapping
    public ResponseEntity<List<Paciente>> all() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> get(@PathVariable UUID id) { return ResponseEntity.ok(service.findById(id)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
