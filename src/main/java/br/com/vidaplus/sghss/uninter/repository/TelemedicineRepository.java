package br.com.vidaplus.sghss.uninter.repository;

import br.com.vidaplus.sghss.uninter.domain.TelemedicineSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TelemedicineRepository extends JpaRepository<TelemedicineSession, UUID> {
    List<TelemedicineSession> findByConsultaId(UUID consultaId);
}
