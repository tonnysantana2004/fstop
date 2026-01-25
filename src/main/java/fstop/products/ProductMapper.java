package fstop.products;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 23/01/2026 17:01
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductEntity toEntity(ProductRequest request);
    ProductResponse toResponse(ProductEntity entity);
    List<ProductResponse> toList(List<ProductEntity> list);
    
    void mergeEntity (ProductRequest request, @MappingTarget ProductEntity entity);
}
