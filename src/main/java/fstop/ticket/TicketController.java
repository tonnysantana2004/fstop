package fstop.ticket;

import fstop.response.ResponseService;
import fstop.ticket.dto.TicketRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Object findAll() {
        return ResponseService.success("Tickets Encontrados", ticketService.findAll());
    }
    
    @GetMapping("{ticketId}")
    public Object findeById(@PathVariable UUID ticketId) {
        return ResponseService.success("Ticket Encontrado", ticketService.findById(ticketId));
    }
    
    @GetMapping("/categories")
    public Object findAllCategories() {
        return ResponseService.success("Categorias de Tickets Encontradas", ticketService.findAllCategories());
    }
    
    @PostMapping
    public Object create(@RequestBody TicketRequest request) {
        var list = new ArrayList<>();
        list.add(ticketService.create(request));
        return ResponseService.success("Ticket Criado", list);
    }
    
    @DeleteMapping("/{ticketId}")
    public Object delete(@PathVariable UUID ticketId) {
        ticketService.delete(ticketId);
        return ResponseService.success("Ticket deletado", null);
    }
    
    
}
