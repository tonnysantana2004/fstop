package fstop.business.dto.request;

import fstop.infrastructure.entity.Ticket;
import fstop.infrastructure.entity.User;
import lombok.Data;

@Data
public class TicketRequestDTO {
    
    private Integer id;
    private String description;
    
    public TicketRequestDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.description = ticket.getDescription();
    }
    
}
