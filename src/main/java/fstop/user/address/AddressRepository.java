package fstop.user.address;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:23
 * @since 1.0.0
 */
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    
    AddressEntity  findByUserId(Long userId);
}
