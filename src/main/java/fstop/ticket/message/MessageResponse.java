package fstop.ticket.message;

import fstop.ticket.dto.TicketResponse;
import fstop.user.UserResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 22/01/2026 04:50
 * @since 1.0.0
 */
@Data
public class MessageResponse {
    private UUID id;
    private UserResponseDTO author;
    private String content;
    private LocalDateTime createdAt;
    private TicketResponse ticket;
}
