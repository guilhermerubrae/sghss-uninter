package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.TelemedicineSession;
import br.com.vidaplus.sghss.uninter.service.TelemedicineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para telemedicina (registros)
@RestController
@RequestMapping("/api/v1/telemedicine")
public class TelemedicineController {

    private final TelemedicineService service;

    public TelemedicineController(TelemedicineService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<TelemedicineSession> create(@RequestBody TelemedicineSession s) { return ResponseEntity.ok(service.save(s)); }

    @GetMapping("/consulta/{consultaId}")
    public ResponseEntity<List<TelemedicineSession>> byConsulta(@PathVariable UUID consultaId) { return ResponseEntity.ok(service.byConsulta(consultaId)); }
}
