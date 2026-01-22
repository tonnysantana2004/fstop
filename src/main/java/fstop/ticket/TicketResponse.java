package fstop.ticket;

import fstop.ticket.category.TicketCategoryResponse;
import fstop.user.UserEntity;
import fstop.user.UserResponseDTO;
import lombok.Data;

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
