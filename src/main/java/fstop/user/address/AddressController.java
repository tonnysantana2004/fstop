package fstop.user.address;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:24
 * @since 1.0.0
 */

@RestController
@RequestMapping("/users/{userId}/address")
@AllArgsConstructor
public class AddressController {
    
    private AddressService service;
    
    @GetMapping
    public final ResponseEntity<AddressResponseDTO> getUserAddress(@PathVariable UUID userId) {
        return ResponseEntity.ok( service.getResponseEntity(userId) ) ;
    }
    
    @PutMapping
    public final ResponseEntity<AddressResponseDTO> update(@RequestBody AddressRequestDTO requestDTO, @PathVariable UUID userId) {
        return ResponseEntity.ok(service.update(requestDTO,userId) );
    }

}
