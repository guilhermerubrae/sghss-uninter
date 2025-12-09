package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.model.Especialidade;
import br.com.vidaplus.sghss.uninter.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }

    public Especialidade salvar(Especialidade e) { return repository.save(e); }
    public List<Especialidade> listar() { return repository.findAll(); }
    public Optional<Especialidade> buscar(Long id) { return repository.findById(id); }
}
