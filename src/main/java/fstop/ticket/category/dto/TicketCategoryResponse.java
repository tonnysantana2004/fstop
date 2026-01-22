package fstop.ticket.category.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 21/01/2026 07:59
 * @since 1.0.0
 */
@Data
public class TicketCategoryResponse {
    private UUID id;
    private String name;
}
