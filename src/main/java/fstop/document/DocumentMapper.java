package fstop.document;

import fstop.user.UserMapper;
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
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = UserMapper.class)
public interface DocumentMapper {
    
    @Mapping(target = "id", ignore = true)
    
    // Converter User id para um User, e validar no banco de dados se existe.
    @Mapping(target = "user.id", source = "userId")
    DocumentEntity toEntity(DocumentRequestDTO requestDTO);
    
    DocumentResponseDTO toResponse(DocumentEntity entity);
    
    List<DocumentResponseDTO> toResponseList(List<DocumentEntity> list);
    
    void mergeEntity(DocumentRequestDTO requestDTO, @MappingTarget DocumentEntity entity);
    
}
