package fstop.ticket;

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
public class TicketController {
    
    @Autowired
    TicketService service;
    
    @PostMapping
    public final ResponseEntity<TicketResponseDTO> create(@RequestBody TicketRequestDTO ticket) {
        var responseDTO = this.service.save(ticket);
        return ResponseEntity.ok(responseDTO);
    }
    
    @GetMapping
    public final ResponseEntity<List<TicketResponseDTO>> list() {
        var listResponseDTO = this.service.findAll();
        return ResponseEntity.ok(listResponseDTO);
    }
    
    @GetMapping("/{id}")
    public final ResponseEntity<TicketResponseDTO> findById(@PathVariable Long id) {
        var responseDTO = this.service.findById(id);
        return ResponseEntity.ok(responseDTO);
    }
    
    @DeleteMapping("/{id}")
    public final ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity
                .ok()
                .build();
    }
    
}
