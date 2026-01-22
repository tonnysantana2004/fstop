package fstop.ticket;

import fstop.BaseClass;
import fstop.ticket.category.TicketCategoryEntity;
import fstop.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:33
 * @since 1.0.0
 */

@Data
@Entity
@Table(name= "tickets")
public class TicketEntity extends BaseClass {
    
    @ManyToOne
    @JoinColumn(name = "issuer_id")
    private UserEntity issuer;
    
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private UserEntity assignee;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private TicketCategoryEntity category;
    
    private String title;
    private String description;
    private TicketStatus status = TicketStatus.OPEN;
    private TicketPriority priority = TicketPriority.LOW;
}
