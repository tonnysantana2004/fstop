package fstop.auth;

import fstop.auth.dto.AuthRequest;
import fstop.exception.user.InvalidUserCredentialsException;
import fstop.exception.user.UserNotFoundException;
import fstop.user.dto.UserMapper;
import fstop.user.infrastructure.UserEntity;
import fstop.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 26/01/2026 04:36
 * @since 1.0.0
 */
@RequiredArgsConstructor
@Component
public class AuthProvider {

    private final JwtDecoder jwtDecoder;
    private final JwtEncoder jwtEncoder;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    
    public void validateCredentials(AuthRequest request) {

        var user = userRepository.findByEmail(request.email());
        
        if (user.isEmpty()) {
            throw new InvalidUserCredentialsException();
        }
        
        String currentPassword = user.get().getPassword();
        boolean passwordIsCorrect = passwordEncoder.matches(request.password(), currentPassword);
        
        if ( ! passwordIsCorrect ) {
            throw new InvalidUserCredentialsException();
        }
    }
    
    // Só vai passar por aqui quem já tiver um token, e estiver tentando fazer uma requisição com autorização
    public Authentication validateToken(String token) {
        
        // Se o token não foi gerado com a chave secreta do servidor,
        // ou já houver expirado, o processo inteiro é cancelado
        var decoded = jwtDecoder.decode(token);
        
        var userId = decoded.getClaimAsString("sub");
        var user = userRepository.findById(UUID.fromString(userId)).orElseThrow(UserNotFoundException::new);
        var userResponse = userMapper.toResponse(user);
        
        List<String> roles = decoded.getClaimAsStringList("roles");
        
        var authorities = roles.stream()
                               .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                               .toList();
        
        return new UsernamePasswordAuthenticationToken(
                userResponse,
                null,
                authorities
        );
    }
    
    public String createToken(UserEntity user) {
        var now = Instant.now();
        var expiresIn = 300L;
        
        List<String> roles = List.of(user.getRole().name());
        
        var claims = JwtClaimsSet
                .builder()
                .issuer("backend")
                .subject(user.getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("roles", roles)
                .build();
        
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
    
}
