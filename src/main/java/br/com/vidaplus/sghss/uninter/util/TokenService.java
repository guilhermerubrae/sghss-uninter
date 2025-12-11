package br.com.vidaplus.sghss.uninter.util;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
 * serviço simples que emite tokens temporários e mantém relação token -> username,role
 * não é produção, apenas protótipo para o projeto acadêmico
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Component
public class TokenService {

    private final Map<String, String> tokenToUser = new ConcurrentHashMap<>();
    private final Map<String, String> tokenToRole = new ConcurrentHashMap<>();

    public String issueToken(String username, String role) {
        String token = UUID.randomUUID().toString();
        tokenToUser.put(token, username);
        tokenToRole.put(token, role);
        return token;
    }

    public String getUsername(String token) {
        return tokenToUser.get(token);
    }

    public String getRole(String token) {
        return tokenToRole.get(token);
    }

    public boolean validate(String token) {
        return tokenToUser.containsKey(token);
    }
}
