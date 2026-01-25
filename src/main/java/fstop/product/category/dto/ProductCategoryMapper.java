package fstop.product.category.dto;

import fstop.product.category.infrastructure.ProductCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 25/01/2026 05:28
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductCategoryMapper {
    ProductCategoryEntity toEntity(ProductCategoryRequest request);
    ProductCategoryResponse toResponse(ProductCategoryResponse response);
    List<ProductCategoryResponse> toList(List<ProductCategoryEntity> entity);
   
    void mergeEntity(ProductCategoryRequest request,  @MappingTarget ProductCategoryEntity entity);
    
}
