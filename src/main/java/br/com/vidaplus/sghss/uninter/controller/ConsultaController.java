package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Consulta;
import br.com.vidaplus.sghss.uninter.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para consultas
@RestController
@RequestMapping("/api/v1/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Consulta> create(@RequestBody Consulta c) { return ResponseEntity.ok(service.save(c)); }

    @GetMapping
    public ResponseEntity<List<Consulta>> all() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Consulta>> byPaciente(@PathVariable UUID pacienteId) { return ResponseEntity.ok(service.byPaciente(pacienteId)); }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> get(@PathVariable UUID id) { return ResponseEntity.ok(service.findById(id)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
