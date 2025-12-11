package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.Profissional;
import br.com.vidaplus.sghss.uninter.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repository;

    public ProfissionalService(ProfissionalRepository repository) { this.repository = repository; }

    public Profissional save(Profissional p) { return repository.save(p); }
    public List<Profissional> findAll() { return repository.findAll(); }
    public Profissional findById(UUID id) { return repository.findById(id).orElse(null); }
    public void delete(UUID id) { repository.deleteById(id); }
}
