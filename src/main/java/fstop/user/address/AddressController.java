package fstop.user.address;

import fstop.response.ResponseService;
import fstop.user.address.dto.AddressRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public final Object getUserAddress(@PathVariable UUID userId) {
        return ResponseService.success("Endereço recuperado.", service.findByUserId(userId));
    }
    
    @PutMapping
    public final Object update(@RequestBody AddressRequest request, @PathVariable UUID userId) {
        return ResponseService.success("Endereço Atualizado.", service.update(request,userId));
    }

}
