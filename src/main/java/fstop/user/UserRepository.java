package fstop.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
   Optional<UserEntity> findByEmail(String email);
   
   @Transactional
    void deleteByEmail(String email);
    
}
