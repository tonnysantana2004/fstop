package fstop.user.address.infrastructure;

import fstop.BaseEntity;
import fstop.user.infrastructure.UserEntity;
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
public class AddressEntity extends BaseEntity {
    
    private String street;
    private String neighborhood;
    private String city;
    private String country;
    private Short number;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    
    @Column(name = "address_complement")
    private String addressComplement;
    
    @Column(name = "postal_code")
    private String postalCode;
}
