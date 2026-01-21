package fstop.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fstop.ticket.TicketEntity;
import fstop.user.address.AddressEntity;
import fstop.user.document.DocumentEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;
    
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
    
    @Column(name = "profile_image")
    private String profileImage;
    
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role = UserRoleEnum.CUSTOMER;
    
    // Entitys
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<TicketEntity> tickets;
    
    // Não há problema deixar eles no frontend
    // já que o único que tem acesso a esse json são usuários admin e gestores
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private DocumentEntity document;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private AddressEntity address;
    
}
