package fstop.business.service;

import fstop.business.dto.request.TicketRequestDTO;
import fstop.business.dto.response.TicketResponseDTO;
import fstop.business.dto.response.UserResponseDTO;
import fstop.infrastructure.entity.Ticket;
import fstop.infrastructure.entity.User;
import fstop.infrastructure.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    
    @Autowired
    TicketRepository ticketRepository;
    
    public TicketResponseDTO save(Ticket ticket) {
        
        Ticket ticketEntity = ticketRepository.save(ticket);
        TicketResponseDTO dto = new TicketResponseDTO(ticketEntity);
        return dto;
    }
    
    public TicketResponseDTO findById(Integer id) {
        
        Ticket ticketEntity = ticketRepository.findById(id).get();
        TicketResponseDTO dto = new TicketResponseDTO(ticketEntity);
        return dto;
        
    }
}
