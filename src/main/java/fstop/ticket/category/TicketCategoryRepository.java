package fstop.ticket.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 21/01/2026 07:52
 * @since 1.0.0
 */
public interface TicketCategoryRepository extends JpaRepository<TicketCategoryEntity, UUID> {
}
