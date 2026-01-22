package fstop.exception;

import lombok.Getter;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 22/01/2026 01:08
 * @since 1.0.0
 */
@Getter
public class BaseException  extends RuntimeException{
    
    private List<String> errors;
    
    public BaseException(String message) {
        super(message);
    }
    
    public BaseException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
    
}
