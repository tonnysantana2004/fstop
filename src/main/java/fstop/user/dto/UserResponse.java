package fstop.user.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fstop.user.address.dto.AddressResponse;
import fstop.user.document.dto.DocumentResponse;
import fstop.user.infrastructure.UserRoleEnum;
import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Data
@JsonPropertyOrder({ "id", "userName", "firstName", "lastName", "email","phone","profileImage", "document", "address", "role" })
public class UserResponse {
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String profileImage;
    private DocumentResponse document;
    private AddressResponse address;
    private UserRoleEnum role;
}
