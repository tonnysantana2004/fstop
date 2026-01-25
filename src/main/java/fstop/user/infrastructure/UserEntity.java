package fstop.user.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fstop.BaseEntity;
import fstop.ticket.infrastructure.TicketEntity;
import fstop.user.address.infrastructure.AddressEntity;
import fstop.user.document.infrastructure.DocumentEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    
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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private DocumentEntity document;
    
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private AddressEntity address;
    
    @OneToMany(mappedBy = "issuer")
    @JsonIgnore
    private List<TicketEntity> tickets;
    
}
