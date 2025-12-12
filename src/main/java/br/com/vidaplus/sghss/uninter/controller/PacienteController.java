package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Paciente;
import br.com.vidaplus.sghss.uninter.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar pacientes
 * permite criar, listar todos, buscar por id e excluir pacientes
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/pacientes") // define a rota base do controlador
public class PacienteController {

    private final PacienteService service; // serviço que contém a lógica de negócio dos pacientes

    public PacienteController(PacienteService service) { 
        this.service = service; // injeta o serviço de pacientes no controlador
    }

    @PostMapping // mapeia requisições POST para criar um novo paciente
    public ResponseEntity<Paciente> create(@RequestBody Paciente p) { 
        return ResponseEntity.ok(service.save(p)); // salva o paciente e retorna o objeto criado
    }

    @GetMapping // mapeia requisições GET para listar todos os pacientes
    public ResponseEntity<List<Paciente>> all() { 
        return ResponseEntity.ok(service.findAll()); // retorna a lista de todos os pacientes
    }

    @GetMapping("/{id}") // mapeia requisições GET para buscar um paciente por id
    public ResponseEntity<Paciente> get(@PathVariable UUID id) { 
        return ResponseEntity.ok(service.findById(id)); // retorna o paciente encontrado pelo id
    }

    @DeleteMapping("/{id}") // mapeia requisições DELETE para remover um paciente por id
    public ResponseEntity<?> delete(@PathVariable UUID id) { 
        service.delete(id); // remove o paciente do banco
        return ResponseEntity.noContent().build(); // retorna status 204 indicando que não há conteúdo
    }
}
