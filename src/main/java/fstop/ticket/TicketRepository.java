package fstop.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
