package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.model.Paciente;
import br.com.vidaplus.sghss.uninter.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente salvar(Paciente paciente) { return repository.save(paciente); }

    public List<Paciente> listarTodos() { return repository.findAll(); }

    public Optional<Paciente> buscarPorId(Long id) { return repository.findById(id); }

    public Paciente buscarPorIdNumber(String idNumber) { return repository.findByIdNumber(idNumber); }

    public void deletar(Long id) { repository.deleteById(id); }
}
