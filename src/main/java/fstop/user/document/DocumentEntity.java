package fstop.user.document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fstop.BaseEntity;
import fstop.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tonny Santana
 * @date 19/01/2026 02:57
 * @since 1.0.0
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documents")
public class DocumentEntity extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private UserEntity user;
    
    @Column(name = "document_number")
    private String documentNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "document_type")
    private DocumentType documentType = DocumentType.CPF;
    
}