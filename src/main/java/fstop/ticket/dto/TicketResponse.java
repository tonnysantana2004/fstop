package fstop.ticket.dto;

import fstop.ticket.infrastructure.TicketPriority;
import fstop.ticket.infrastructure.TicketStatus;
import fstop.ticket.category.TicketCategoryResponse;
import fstop.ticket.message.MessageResponse;
import fstop.user.UserResponseDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 21/01/2026 06:00
 * @since 1.0.0
 */
@Data
public class TicketResponse {
    
    private UUID id;
    private UserResponseDTO issuer;
    private UserResponseDTO assignee;
    private TicketCategoryResponse category;
    
    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;
}
