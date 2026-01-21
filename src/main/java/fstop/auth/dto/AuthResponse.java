package fstop.auth.dto;

/**
 * @author Tonny Santana
 * @date 20/01/2026 06:00
 * @since 1.0.0
 */
public record AuthResponse(String accessToken, Long expiresIn) {
}
