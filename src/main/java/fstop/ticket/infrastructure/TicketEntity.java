package fstop.ticket.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fstop.BaseEntity;
import fstop.ticket.message.MessageEntity;
import fstop.ticket.category.TicketCategoryEntity;
import fstop.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:33
 * @since 1.0.0
 */

@Data
@Entity
@Table(name= "tickets")
public class TicketEntity extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "issuer_id")
    private UserEntity issuer;
    
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private UserEntity assignee;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private TicketCategoryEntity category;
    
    @OneToMany(mappedBy = "ticket")
    @JsonIgnore
    private List<MessageEntity> messages;
    
    private String title;
    private String description;
    private TicketStatus status = TicketStatus.OPEN;
    private TicketPriority priority = TicketPriority.LOW;
}
