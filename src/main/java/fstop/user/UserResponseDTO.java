package fstop.user;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fstop.user.address.AddressResponseDTO;
import fstop.user.document.DocumentResponseDTO;
import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Data
@JsonPropertyOrder({ "userId", "userName", "firstName", "lastName", "email","phone","avatar", "document", "address", "role" })
public class UserResponseDTO {
    private UUID userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String avatar;
    private DocumentResponseDTO document;
    private AddressResponseDTO address;
    private UserRoleEnum role;
}
