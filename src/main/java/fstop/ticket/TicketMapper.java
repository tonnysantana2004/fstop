package fstop.ticket;

import fstop.user.UserMapper;
import org.mapstruct.*;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TicketMapper {
    
    @Mapping(target = "id", ignore = true)
    TicketEntity toEntity(TicketRequestDTO requestDTO);
    
    @Mapping(target = "userId", source = "user.id")
    TicketResponseDTO toResponse(TicketEntity entity);
    
    List<TicketResponseDTO> toList(List<TicketEntity> list);
}
