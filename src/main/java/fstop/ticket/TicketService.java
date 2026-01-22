package fstop.ticket;

import fstop.ticket.category.TicketCategoryMapper;
import fstop.ticket.category.TicketCategoryRepository;
import fstop.ticket.category.TicketCategoryResponse;
import fstop.ticket.dto.TicketMapper;
import fstop.ticket.dto.TicketRequest;
import fstop.ticket.dto.TicketResponse;
import fstop.ticket.infrastructure.TicketRepository;
import fstop.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:49
 * @since 1.0.0
 */

@Service
@AllArgsConstructor
public class TicketService {
    
    private final TicketMapper ticketMapper;
    private final TicketCategoryRepository ticketCategoryRepository;
    private final TicketCategoryMapper ticketCategoryMapper;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    
    public List<TicketResponse> findAll() {
        return ticketMapper.toList(this.ticketRepository.findAll());
    }
    
    public Object findById(UUID ticketId) {
        
        var entity = ticketRepository.findById(ticketId).orElseThrow();
        var response = ticketMapper.toResponse(entity);
        var list = new ArrayList<>();
        list.add(response);
        
        return list;
    }
    
    public List<TicketCategoryResponse> findAllCategories() {
        return ticketCategoryMapper.toListCategory(this.ticketCategoryRepository.findAll());
    }
    
    public TicketResponse create(TicketRequest request) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userId = jwt.getClaimAsString("sub");
        
        var entity = ticketMapper.toEntity(request);
        
        var issuer = userRepository.findById(UUID.fromString(userId)).orElseThrow();
        entity.setIssuer(issuer);
        
        var category = ticketCategoryRepository.findById(request.getCategoryId()).orElseThrow();
        
        entity.setCategory(category);
        
        return ticketMapper.toResponse(ticketRepository.save(entity)) ;
    }
    
    // @Transactional
    public void delete (UUID ticketId) {
        var entity = ticketRepository.findById(ticketId).orElseThrow();
        ticketRepository.delete(entity);
    }

}
