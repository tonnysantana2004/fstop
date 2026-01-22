package fstop.ticket.category;

import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 21/01/2026 08:10
 * @since 1.0.0
 */
@Data
public class TicketCategoryRequest {
    private UUID id;
    private String name;
}
