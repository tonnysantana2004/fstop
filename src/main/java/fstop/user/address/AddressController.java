package fstop.user.address;

import fstop.response.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

        var list = new ArrayList<>();
        list.add(service.findByUserId(userId));
        
        return ResponseService.success("Endereço recuperado.", list);
    }
    
    @PutMapping
    public final Object update(@RequestBody AddressRequestDTO requestDTO, @PathVariable UUID userId) {
        
        var list = new ArrayList<>();
        list.add(service.update(requestDTO,userId));
        
        return ResponseService.success("Endereço Atualizado.", list);
    }

}
