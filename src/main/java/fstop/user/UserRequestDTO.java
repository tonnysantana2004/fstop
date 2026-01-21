package fstop.user;

import lombok.Data;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Data
public class UserRequestDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String avatar;
}
