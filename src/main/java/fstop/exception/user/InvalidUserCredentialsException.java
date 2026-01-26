package fstop.exception.user;

import fstop.exception.BaseException;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 26/01/2026 06:24
 * @since 1.0.0
 */
public class InvalidUserCredentialsException extends BaseException {
    
    private static String message = "Dados de acesso inválidos.";
    
    public InvalidUserCredentialsException() {
        super(message);
    }
    
    public InvalidUserCredentialsException(List<String> errors) {
        super(message, errors);
    }
    
}
