package br.com.vidaplus.sghss.uninter.repository;

import br.com.vidaplus.sghss.uninter.domain.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BedRepository extends JpaRepository<Bed, UUID> {}
