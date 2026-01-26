package fstop.auth;

import fstop.auth.dto.AuthRequest;
import fstop.auth.dto.AuthResponse;
import fstop.exception.user.InvalidUserCredentialsException;
import fstop.exception.user.UserNotFoundException;
import fstop.user.UserService;
import fstop.user.dto.UserMapper;
import fstop.user.dto.UserRequest;
import fstop.user.infrastructure.UserEntity;
import fstop.user.infrastructure.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 20/01/2026 05:40
 * @since 1.0.0
 */

@Service
@AllArgsConstructor
public class AuthService {
    
    private final UserMapper userMapper;
    private final UserService userService;
    private final UserRepository userRepository;
    private final AuthProvider authProvider;
    
    public List<AuthResponse> login(AuthRequest request) {
        
        // Usuário existe e o login está correto
        authProvider.validateCredentials(request);
        
        // Pega o usuário
        var user = userRepository.findByEmail(request.email()).orElseThrow();
        
        // Gera um token válido
        var token = authProvider.createToken(user);
        
        // Coloca o token e o usuário no DTO
        var authResponse = new AuthResponse(token, userMapper.toResponse(user));
        
        // Retorna no padrão de lista
        return List.of(authResponse);
    }
    
    public List register(UserRequest request) {
        var user = userService.create(request, false);
        var token = authProvider.createToken(user);
        var authResponse = new AuthResponse(token, userMapper.toResponse(user));
        return List.of(authResponse);
        // return List.of("");
    }
    
    public UserEntity getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userId = jwt.getClaimAsString("sub");
        return userRepository.findById(UUID.fromString(userId)).orElseThrow(UserNotFoundException::new);
    }
    

}
