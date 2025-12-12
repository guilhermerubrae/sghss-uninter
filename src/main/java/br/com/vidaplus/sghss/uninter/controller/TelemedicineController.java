package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.TelemedicineSession;
import br.com.vidaplus.sghss.uninter.service.TelemedicineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar sessões de telemedicina
 * permite criar sessões e listar por consulta específica
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/telemedicine") // define a rota base do controlador
public class TelemedicineController {

    private final TelemedicineService service; // serviço que contém a lógica de negócio das sessões de telemedicina

    public TelemedicineController(TelemedicineService service) { 
        this.service = service; // injeta o serviço de telemedicina no controlador
    }

    @PostMapping // mapeia requisições POST para criar uma nova sessão de telemedicina
    public ResponseEntity<TelemedicineSession> create(@RequestBody TelemedicineSession s) { 
        return ResponseEntity.ok(service.save(s)); // salva a sessão e retorna o objeto criado
    }

    @GetMapping("/consulta/{consultaId}") // mapeia requisições GET para listar sessões de uma consulta específica
    public ResponseEntity<List<TelemedicineSession>> byConsulta(@PathVariable UUID consultaId) { 
        return ResponseEntity.ok(service.byConsulta(consultaId)); // retorna a lista de sessões da consulta
    }
}
