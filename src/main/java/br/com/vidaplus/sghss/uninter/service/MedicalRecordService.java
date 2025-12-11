package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.MedicalRecord;
import br.com.vidaplus.sghss.uninter.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository repository;

    public MedicalRecordService(MedicalRecordRepository repository) { this.repository = repository; }

    public MedicalRecord save(MedicalRecord r) { return repository.save(r); }
    public List<MedicalRecord> byPaciente(UUID pacienteId) { return repository.findByPacienteId(pacienteId); }
    public MedicalRecord findById(UUID id) { return repository.findById(id).orElse(null); }
    public void delete(UUID id) { repository.deleteById(id); }
}
