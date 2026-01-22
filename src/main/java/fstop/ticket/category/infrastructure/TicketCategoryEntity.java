package fstop.ticket.category.infrastructure;

import fstop.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:39
 * @since 1.0.0
 */

@Entity
@Data
@Table(name = "ticket_categories")
public class TicketCategoryEntity extends BaseEntity {
    private String name;
    
    public TicketCategoryEntity(String name) {
        this.name = name;
    }
    
    public TicketCategoryEntity() {
    
    }
}
