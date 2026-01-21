package fstop.ticket;

import fstop.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Service
@AllArgsConstructor
public class TicketService {
    
    TicketRepository repository;
    TicketMapper mapper;
    UserRepository userRepository;
    
    public final TicketResponseDTO save(TicketRequestDTO ticket) {
        var entity = mapper.toEntity(ticket);
        var userId = entity.getUser().getUserId();
        var user = userRepository.findById(userId).orElseThrow();
        entity.setUser(user);
        return mapper.toResponse(this.repository.saveAndFlush(entity));
    }
    
    public final List<TicketResponseDTO> findAll() {
        var list = this.repository.findAll();
        return mapper.toList(list);
    }
    
    public final TicketResponseDTO findById(Long id) {
       var entity = repository.findById(id).orElseThrow();
       return mapper.toResponse(entity);
    }

    public final void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
