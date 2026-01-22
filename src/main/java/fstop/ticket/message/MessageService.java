package fstop.ticket.message;

import fstop.ticket.infrastructure.TicketRepository;
import fstop.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 22/01/2026 05:04
 * @since 1.0.0
 */
@Service
@AllArgsConstructor
public class MessageService {
    
    public MessageRepository repository;
    public MessageMapper mapper;
    public UserRepository userRepository;
    public TicketRepository ticketRepository;
    
    public Object findAll(UUID ticketId) {
        var ticket = ticketRepository.findById(ticketId).orElseThrow();
        return mapper.toList(ticket.getMessages());
    }
    
    public Object create(MessageRequest request, UUID ticketId) {
        
        var messageEntity = mapper.toEntity(request);
        // Ticket
        var ticket = ticketRepository.findById(ticketId).orElseThrow();
        messageEntity.setTicket(ticket);
        
        // User
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getPrincipal();
        assert jwt != null;
        String userId = jwt.getClaimAsString("sub");
        var author = userRepository.findById(UUID.fromString(userId)).orElseThrow();
        
        messageEntity.setAuthor(author);
        
        return  mapper.toResponse( repository.save( messageEntity ) ) ;
    }
    
}
