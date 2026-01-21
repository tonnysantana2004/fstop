package fstop.auth.dto;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 20/01/2026 06:00
 * @since 1.0.0
 */
public record AuthResponse(String accessToken, Long expiresIn, UUID userId) {
}
