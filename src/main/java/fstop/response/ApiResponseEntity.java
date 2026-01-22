package fstop.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Tonny Santana
 * @date 21/01/2026 21:37
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseEntity<T> {
    
    private String status;
    private String message;
    private T data;
    private Object metadata;
    
}
