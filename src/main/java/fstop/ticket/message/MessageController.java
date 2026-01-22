package fstop.ticket.message;

import fstop.response.ResponseService;
import fstop.ticket.message.dto.MessageRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 22/01/2026 04:53
 * @since 1.0.0
 */

@RestController
@RequestMapping("/tickets/{ticketId}/messages")
@AllArgsConstructor
public class MessageController {
    
    MessageService service;
    
    @GetMapping
    public Object list(@PathVariable UUID ticketId) {
        return ResponseService.success("Mensagens encontradas", service.findAll(ticketId));
    }
    
    @PostMapping
    public Object create(@RequestBody MessageRequest request, @PathVariable UUID ticketId) {
        return  ResponseService.success("Mensagem Criada", service.create(request, ticketId) );
    }
    
}
