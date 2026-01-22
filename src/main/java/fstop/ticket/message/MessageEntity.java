package fstop.ticket.message;

import fstop.BaseEntity;
import fstop.ticket.infrastructure.TicketEntity;
import fstop.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 22/01/2026 04:40
 * @since 1.0.0
 */
@Entity
@Data
@Table(name = "ticket_messages")
public class MessageEntity extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;
    
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticket;
    
    private String content;
    
}
