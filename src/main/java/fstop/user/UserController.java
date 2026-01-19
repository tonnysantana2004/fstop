package fstop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserMapper mapper;
    
    @PostMapping()
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok(this.userService.save(requestDTO));
    }
    
    @GetMapping
    public final ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }
    
    @GetMapping("/{id}")
    public final ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.findById(id));
    }
    
    @PutMapping("/{id}")
    public final ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok(this.userService.update(requestDTO, id));
    }
    
    @DeleteMapping("/{id}")
    public final ResponseEntity<Void> delete(@PathVariable Long id){
        this.userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
