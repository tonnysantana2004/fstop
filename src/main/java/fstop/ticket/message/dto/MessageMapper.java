package fstop.ticket.message.dto;

import fstop.ticket.dto.TicketMapper;
import fstop.ticket.message.infrastructure.MessageEntity;
import fstop.user.dto.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 22/01/2026 05:22
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {UserMapper.class, TicketMapper.class})
public interface MessageMapper {
    
    MessageEntity toEntity(MessageRequest request);
    
    MessageResponse toResponse(MessageEntity entity);
    
    List<MessageResponse> toList(List<MessageEntity> list);
}