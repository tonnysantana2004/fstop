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
    
    // Converter User id para um User, e validar no banco de dados se existe.
    @Mapping(target = "user.id", source = "userId")
    TicketEntity toEntity(TicketRequestDTO requestDTO);
    
    TicketResponseDTO toResponse(TicketEntity entity);
    
    List<TicketResponseDTO> toList(List<TicketEntity> list);
}
