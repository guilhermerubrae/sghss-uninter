package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.TelemedicineSession;
import br.com.vidaplus.sghss.uninter.repository.TelemedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TelemedicineService {

    private final TelemedicineRepository repository;

    public TelemedicineService(TelemedicineRepository repository) { this.repository = repository; }

    public TelemedicineSession save(TelemedicineSession s) { return repository.save(s); }
    public List<TelemedicineSession> byConsulta(UUID consultaId) { return repository.findByConsultaId(consultaId); }
}
