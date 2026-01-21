package fstop.ticket.message;

import fstop.ticket.TicketEntity;
import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 06:28
 * @since 1.0.0
 */

@Data
public class MessageResponseDTO {
    private Long messageId;
    private Long ticketId;
    private String content;
    private UUID issuerUserId;
}
