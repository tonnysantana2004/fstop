package fstop.ticket;

import fstop.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class TicketEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @Column(nullable = false)
    public String title;
    
    @Column(nullable = false)
    public String description;
}
