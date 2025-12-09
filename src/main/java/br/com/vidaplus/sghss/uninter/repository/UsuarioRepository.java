package br.com.vidaplus.sghss.uninter.repository;

import br.com.vidaplus.sghss.uninter.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
