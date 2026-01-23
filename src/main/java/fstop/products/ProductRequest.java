package fstop.products;

import jakarta.persistence.Column;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 23/01/2026 17:02
 * @since 1.0.0
 */
@Data
public class ProductRequest {
    private String title;
    @Column(name = "short_description")
    private String shortDescription;
    private String content;
    private String price;
    @Column(name = "sale_price")
    private String salePrice;
}
