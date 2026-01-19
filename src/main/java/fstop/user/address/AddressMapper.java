package fstop.user.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:32
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {
    
    @Mapping(target = "id", ignore = true)
    AddressEntity toEntity(AddressRequestDTO requestDTO);
    
    @Mapping(target = "userId", source = "user.id")
    AddressResponseDTO toResponse(AddressEntity entity);
    
    void mergeEntity(AddressRequestDTO requestDTO, @MappingTarget AddressEntity entity);
    
}
