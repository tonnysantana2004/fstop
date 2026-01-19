package fstop.ticket;

import fstop.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Service
public class TicketService {
    
    @Autowired
    TicketRepository repository;
    @Autowired
    TicketMapper mapper;
    @Autowired
    UserRepository userRepository;
    
    public final TicketResponseDTO save(TicketRequestDTO ticket) {
        
        
        var entity = mapper.toEntity(ticket);
        
        // Encontrando e corrigindo o usuário no ticket
        var user = userRepository.findById(entity.getUser().getId()).orElseThrow();
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
