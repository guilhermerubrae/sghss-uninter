package br.com.vidaplus.sghss.uninter.repository;

import br.com.vidaplus.sghss.uninter.domain.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProfissionalRepository extends JpaRepository<Profissional, UUID> {}
