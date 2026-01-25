package fstop.product.infrastructure;

import fstop.BaseEntity;
import fstop.product.category.infrastructure.ProductCategoryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 23/01/2026 16:49
 * @since 1.0.0
 */

@Entity
@Data
@Table(name = "products")
public class ProductEntity extends BaseEntity {

    private String title;
    @Column(name = "short_description")
    private String shortDescription;
    private String content;
    private String price;
    @Column(name = "sale_price")
    private String salePrice;
    
    @ManyToMany
    private List<ProductCategoryEntity> categories;
    
}
