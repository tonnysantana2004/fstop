package fstop.auth;

import fstop.auth.dto.AuthRequest;
import fstop.response.ResponseService;
import fstop.user.dto.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tonny Santana
 * @date 20/01/2026 05:18
 * @since 1.0.0
 */

@RestController
@RequestMapping
public class AuthController {
    
    private AuthService authService;
    
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/login")
    public final Object login(@RequestBody AuthRequest request) {
        return ResponseService.success(
                "Login bem sucedido.",
                authService.login(request)
        );
    }
    
    @PostMapping("/register")
    public final Object register(@RequestBody UserRequest request) {
        return ResponseService.success(
                "Usuário criado.",
                authService.register(request)
        );
    }
    
}
