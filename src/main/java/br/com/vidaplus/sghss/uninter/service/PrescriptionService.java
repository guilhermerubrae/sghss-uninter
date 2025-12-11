package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.Prescription;
import br.com.vidaplus.sghss.uninter.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrescriptionService {

    private final PrescriptionRepository repository;

    public PrescriptionService(PrescriptionRepository repository) { this.repository = repository; }

    public Prescription save(Prescription p) { return repository.save(p); }
    public List<Prescription> byProfissional(UUID profissionalId) { return repository.findByProfissionalId(profissionalId); }
}
