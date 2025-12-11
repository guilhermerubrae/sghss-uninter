package br.com.vidaplus.sghss.uninter.repository;

import br.com.vidaplus.sghss.uninter.domain.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, UUID> {
    List<Hospitalization> findByPacienteId(UUID pacienteId);
}
