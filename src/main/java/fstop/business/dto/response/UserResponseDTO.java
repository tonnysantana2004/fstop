package fstop.business.dto.response;

import fstop.infrastructure.entity.User;
import lombok.Data;

@Data
public class UserResponseDTO {
    
    private Integer id;
    private String userName;
    
    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
    }
    
}
