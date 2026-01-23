package fstop.products;

import fstop.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 23/01/2026 16:49
 * @since 1.0.0
 */

@Entity
@Data
public class ProductEntity extends BaseEntity {
    // @OneToMany(mappedBy = "product")
    // @Column(name="category_id")
    // public ProductCategoryEntity category;
    private String title;
    @Column(name = "short_description")
    private String shortDescription;
    private String content;
    private String price;
    @Column(name = "sale_price")
    private String salePrice;
    
}
