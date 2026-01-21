package fstop.user.document;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:15
 * @since 1.0.0
 */
public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {
}
