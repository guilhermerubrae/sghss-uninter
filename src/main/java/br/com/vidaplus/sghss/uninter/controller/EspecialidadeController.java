package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Especialidade;
import br.com.vidaplus.sghss.uninter.service.EspecialidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * controlador para gerenciar especialidades médicas
 * permite criar, listar, buscar por id e excluir especialidades
 * author: guilherme abreu
 */
@RestController
@RequestMapping("/api/v1/especialidades") // define a rota base do controlador
public class EspecialidadeController {

    private final EspecialidadeService service; // serviço que contém a lógica de negócio das especialidades

    public EspecialidadeController(EspecialidadeService service) { 
        this.service = service; // injeta o serviço de especialidades no controlador
    }

    @PostMapping // mapeia requisições POST para criar uma nova especialidade
    public ResponseEntity<Especialidade> create(@RequestBody Especialidade e) { 
        return ResponseEntity.ok(service.save(e)); // salva a especialidade e retorna o objeto criado
    }

    @GetMapping // mapeia requisições GET para listar todas as especialidades
    public ResponseEntity<List<Especialidade>> all() { 
        return ResponseEntity.ok(service.findAll()); // retorna a lista de todas as especialidades
    }

    @GetMapping("/{id}") // mapeia requisições GET para buscar uma especialidade por id
    public ResponseEntity<Especialidade> get(@PathVariable UUID id) { 
        return ResponseEntity.ok(service.findById(id)); // retorna a especialidade encontrada pelo id
    }

    @DeleteMapping("/{id}") // mapeia requisições DELETE para remover uma especialidade por id
    public ResponseEntity<?> delete(@PathVariable UUID id) { 
        service.delete(id); // remove a especialidade do banco
        return ResponseEntity.noContent().build(); // retorna status 204 indicando que não há conteúdo
    }
}
