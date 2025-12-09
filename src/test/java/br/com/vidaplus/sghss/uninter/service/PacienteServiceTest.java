package br.com.vidaplus.sghss.uninter.service;

import br.com.vidaplus.sghss.uninter.model.Paciente;
import br.com.vidaplus.sghss.uninter.repository.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*
 * teste simples de exemplo para paciente service
 * author: guilherme abreu
 * comentários em minúsculas
 */

public class PacienteServiceTest {

    @Test
    public void testBuscarPorId() {
        PacienteRepository repo = Mockito.mock(PacienteRepository.class);
        Paciente p = new Paciente("joão", "12345678900", "joao@example.com", "1990-01-01");
        when(repo.findById(1L)).thenReturn(Optional.of(p));

        PacienteService s = new PacienteService(repo);
        var resultado = s.buscarPorId(1L);
        assertTrue(resultado.isPresent());
        assertEquals("joão", resultado.get().getNome());
    }
}
