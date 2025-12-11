package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Prescription;
import br.com.vidaplus.sghss.uninter.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para prescrições
@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService service;

    public PrescriptionController(PrescriptionService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Prescription> create(@RequestBody Prescription p) { return ResponseEntity.ok(service.save(p)); }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<Prescription>> byProf(@PathVariable UUID profissionalId) { return ResponseEntity.ok(service.byProfissional(profissionalId)); }
}
