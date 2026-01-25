package fstop.product.category.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 25/01/2026 05:22
 * @since 1.0.0
 */
@Data
public class ProductCategoryResponse {
    private UUID id;
    private String title;
    private String description;
}
