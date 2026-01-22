package fstop.auth;

import fstop.auth.dto.AuthRequest;
import fstop.auth.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

/**
 * @author Tonny Santana
 * @date 20/01/2026 05:18
 * @since 1.0.0
 */

@RestController
@RequestMapping
public class AuthController {
    
    private JwtEncoder jwtEncoder;
    
    public AuthController(JwtEncoder jwtEncoder, AuthService authService) {
        this.jwtEncoder = jwtEncoder;
        this.authService = authService;
    }
    
    private AuthService authService;
    
    @PostMapping("/login")
    public final ResponseEntity login(@RequestBody AuthRequest request) {
        
        var user = authService.findUserByUserName(request.userName());
        
        if (!authService.isLoginCorrect(request, user.orElseThrow()) || user.isEmpty()) {
            throw new BadCredentialsException("Dados inválidos.");
        }
        
        var now = Instant.now();
        var expiresIn = 300L;
        
        List<String> roles = List.of(user
                .get()
                .getRole().name());
        
        var claims = JwtClaimsSet
                .builder()
                .issuer("backend")
                .subject(user
                        .orElseThrow()
                        .getId()
                        .toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("roles", roles)
                .build();
        
        var jwtValue = jwtEncoder
                .encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
        
        return ResponseEntity.ok(new AuthResponse(jwtValue, expiresIn, user
                .orElseThrow()
                .getId()));
    }
    
}
