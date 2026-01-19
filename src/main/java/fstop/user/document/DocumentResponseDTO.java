package fstop.user.document;

import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:13
 * @since 1.0.0
 */

@Data
public class DocumentResponseDTO {
    
    public Long id;
    public Long userId;
    public String documentNumber;
    public DocumentType documentType;
}
