package fstop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserController {
    
    private final  UserService userService;
    private final PasswordEncoder passwordEncoder;
    
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping
    @Transactional
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO requestDTO) {
        
        requestDTO.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        
        return ResponseEntity.ok(this.userService.save(requestDTO));
    }
    
    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity findAll() {
        
        return ResponseEntity.ok( this.userService.findAll() );
    }
    
    @GetMapping("/{userId}")
    public final ResponseEntity<UserResponseDTO> findById(@PathVariable UUID userId) {
        return ResponseEntity.ok(this.userService.findById(userId));
    }
    
    @PutMapping("/{userId}")
    public final ResponseEntity<UserResponseDTO> update(@PathVariable UUID userId, @RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok(this.userService.update(requestDTO, userId));
    }
    
    @DeleteMapping("/{userId}")
    public final ResponseEntity<Void> delete(@PathVariable UUID userId) {
        this.userService.deleteById(userId);
        return ResponseEntity
                .ok()
                .build();
    }
}
