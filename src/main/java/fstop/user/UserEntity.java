package fstop.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fstop.document.DocumentEntity;
import fstop.ticket.TicketEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false, name = "user_name")
    private String userName;
    
    @Column(nullable = false, name = "first_name")
    private String firstName;
    
    @Column(nullable = false, name = "last_name")
    private String lastName;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = true)
    private String phone;
    
    private String password;
    
    private String avatar;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<TicketEntity> tickets;
    
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private DocumentEntity document;
    
}
