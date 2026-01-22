package fstop.user;

import fstop.response.ResponseService;
import fstop.user.dto.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Object create(@RequestBody UserRequest request) {
        
        var userInLiST = new ArrayList<>();
        userInLiST.add(this.userService.create(request));
        
        return ResponseService.success("Novo usuário criado.", userInLiST);
    }
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'EMPLOYEE')")
    public Object findAll() {
        var users = this.userService.findAll();
        return ResponseService.success("Usuários encontrados.", users);
    }
    
    @GetMapping("/{userId}")
    public Object findById(@PathVariable UUID userId) {
        
        var userInLiST = new ArrayList<>();
        userInLiST.add(this.userService.findById(userId));
        
        return ResponseService.success("Usuário encontrado.", userInLiST);
    }
    
    @PutMapping("/{userId}")
    public Object update(@PathVariable UUID userId, @RequestBody UserRequest request) {
        
        var userInLiST = new ArrayList<>();
        userInLiST.add(this.userService.update(request, userId));
        
        return ResponseService.success("Usuário encontrado.", userInLiST);
    }
    
    @DeleteMapping("/{userId}")
    public Object delete(@PathVariable UUID userId) throws Exception {
        
        this.userService.deleteById(userId);
        
        return ResponseService.success("Exclusão sucessedida.", null);
    }
}
