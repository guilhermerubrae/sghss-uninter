package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.Paciente;
import br.com.vidaplus.sghss.uninter.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) { this.repository = repository; }

    public Paciente save(Paciente p) { return repository.save(p); }
    public List<Paciente> findAll() { return repository.findAll(); }
    public Paciente findById(UUID id) { return repository.findById(id).orElse(null); }
    public void delete(UUID id) { repository.deleteById(id); }
}
