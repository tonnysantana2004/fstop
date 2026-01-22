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
public class AdminDeleteException extends BaseException {
   
    private static String message = "A conta de administrador não deve ser excluída.";
    
    public AdminDeleteException() {
        super(message);
    }
    
    public AdminDeleteException(List<String> errors) {
        super(message, errors);
    }
    
}
