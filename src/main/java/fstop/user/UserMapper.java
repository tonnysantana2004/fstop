package fstop.user;

import org.mapstruct.*;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    
    UserEntity toEntity(UserRequestDTO requestDTO);
    
    UserResponseDTO toResponse(UserEntity entity);
    
    List<UserResponseDTO> toList(List<UserEntity> list);
    
    void mergeEntity(UserRequestDTO requestDTO, @MappingTarget UserEntity entity);
    

}
