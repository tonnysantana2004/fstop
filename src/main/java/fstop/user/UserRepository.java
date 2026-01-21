package fstop.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    
   Optional<UserEntity> findByEmail(String email);
   
   @Transactional
    void deleteByEmail(String email);
    
    Optional<UserEntity> findByUserName(String username);
}
