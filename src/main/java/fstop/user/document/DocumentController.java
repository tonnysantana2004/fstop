package fstop.user.document;

import fstop.response.ResponseService;
import fstop.user.document.dto.DocumentRequest;
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
        return  ResponseService.success("Documento recuperado.", service.getUserDocument(userId));
    }
    
    @PutMapping()
    public final Object update(@RequestBody DocumentRequest request, @PathVariable UUID userId) {
        return ResponseService.success("Documento atualizado.", service.update(request, userId) );
    }
}
