package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.MedicalRecord;
import br.com.vidaplus.sghss.uninter.service.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar prontuários médicos (medical records)
 * permite criar, listar por paciente e buscar por id
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/medical-records") // define a rota base do controlador
public class MedicalRecordController {

    private final MedicalRecordService service; // serviço que contém a lógica de negócio dos prontuários

    public MedicalRecordController(MedicalRecordService service) { 
        this.service = service; // injeta o serviço de prontuários no controlador
    }

    @PostMapping // mapeia requisições POST para criar um novo prontuário
    public ResponseEntity<MedicalRecord> create(@RequestBody MedicalRecord r) { 
        return ResponseEntity.ok(service.save(r)); // salva o prontuário e retorna o objeto criado
    }

    @GetMapping("/paciente/{pacienteId}") // mapeia requisições GET para buscar prontuários de um paciente específico
    public ResponseEntity<List<MedicalRecord>> byPaciente(@PathVariable UUID pacienteId) { 
        return ResponseEntity.ok(service.byPaciente(pacienteId)); // retorna a lista de prontuários do paciente
    }

    @GetMapping("/{id}") // mapeia requisições GET para buscar um prontuário por id
    public ResponseEntity<MedicalRecord> get(@PathVariable UUID id) { 
        return ResponseEntity.ok(service.findById(id)); // retorna o prontuário encontrado pelo id
    }
}
