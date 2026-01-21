package fstop.user.document;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:23
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DocumentMapper {
    
    @Mapping(target = "documentId", ignore = true)
    DocumentEntity toEntity(DocumentRequestDTO requestDTO);
    
    DocumentResponseDTO toResponse(DocumentEntity entity);
    
    void mergeEntity(DocumentRequestDTO requestDTO, @MappingTarget DocumentEntity entity);
    
}
