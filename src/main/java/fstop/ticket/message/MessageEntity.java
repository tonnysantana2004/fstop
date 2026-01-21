package fstop.ticket.message;

import fstop.ticket.TicketEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

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
    @Column(name = "message_id")
    private Long messageId;
    
    @ManyToOne
    @JoinColumn(name = "ticket_id",nullable = false)
    private TicketEntity ticket;
    
    @Column(nullable = false)
    private UUID IssuerUserId;
    
    @Column(length = 2000)
    private String content;
}
