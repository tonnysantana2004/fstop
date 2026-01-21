package fstop.user.address;

import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:33
 * @since 1.0.0
 */

@Data
public class AddressRequestDTO {
    private String street;
    private String neighborhood;
    private Long number;
    private String postalCode;
}
