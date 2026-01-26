package fstop.auth.dto;

import fstop.user.dto.UserResponse;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 26/01/2026 03:53
 * @since 1.0.0
 */
public record AuthResponse(String token, UserResponse user) {}