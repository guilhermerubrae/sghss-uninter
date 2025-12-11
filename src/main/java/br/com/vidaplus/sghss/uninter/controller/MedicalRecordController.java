package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.MedicalRecord;
import br.com.vidaplus.sghss.uninter.service.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para prontuários (medical records)
@RestController
@RequestMapping("/api/v1/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService service;

    public MedicalRecordController(MedicalRecordService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<MedicalRecord> create(@RequestBody MedicalRecord r) { return ResponseEntity.ok(service.save(r)); }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<MedicalRecord>> byPaciente(@PathVariable UUID pacienteId) { return ResponseEntity.ok(service.byPaciente(pacienteId)); }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> get(@PathVariable UUID id) { return ResponseEntity.ok(service.findById(id)); }
}
