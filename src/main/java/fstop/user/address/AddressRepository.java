package fstop.user.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:23
 * @since 1.0.0
 */
public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {

    Optional<AddressEntity> findByUserId(UUID userId);
}
