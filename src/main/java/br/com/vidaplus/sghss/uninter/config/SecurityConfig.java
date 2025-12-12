package br.com.vidaplus.sghss.uninter.config;

import br.com.vidaplus.sghss.uninter.util.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final TokenService tokenService; // serviço que valida tokens jwt

    public SecurityConfig(TokenService tokenService) {
        this.tokenService = tokenService; // injeta o serviço de token na configuração
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        TokenAuthFilter filter = new TokenAuthFilter(tokenService); // cria o filtro de autenticação por token

        http.csrf().disable() // desativa proteção csrf para permitir chamadas de api
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/**", "/h2-console/**", "/api/v1/usuarios").permitAll() // libera acesso a login, h2 e cadastro de usuários
                .anyRequest().authenticated() // exige autenticação para todas as outras requisições
            )
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class); // adiciona o filtro de token antes do filtro padrão

        http.headers().frameOptions().disable(); // permite que o h2-console abra em iframe
        return http.build(); // retorna a configuração de segurança pronta
    }
}
