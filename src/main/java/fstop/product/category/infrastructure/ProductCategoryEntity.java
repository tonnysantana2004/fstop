package fstop.product.category.infrastructure;

import fstop.BaseEntity;
import fstop.product.infrastructure.ProductEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 25/01/2026 05:20
 * @since 1.0.0
 */
@Entity
@Data
@Table(name = "product_categories")
public class ProductCategoryEntity extends BaseEntity {
    private String title;
    private String description;

    @ManyToMany
    private List<ProductEntity> products;
}
