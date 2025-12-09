package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.model.Especialidade;
import br.com.vidaplus.sghss.uninter.service.EspecialidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService service;

    public EspecialidadeController(EspecialidadeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Especialidade> criar(@RequestBody Especialidade e) {
        return ResponseEntity.ok(service.salvar(e));
    }

    @GetMapping
    public ResponseEntity<List<Especialidade>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> buscar(@PathVariable Long id) {
        return service.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
