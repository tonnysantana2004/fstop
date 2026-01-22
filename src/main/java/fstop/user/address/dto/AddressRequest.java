package fstop.user.address.dto;

import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:33
 * @since 1.0.0
 */

@Data
public class AddressRequest {
    private String street;
    private String neighborhood;
    private Long number;
    private String postalCode;
}
