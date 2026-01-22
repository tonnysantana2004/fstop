package fstop.ticket.category.dto;

import fstop.ticket.category.infrastructure.TicketCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 21/01/2026 08:01
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TicketCategoryMapper {
    
    TicketCategoryResponse toResponse(TicketCategoryEntity ticketCategoryEntity);
    
    List<TicketCategoryResponse> toListCategory(List<TicketCategoryEntity> list);
}
