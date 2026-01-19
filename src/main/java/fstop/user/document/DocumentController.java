package fstop.user.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:19
 * @since 1.0.0
 */

@RestController
@RequestMapping("/users/{userId}/document")
public class DocumentController {
    
    @Autowired
    private DocumentService service;
    
    @GetMapping()
    public final ResponseEntity getUserDocument(@PathVariable Long userId) {
        
        return ResponseEntity.ok(service.getUserDocument(userId));
        
    }
    
    @PostMapping
    public final ResponseEntity<DocumentResponseDTO> create(@RequestBody DocumentRequestDTO requestDTO, @PathVariable Long userId) {
        return ResponseEntity.ok(service.create(requestDTO, userId));
    }
    
    @PutMapping()
    public final ResponseEntity<DocumentResponseDTO> update(@RequestBody DocumentRequestDTO requestDTO, @PathVariable Long userId) {
        return ResponseEntity.ok(service.update(requestDTO, userId));
    }
}
