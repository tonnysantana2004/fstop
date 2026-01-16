package fstop.business.dto.request;

import fstop.infrastructure.entity.User;
import lombok.Data;

@Data
public class UserRequestDTO {
    
    private Integer id;
    private String userName;
    
    public UserRequestDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
    }
    
}
