package fstop.ticket;

import lombok.AllArgsConstructor;
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
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {
    
    TicketService service;
    
    @PostMapping
    public final ResponseEntity<TicketResponseDTO> create(@RequestBody TicketRequestDTO ticket) {
        return ResponseEntity.ok(this.service.save(ticket));
    }
    
    @GetMapping
    public final ResponseEntity<List<TicketResponseDTO>> list() {
        return ResponseEntity.ok(this.service.findAll());
    }
    
    @GetMapping("/{id}")
    public final ResponseEntity<TicketResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findById(id));
    }
    
    @DeleteMapping("/{id}")
    public final ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity
                .ok()
                .build();
    }
    
}
