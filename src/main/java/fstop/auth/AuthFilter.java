package fstop.auth;

import fstop.response.ResponseService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Tonny Santana
 * @date 26/01/2026 00:48
 * @since 1.0.0
 */

@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
    
    private final AuthProvider authProvider;
    
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        
        // Só vai passar por aqui quem já tiver um token
        // Tudo parece certo!
        if (header != null) {
            String[] authElements = header.split(" ");
            
            if (authElements.length == 2 && "Bearer".equals(authElements[0])) {
                try {
                    
                    // Retorna um objeto que contém o usuário após ser validado
                    // Ou seja, o token enviado por ele foi emitido pelo servidor
                    Authentication userWithValidToken = authProvider.validateToken(authElements[1]);
                    
                    SecurityContextHolder.getContext().setAuthentication(userWithValidToken);
                    
                } catch (AuthenticationException e) {
                    SecurityContextHolder.clearContext();
                    
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    
                    var error = ResponseService.error("invalid_token", null);
                    var mapper = new ObjectMapper();
                    response.getWriter().write(mapper.writeValueAsString(error.getBody()));
                    
                    return;
                }
            }
        }
        
        filterChain.doFilter(request, response);
        
    }
}
