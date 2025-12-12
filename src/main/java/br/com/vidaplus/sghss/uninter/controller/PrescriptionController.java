package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Prescription;
import br.com.vidaplus.sghss.uninter.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar prescrições médicas
 * permite criar e listar prescrições por profissional de saúde
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/prescriptions") // define a rota base do controlador
public class PrescriptionController {

    private final PrescriptionService service; // serviço que contém a lógica de negócio das prescrições

    public PrescriptionController(PrescriptionService service) { 
        this.service = service; // injeta o serviço de prescrições no controlador
    }

    @PostMapping // mapeia requisições POST para criar uma nova prescrição
    public ResponseEntity<Prescription> create(@RequestBody Prescription p) { 
        return ResponseEntity.ok(service.save(p)); // salva a prescrição e retorna o objeto criado
    }

    @GetMapping("/profissional/{profissionalId}") // mapeia requisições GET para listar prescrições de um profissional específico
    public ResponseEntity<List<Prescription>> byProf(@PathVariable UUID profissionalId) { 
        return ResponseEntity.ok(service.byProfissional(profissionalId)); // retorna a lista de prescrições do profissional
    }
}
