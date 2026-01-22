package fstop.user.document;

import fstop.response.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:19
 * @since 1.0.0
 */

@RestController
@RequestMapping("/users/{userId}/document")
public class DocumentController {
    
    private DocumentService service;
    public DocumentController(DocumentService service) {
        this.service = service;
    }
    
    @GetMapping()
    public final Object getUserDocument(@PathVariable UUID userId) {
        var list = new ArrayList<>();
        list.add(service.getUserDocument(userId) );
        return  ResponseService.success("Documento recuperado.", list);
    }
    
    @PutMapping()
    public final Object update(@RequestBody DocumentRequestDTO requestDTO, @PathVariable UUID userId) {
        var list = new ArrayList<>();
        list.add(service.update(requestDTO, userId));
        return ResponseService.success("Documento recuperado.", list );
    }
}
