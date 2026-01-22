package fstop.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 21/01/2026 21:37
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class ApiResponseEntity<T> {
    
    private String status;
    private T data;
    private String message;
    private Object metadata;
    
}
