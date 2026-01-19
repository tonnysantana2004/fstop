package fstop.user.document;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:23
 * @since 1.0.0
 */
@Mapper(componentModel = "spring")
public interface DocumentMapper {
    
    @Mapping(target = "id", ignore = true)
    DocumentEntity toEntity(DocumentRequestDTO requestDTO);
    
    @Mapping(target = "userId", source = "user.id")
    DocumentResponseDTO toResponse(DocumentEntity entity);
    
    List<DocumentResponseDTO> toResponseList(List<DocumentEntity> list);
    
    void mergeEntity(DocumentRequestDTO requestDTO, @MappingTarget DocumentEntity entity);
    
}
