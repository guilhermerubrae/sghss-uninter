package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Consulta;
import br.com.vidaplus.sghss.uninter.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar consultas médicas
 * permite criar, listar, buscar por paciente ou id e excluir consultas
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/consultas") // define a rota base do controlador
public class ConsultaController {

    private final ConsultaService service; // serviço que contém a lógica de negócio das consultas

    public ConsultaController(ConsultaService service) { 
        this.service = service; // injeta o serviço de consultas no controlador
    }

    @PostMapping // mapeia requisições POST para criar uma nova consulta
    public ResponseEntity<Consulta> create(@RequestBody Consulta c) { 
        return ResponseEntity.ok(service.save(c)); // salva a consulta e retorna o objeto criado
    }

    @GetMapping // mapeia requisições GET para listar todas as consultas
    public ResponseEntity<List<Consulta>> all() { 
        return ResponseEntity.ok(service.findAll()); // retorna a lista de todas as consultas
    }

    @GetMapping("/paciente/{pacienteId}") // mapeia requisições GET para buscar consultas de um paciente específico
    public ResponseEntity<List<Consulta>> byPaciente(@PathVariable UUID pacienteId) { 
        return ResponseEntity.ok(service.byPaciente(pacienteId)); // retorna a lista de consultas do paciente
    }

    @GetMapping("/{id}") // mapeia requisições GET para buscar uma consulta por id
    public ResponseEntity<Consulta> get(@PathVariable UUID id) { 
        return ResponseEntity.ok(service.findById(id)); // retorna a consulta encontrada pelo id
    }

    @DeleteMapping("/{id}") // mapeia requisições DELETE para remover uma consulta por id
    public ResponseEntity<?> delete(@PathVariable UUID id) { 
        service.delete(id); // remove a consulta do banco
        return ResponseEntity.noContent().build(); // retorna status 204 indicando que não há conteúdo
    }
}
