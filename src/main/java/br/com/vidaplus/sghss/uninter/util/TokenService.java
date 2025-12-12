package br.com.vidaplus.sghss.uninter.util;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
 * serviço simples para emitir tokens temporários
 * mantém relação token -> username e token -> role
 * não é para produção, apenas protótipo acadêmico
 * author: guilherme abreu
 */
@Component // marca a classe como componente gerenciado pelo spring
public class TokenService {

    private final Map<String, String> tokenToUser = new ConcurrentHashMap<>(); // mapa token -> username
    private final Map<String, String> tokenToRole = new ConcurrentHashMap<>(); // mapa token -> role

    public String issueToken(String username, String role) {
        String token = UUID.randomUUID().toString(); // gera token aleatório
        tokenToUser.put(token, username); // associa token ao username
        tokenToRole.put(token, role); // associa token à role
        return token; // retorna o token gerado
    }

    public String getUsername(String token) {
        return tokenToUser.get(token); // retorna o username associado ao token
    }

    public String getRole(String token) {
        return tokenToRole.get(token); // retorna a role associada ao token
    }

    public boolean validate(Str
