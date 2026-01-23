package fstop.ticket;

import fstop.auth.AuthService;
import fstop.exception.ticket.TicketCategoryNotFoundException;
import fstop.exception.ticket.TicketNotFoundException;
import fstop.ticket.category.dto.TicketCategoryMapper;
import fstop.ticket.category.infrastructure.TicketCategoryRepository;
import fstop.ticket.category.dto.TicketCategoryResponse;
import fstop.ticket.dto.TicketMapper;
import fstop.ticket.dto.TicketRequest;
import fstop.ticket.dto.TicketResponse;
import fstop.ticket.infrastructure.TicketRepository;
import fstop.user.infrastructure.UserRepository;
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
    
    public List<TicketResponse> findById(UUID ticketId) {
        var entity = ticketRepository.findById(ticketId).orElseThrow(TicketNotFoundException::new);
        var response = ticketMapper.toResponse(entity);
        return List.of(response);
    }
    
    public List<TicketCategoryResponse> findAllCategories() {
        return ticketCategoryMapper.toListCategory(this.ticketCategoryRepository.findAll());
    }
    
    public List<TicketResponse> create(TicketRequest request) {
        var ticketEntity = ticketMapper.toEntity(request);
        ticketEntity.setIssuer(AuthService.getAuthenticatedUser());
        
        var category = ticketCategoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(TicketCategoryNotFoundException::new);
        ticketEntity.setCategory(category);
        
        return ticketMapper.toList(List.of(ticketRepository.save(ticketEntity)));
    }
    
    // @Transactional
    public void delete(UUID ticketId) {
        var entity = ticketRepository.findById(ticketId).orElseThrow(TicketNotFoundException::new);
        ticketRepository.delete(entity);
    }
    
}
