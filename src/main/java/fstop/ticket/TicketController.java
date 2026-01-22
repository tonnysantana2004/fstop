package fstop.ticket;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:48
 * @since 1.0.0
 */

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {
    
    private final TicketService ticketService;
    
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(ticketService.findAll());
    }
    
    @GetMapping("/categories")
    public ResponseEntity findAllCategories() {
        return ResponseEntity.ok(ticketService.findAllCategories());
    }
    
    @PostMapping
    public ResponseEntity create(@RequestBody TicketRequest request) {
        return ResponseEntity.ok(ticketService.create(request));
    }
    
    @DeleteMapping("/{ticketId}")
    public ResponseEntity delete (@PathVariable UUID ticketId) {
        ticketService.delete(ticketId);
        return this.findAll();
        // return ResponseEntity.ok(uuid);
    }
    
    
}
