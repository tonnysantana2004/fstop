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
        return ResponseEntity.ok(new ApiResponseEntity<>("success", data, message, null));
    }
    
    // Error
    public static <T> ResponseEntity<ApiResponseEntity<T>> error(T data, String message) {
        return ResponseEntity
                .badRequest()
                .body(new ApiResponseEntity<>("error", data, message, null));
    }
    
}
