package fstop.user;

import fstop.response.ApiResponseEntity;
import fstop.response.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok(this.userService.create(requestDTO));
    }
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'EMPLOYEE')")
    public ResponseEntity<ApiResponseEntity<List<UserResponseDTO>>> findAll() {
        return ResponseService.success("Usuários encontrados.", this.userService.findAll());
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable UUID userId) {
        return ResponseEntity.ok(this.userService.findById(userId));
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable UUID userId, @RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok(this.userService.update(requestDTO, userId));
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity delete(@PathVariable UUID userId) {
        
        try {
            
            this.userService.deleteById(userId);
            
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e);
        }
        
        return ResponseEntity
                .ok()
                .build();
    }
}
