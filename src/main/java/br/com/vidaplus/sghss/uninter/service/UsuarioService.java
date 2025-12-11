package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.domain.Usuario;
import br.com.vidaplus.sghss.uninter.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) { this.repository = repository; }

    public Usuario save(Usuario u) { return repository.save(u); }
    public Usuario findByUsername(String username) { return repository.findByUsername(username); }
}
