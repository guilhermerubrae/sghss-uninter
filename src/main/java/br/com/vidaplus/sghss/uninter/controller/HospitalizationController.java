package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Hospitalization;
import br.com.vidaplus.sghss.uninter.service.HospitalizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar internações hospitalares
 * permite criar, listar por paciente e buscar por id
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/hospitalizations") // define a rota base do controlador
public class HospitalizationController {

    private final HospitalizationService service; // serviço que contém a lógica de negócio das internações

    public HospitalizationController(HospitalizationService service) { 
        this.service = service; // injeta o serviço de internações no controlador
    }

    @PostMapping // mapeia requisições POST para criar uma nova internação
    public ResponseEntity<Hospitalization> create(@RequestBody Hospitalization h) { 
        return ResponseEntity.ok(service.save(h)); // salva a internação e retorna o objeto criado
    }

    @GetMapping("/paciente/{pacienteId}") // mapeia requisições GET para buscar internações de um paciente específico
    public ResponseEntity<List<Hospitalization>> byPaciente(@PathVariable UUID pacienteId) { 
        return ResponseEntity.ok(service.byPaciente(pacienteId)); // retorna a lista de internações do paciente
    }

    @GetMapping("/{id}") // mapeia requisições GET para buscar uma internação por id
    public ResponseEntity<Hospitalization> get(@PathVariable UUID id) { 
        return ResponseEntity.ok(service.findById(id)); // retorna a internação encontrada pelo id
    }
}
