package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.Consulta;
import br.com.vidaplus.sghss.uninter.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) { this.repository = repository; }

    public Consulta save(Consulta c) { return repository.save(c); }
    public List<Consulta> findAll() { return repository.findAll(); }
    public Consulta findById(UUID id) { return repository.findById(id).orElse(null); }
    public List<Consulta> byPaciente(UUID pacienteId) { return repository.findByPacienteId(pacienteId); }
    public void delete(UUID id) { repository.deleteById(id); }
}
