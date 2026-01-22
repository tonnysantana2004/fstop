package fstop.exception.user;

import fstop.exception.BaseException;
import lombok.Getter;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 22/01/2026 00:49
 * @since 1.0.0
 */
@Getter
public class UserNotFoundException extends BaseException {
    
    private static String message = "Este usuário não existe.";
    
    public UserNotFoundException() {
        super(message);
    }
    
    public UserNotFoundException(List<String> errors) {
        super(message, errors);
    }
    
}
