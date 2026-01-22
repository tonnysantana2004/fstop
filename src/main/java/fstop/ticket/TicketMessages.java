package fstop.ticket;

import fstop.BaseClass;
import fstop.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:43
 * @since 1.0.0
 */

@Data
@Entity
@Table(name = "ticket_messages")
public class TicketMessages extends BaseClass {
    
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticket;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity authorId;
    
    private String content;
    
}
