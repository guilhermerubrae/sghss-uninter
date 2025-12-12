package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Profissional;
import br.com.vidaplus.sghss.uninter.service.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar profissionais de saúde
 * permite criar, listar todos, buscar por id e excluir profissionais
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/profissionais") // define a rota base do controlador
public class ProfissionalController {

    private final ProfissionalService service; // serviço que contém a lógica de negócio dos profissionais

    public ProfissionalController(ProfissionalService service) { 
        this.service = service; // injeta o serviço de profissionais no controlador
    }

    @PostMapping // mapeia requisições POST para criar um novo profissional
    public ResponseEntity<Profissional> create(@RequestBody Profissional p) { 
        return ResponseEntity.ok(service.save(p)); // salva o profissional e retorna o objeto criado
    }

    @GetMapping // mapeia requisições GET para listar todos os profissionais
    public ResponseEntity<List<Profissional>> all() { 
        return ResponseEntity.ok(service.findAll()); // retorna a lista de todos os profissionais
    }

    @GetMapping("/{id}") // mapeia requisições GET para buscar um profissional por id
    public ResponseEntity<Profissional> get(@PathVariable UUID id) { 
        return ResponseEntity.ok(service.findById(id)); // retorna o profissional encontrado pelo id
    }

    @DeleteMapping("/{id}") // mapeia requisições DELETE para remover um profissional por id
    public ResponseEntity<?> delete(@PathVariable UUID id) { 
        service.delete(id); // remove o profissional do banco
        return ResponseEntity.noContent().build(); // retorna status 204 indicando que não há conteúdo
    }
}
