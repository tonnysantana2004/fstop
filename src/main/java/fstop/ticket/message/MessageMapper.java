package fstop.ticket.message;

import fstop.ticket.TicketMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 19/01/2026 06:32
 * @since 1.0.0
 */

@Mapper(componentModel = "spring", uses = TicketMapper.class)
public interface MessageMapper {
    
    @Mapping(target = "messageId", ignore = true)
    @Mapping(target = "ticket.ticketId", source = "ticketId")
    MessageEntity toEntity(MessageRequestDTO requestDTO);
    
    MessageResponseDTO toResponse(MessageEntity entity);
    
    List<MessageResponseDTO> toList(List<MessageEntity> list);
}
