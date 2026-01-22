package fstop.ticket.dto;

import fstop.ticket.infrastructure.TicketPriority;
import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:54
 * @since 1.0.0
 */

@Data
public class TicketRequest {
    private UUID categoryId;
    private String title;
    private String description;
    private TicketPriority priority;
}
