package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.Hospitalization;
import br.com.vidaplus.sghss.uninter.repository.HospitalizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HospitalizationService {

    private final HospitalizationRepository repository;

    public HospitalizationService(HospitalizationRepository repository) { this.repository = repository; }

    public Hospitalization save(Hospitalization h) { return repository.save(h); }
    public List<Hospitalization> byPaciente(UUID pacienteId) { return repository.findByPacienteId(pacienteId); }
    public Hospitalization findById(UUID id) { return repository.findById(id).orElse(null); }
}
