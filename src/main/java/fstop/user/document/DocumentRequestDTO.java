package fstop.user.document;

import lombok.Data;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:09
 * @since 1.0.0
 */

@Data
public class DocumentRequestDTO {
    public String documentNumber;
    public DocumentType documentType;
}
