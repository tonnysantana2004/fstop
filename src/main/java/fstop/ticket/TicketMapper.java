package fstop.ticket;

import fstop.ticket.category.TicketCategoryMapper;
import fstop.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:52
 * @since 1.0.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {UserMapper.class, TicketCategoryMapper.class})
public interface TicketMapper {
    
    TicketEntity toEntity(TicketRequest request);
    @Mapping(target = "id", source = "id")
    TicketResponse toResponse(TicketEntity entity);
    
    List<TicketResponse> toList(List<TicketEntity> list);
    
    void mergeEntity(TicketRequest request, @MappingTarget TicketEntity entity);
}
