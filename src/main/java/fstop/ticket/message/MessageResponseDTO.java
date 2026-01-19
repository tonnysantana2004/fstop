package fstop.ticket.message;

import fstop.ticket.TicketEntity;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 06:28
 * @since 1.0.0
 */

@Data
public class MessageResponseDTO {
    
    private Long id;
    private TicketEntity ticket;
    private String message;
    
}
