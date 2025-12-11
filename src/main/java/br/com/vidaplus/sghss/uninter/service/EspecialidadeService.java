package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.Especialidade;
import br.com.vidaplus.sghss.uninter.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository) { this.repository = repository; }

    public Especialidade save(Especialidade e) { return repository.save(e); }
    public List<Especialidade> findAll() { return repository.findAll(); }
    public Especialidade findById(UUID id) { return repository.findById(id).orElse(null); }
    public void delete(UUID id) { repository.deleteById(id); }
}
