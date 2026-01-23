package fstop.ticket.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 21/01/2026 05:50
 * @since 1.0.0
 */
public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {

}
