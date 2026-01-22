package fstop.response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Tonny Santana
 * @date 21/01/2026 23:21
 * @since 1.0.0
 */

@RestControllerAdvice
public class AppExceptionHandler {
    

    @ExceptionHandler(RuntimeException.class)
    public  ResponseEntity<ApiResponseEntity<String>> handleRuntimeException(RuntimeException exception) {
        return ResponseService.error("Erro no em tempo de execução.", exception.getMessage());
    }
    
}
