package fstop.user.dto;

import fstop.user.infrastructure.UserEntity;
import org.mapstruct.*;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    
    UserEntity toEntity(UserRequest request);
    
    UserResponse toResponse(UserEntity entity);
    
    List<UserResponse> toList(List<UserEntity> list);
    
    void mergeEntity(UserRequest request, @MappingTarget UserEntity entity);
    

}
