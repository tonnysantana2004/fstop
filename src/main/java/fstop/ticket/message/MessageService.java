package fstop.ticket.message;

import fstop.ticket.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 19/01/2026 06:30
 * @since 1.0.0
 */

@Service
@AllArgsConstructor
public class MessageService {
    
    private MessageRepository repository;
    private MessageMapper mapper;
    private TicketRepository ticketRepository;
    
    public final List<MessageResponseDTO> findAllByTicketId(Long ticketId) {
        return mapper.toList(repository.findAllByTicketId(ticketId));
    }
    
    public final MessageResponseDTO create(MessageRequestDTO requestDTO) {
        
        var entity = mapper.toEntity(requestDTO);
        var ticket = ticketRepository.findById(entity.getTicket().getTicketId()).orElseThrow();
        entity.setTicket(ticket);
        repository.saveAndFlush(entity);
        return mapper.toResponse(entity);
    }
}
