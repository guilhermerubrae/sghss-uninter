package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Hospitalization;
import br.com.vidaplus.sghss.uninter.service.HospitalizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para internações (hospitalizations)
@RestController
@RequestMapping("/api/v1/hospitalizations")
public class HospitalizationController {

    private final HospitalizationService service;

    public HospitalizationController(HospitalizationService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Hospitalization> create(@RequestBody Hospitalization h) { return ResponseEntity.ok(service.save(h)); }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Hospitalization>> byPaciente(@PathVariable UUID pacienteId) { return ResponseEntity.ok(service.byPaciente(pacienteId)); }

    @GetMapping("/{id}")
    public ResponseEntity<Hospitalization> get(@PathVariable UUID id) { return ResponseEntity.ok(service.findById(id)); }
}
