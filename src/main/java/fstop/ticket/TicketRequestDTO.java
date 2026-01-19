package fstop.ticket;

import com.fasterxml.jackson.annotation.JsonProperty;
import fstop.user.UserEntity;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Data
public class TicketRequestDTO {
    
    private String description;
    private Long userId;
    
}
