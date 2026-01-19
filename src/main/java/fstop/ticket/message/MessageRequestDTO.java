package fstop.ticket.message;

import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 06:37
 * @since 1.0.0
 */

@Data
public class MessageRequestDTO {
    private Long ticketId;
    private String message;
}
