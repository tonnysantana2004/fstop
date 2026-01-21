package fstop.user.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fstop.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 09:20
 * @since 1.0.0
 */

@Entity
@Table(name = "addresses")
@Data
public class AddressEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private UserEntity user;
    
    private String street;
    private String neighborhood;
    private String city;
    private String country;
    private Short number;
    
    @Column(name = "address_complement")
    private String addressComplement;
    
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
}
