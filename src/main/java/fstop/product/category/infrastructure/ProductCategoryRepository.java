package fstop.product.category.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 25/01/2026 05:27
 * @since 1.0.0
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, UUID> {}