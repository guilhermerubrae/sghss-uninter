package br.com.vidaplus.sghss.uninter.repository;

import br.com.vidaplus.sghss.uninter.domain.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, UUID> {}
