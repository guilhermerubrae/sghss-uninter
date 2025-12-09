package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.model.Consulta;
import br.com.vidaplus.sghss.uninter.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Consulta salvar(Consulta c) { return repository.save(c); }
    public List<Consulta> listar() { return repository.findAll(); }
    public Optional<Consulta> buscar(Long id) { return repository.findById(id); }
    public List<Consulta> porPaciente(Long pacienteId) { return repository.findByPacienteId(pacienteId); }
    public void deletar(Long id) { repository.deleteById(id); }
}
