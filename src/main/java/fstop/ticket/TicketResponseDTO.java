package fstop.ticket;

import fstop.user.UserResponseDTO;
import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Data
public class TicketResponseDTO {
    
    private Integer id;
    private String description;
    private UUID userId;
    
}
