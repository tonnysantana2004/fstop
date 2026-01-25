package fstop.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 23/01/2026 17:00
 * @since 1.0.0
 */
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {}
