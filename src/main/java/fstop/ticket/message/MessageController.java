package fstop.ticket.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 19/01/2026 06:20
 * @since 1.0.0
 */

@RestController
@RequestMapping("/tickets/{ticketId}/messages")
public class MessageController {
    
    @Autowired
    private MessageService service;
    
    @GetMapping
    public final ResponseEntity<List<MessageResponseDTO>> findAllByTicketId(@PathVariable Long ticketId) {
        return ResponseEntity.ok(this.service.findAllByTicketId(ticketId));
    }
    
    @PostMapping
    public final ResponseEntity<MessageResponseDTO> create(@RequestBody MessageRequestDTO requestDTO) {
        return ResponseEntity.ok(this.service.create(requestDTO));
    }
}
