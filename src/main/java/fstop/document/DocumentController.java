package fstop.document;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:19
 * @since 1.0.0
 */

@RestController
@RequestMapping("/documents")
public class DocumentController {
    
    @Autowired
    private DocumentService service;
    
    @GetMapping("/{id}")
    public final ResponseEntity<DocumentResponseDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
        
    }
    
    @PostMapping
    public final ResponseEntity<DocumentResponseDTO> create(@RequestBody DocumentRequestDTO requestDTO) {
        return ResponseEntity.ok(service.create(requestDTO));
    }
    
    @PutMapping("/{id}")
    public final ResponseEntity<DocumentResponseDTO> update(@RequestBody DocumentRequestDTO requestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(requestDTO,id));
    }
}
