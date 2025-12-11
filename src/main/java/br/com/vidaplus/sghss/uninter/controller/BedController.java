package br.com.vidaplus.sghss.uninter.controller;

import br.com.vidaplus.sghss.uninter.domain.Bed;
import br.com.vidaplus.sghss.uninter.service.BedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// controller para leitos (beds)
@RestController
@RequestMapping("/api/v1/beds")
public class BedController {

    private final BedService service;

    public BedController(BedService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Bed> create(@RequestBody Bed b) { return ResponseEntity.ok(service.save(b)); }

    @GetMapping
    public ResponseEntity<List<Bed>> all() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Bed> get(@PathVariable UUID id) { return ResponseEntity.ok(service.findById(id)); }
}
