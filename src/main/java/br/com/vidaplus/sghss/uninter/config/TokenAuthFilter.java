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
 * filtro que valida o token enviado no header x-auth-token
 * e define a autenticação no contexto do spring security
 */

public class TokenAuthFilter extends OncePerRequestFilter {

    private final TokenService tokenService; // serviço que valida e extrai informações do token
    private final String headerName = "x-auth-token"; // nome do header onde o token deve ser enviado

    public TokenAuthFilter(TokenService tokenService) {
        this.tokenService = tokenService; // injeta o serviço de token no filtro
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(headerName); // pega o token do header da requisição

        if (token != null && tokenService.validate(token)) { // verifica se o token existe e é válido
            String username = tokenService.getUsername(token); // extrai o nome do usuário do token
            String role = tokenService.getRole(token); // extrai a função/role do usuário do token

            // cria um objeto de autenticação com username, sem senha e com a role do usuário
            var auth = new UsernamePasswordAuthenticationToken(username, null, List.of(new SimpleGrantedAuthority(role)));

            // seta a autenticação no contexto de segurança do spring
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        // continua a execução da cadeia de filtros
        filterChain.doFilter(request, response);
    }
}
