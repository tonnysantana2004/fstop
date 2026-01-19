package fstop.user;

import lombok.Data;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Data
public class UserResponseDTO {
    
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String avatar;
    
}
