package fstop.ticket.message;

import fstop.auth.AuthService;
import fstop.exception.ticket.TicketNotFoundException;
import fstop.ticket.message.infrastructure.MessageRepository;
import fstop.ticket.infrastructure.TicketRepository;
import fstop.ticket.message.dto.MessageMapper;
import fstop.ticket.message.dto.MessageRequest;
import fstop.user.infrastructure.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
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
        var ticket = ticketRepository.findById(ticketId).orElseThrow(TicketNotFoundException::new);
        return mapper.toList(ticket.getMessages());
    }
    
    public Object create(MessageRequest request, UUID ticketId) {
        var messageEntity = mapper.toEntity(request);
        var ticket = ticketRepository.findById(ticketId).orElseThrow(TicketNotFoundException::new);
        messageEntity.setTicket(ticket);
        messageEntity.setAuthor(AuthService.getAuthenticatedUser());
        return mapper.toList(List.of(repository.save(messageEntity)));
    }
    
}
