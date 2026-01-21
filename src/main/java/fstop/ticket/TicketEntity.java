package fstop.ticket;

import fstop.ticket.message.MessageEntity;
import fstop.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Data
@Entity
@Table(name = "tickets")
public class TicketEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    public Long ticketId;
    
    @Column(nullable = false)
    public String title;
    
    @Column(nullable = false)
    public String description;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    // chore: make this list pageable
    @OneToMany(mappedBy = "ticket")
    private List<MessageEntity> ticketMessage;
}
