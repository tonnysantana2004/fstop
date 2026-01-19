package fstop.ticket.message;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 19/01/2026 06:30
 * @since 1.0.0
 */
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    
    List<MessageEntity> findAllByTicketId(Long ticketId);
}
