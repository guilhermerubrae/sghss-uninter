package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.model.Profissional;
import br.com.vidaplus.sghss.uninter.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repository;

    public ProfissionalService(ProfissionalRepository repository) {
        this.repository = repository;
    }

    public Profissional salvar(Profissional p) { return repository.save(p); }
    public List<Profissional> listar() { return repository.findAll(); }
    public Optional<Profissional> buscar(Long id) { return repository.findById(id); }
    public void deletar(Long id) { repository.deleteById(id); }
}
