package fstop.ticket.message;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 22/01/2026 05:04
 * @since 1.0.0
 */
public interface MessageRepository extends JpaRepository<MessageEntity, UUID> {
    List<MessageEntity> findAllByTicketId(UUID ticket_id);
}
