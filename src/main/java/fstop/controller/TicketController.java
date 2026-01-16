package fstop.controller;

import fstop.business.dto.request.TicketRequestDTO;
import fstop.business.dto.response.TicketResponseDTO;
import fstop.business.service.TicketService;
import fstop.infrastructure.entity.Ticket;
import fstop.infrastructure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    
    @Autowired
    TicketService ticketService;
    
    @GetMapping
    public ResponseEntity findById(@RequestParam Integer id) {
        try {
            
            TicketResponseDTO responseDTO = ticketService.findById(id);
            return ResponseEntity.ok(responseDTO);
            
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Erro.");
        }
        
    }
    
    @PostMapping
    public ResponseEntity saveUser(@RequestBody Ticket ticket) {
        try {
            
            TicketResponseDTO responseDTO = ticketService.save(ticket);
            return ResponseEntity.ok(responseDTO);
            
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Erro.");
        }
        
    }

}
