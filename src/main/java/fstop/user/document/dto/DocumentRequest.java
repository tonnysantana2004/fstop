package fstop.user.document.dto;

import fstop.user.document.infrastructure.DocumentType;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:09
 * @since 1.0.0
 */

@Data
public class DocumentRequest {
    public String documentNumber;
    public DocumentType documentType;
}
