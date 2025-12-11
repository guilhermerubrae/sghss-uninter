package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.Bed;
import br.com.vidaplus.sghss.uninter.repository.BedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BedService {

    private final BedRepository repository;

    public BedService(BedRepository repository) { this.repository = repository; }

    public Bed save(Bed b) { return repository.save(b); }
    public List<Bed> findAll() { return repository.findAll(); }
    public Bed findById(UUID id) { return repository.findById(id).orElse(null); }
    public void delete(UUID id) { repository.deleteById(id); }
}
