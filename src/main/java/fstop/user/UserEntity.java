package fstop.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fstop.user.address.AddressEntity;
import fstop.user.document.DocumentEntity;
import fstop.ticket.TicketEntity;
import fstop.user.role.RoleEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
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
    private DocumentEntity document;
    
    @OneToOne(mappedBy = "user")
    private AddressEntity address;
    
    @ManyToOne
    private RoleEntity role;
    
}
