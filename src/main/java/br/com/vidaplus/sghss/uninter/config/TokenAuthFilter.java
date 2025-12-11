package br.com.vidaplus.sghss.uninter.config;

import br.com.vidaplus.sghss.uninter.util.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/*
 * filtro simples que valida o header x-auth-token e seta authentication no contexto
 * author: guilherme abreu
 * comentários em minúsculas
 */
public class TokenAuthFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final String headerName = "x-auth-token";

    public TokenAuthFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(headerName);
        if (token != null && tokenService.validate(token)) {
            String username = tokenService.getUsername(token);
            String role = tokenService.getRole(token);
            var auth = new UsernamePasswordAuthenticationToken(username, null, List.of(new SimpleGrantedAuthority(role)));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}
