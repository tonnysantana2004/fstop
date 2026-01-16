package fstop.controller;

import fstop.business.dto.request.UserRequestDTO;
import fstop.business.service.UserService;
import fstop.infrastructure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity get(@RequestParam Integer id) {
        try {
            
            UserRequestDTO user = this.userService.findById(id);
            return ResponseEntity.ok(user);
            
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Erro.");
        }
    }
    
    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user) {
        try {
            
            this.userService.save(user);
            return ResponseEntity.ok(user);
            
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Erro.");
        }
        
    }
    
    @PutMapping
    public ResponseEntity updateUser(@RequestParam Integer id, @RequestBody User user) {
        try {
            user.setId(id);
            
            this.userService.save(user);
            return ResponseEntity.ok(user);
            
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Erro." + e);
        }
    }
}
