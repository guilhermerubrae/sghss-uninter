package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Bed;
import br.com.vidaplus.sghss.uninter.service.BedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar leitos (beds)
 * permite criar, listar todos e buscar por id
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/beds") // define a rota base do controlador
public class BedController {

    private final BedService service; // serviço que contém a lógica de negócio dos leitos

    public BedController(BedService service) { 
        this.service = service; // injeta o serviço de leitos no controlador
    }

    @PostMapping // mapeia requisições POST para criar um novo leito
    public ResponseEntity<Bed> create(@RequestBody Bed b) { 
        return ResponseEntity.ok(service.save(b)); // salva o leito e retorna com status 200
    }

    @GetMapping // mapeia requisições GET para listar todos os leitos
    public ResponseEntity<List<Bed>> all() { 
        return ResponseEntity.ok(service.findAll()); // retorna a lista de todos os leitos
    }

    @GetMapping("/{id}") // mapeia requisições GET com id na rota para buscar um leito específico
    public ResponseEntity<Bed> get(@PathVariable UUID id) { 
        return ResponseEntity.ok(service.findById(id)); // busca o leito pelo id e retorna
    }
}
