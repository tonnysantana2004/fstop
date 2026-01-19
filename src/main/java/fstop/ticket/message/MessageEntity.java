package fstop.ticket.message;

import fstop.ticket.TicketEntity;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 06:00
 * @since 1.0.0
 */

@Entity
@Data
@Table(name = "ticket_messages")
public class MessageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ticket_id",nullable = false)
    private TicketEntity ticket;
    
    @Column(length = 2000)
    private String message;
}
