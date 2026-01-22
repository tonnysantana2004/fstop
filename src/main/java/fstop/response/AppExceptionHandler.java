package fstop.response;

import fstop.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Tonny Santana
 * @date 21/01/2026 23:21
 * @since 1.0.0
 */

@RestControllerAdvice
public class AppExceptionHandler {
    
    
    @ExceptionHandler(BaseException.class)
    public  Object handleBaseException(BaseException exception) {
        return ResponseService.error(exception.getMessage(), exception.getErrors());
    }
    
}
