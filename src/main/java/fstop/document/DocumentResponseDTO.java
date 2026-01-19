package fstop.document;

import fstop.user.UserEntity;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:13
 * @since 1.0.0
 */
public class DocumentResponseDTO {
    
    public Long id;
    public UserEntity user;
    public String documentNumber;
    public DocumentType documentType;
    
}
