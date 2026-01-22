package fstop.user.document.dto;

import fstop.user.document.infrastructure.DocumentEntity;
import org.mapstruct.Mapper;
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
    
    DocumentEntity toEntity(DocumentRequest request);
    DocumentResponse toResponse(DocumentEntity entity);
    List<DocumentResponse> toList(List<DocumentEntity> list);
    
    void mergeEntity(DocumentRequest request, @MappingTarget DocumentEntity entity);
    
}
