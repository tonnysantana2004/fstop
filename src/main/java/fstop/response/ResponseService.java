package fstop.response;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Tonny Santana
 * @date 21/01/2026 23:34
 * @since 1.0.0
 */
public class ResponseService {
    
    // Success
    public static <T> ResponseEntity<ApiResponseEntity<T>> success(String message, T data) {
        return ResponseEntity.ok(new ApiResponseEntity<>("success", message,  data, null));
    }
    
    // Error
    public static <T> ResponseEntity<ApiResponseEntity<T>> error(String message, T data) {
        return ResponseEntity
                .badRequest()
                .body(new ApiResponseEntity<>("error", message,  data, null));
    }
    
}
