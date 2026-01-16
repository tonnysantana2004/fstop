package fstop.business.dto.response;

import fstop.infrastructure.entity.Ticket;
import lombok.Data;

@Data
public class TicketResponseDTO {
    
    private Integer id;
    private String description;
    
    public TicketResponseDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.description = ticket.getDescription();
    }
    
}
