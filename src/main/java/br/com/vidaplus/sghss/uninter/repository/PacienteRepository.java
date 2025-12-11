package br.com.vidaplus.sghss.uninter.repository;

import br.com.vidaplus.sghss.uninter.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {}
