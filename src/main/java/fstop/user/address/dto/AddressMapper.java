package fstop.user.address.dto;

import fstop.user.address.infrastructure.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:32
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {
    
    AddressEntity toEntity(AddressRequest request);
    AddressResponse toResponse(AddressEntity entity);
    List<AddressResponse> toList(List<AddressEntity> list);
    
    void mergeEntity(AddressRequest request, @MappingTarget AddressEntity entity);
    
}
