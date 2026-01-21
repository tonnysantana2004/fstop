package fstop.user.address;

import lombok.Data;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:27
 * @since 1.0.0
 */
@Data
public class AddressResponseDTO {
    private String street;
    private String neighborhood;
    private Long number;
    private String postalCode;
}
