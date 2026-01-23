package fstop.exception.ticket;

import fstop.exception.BaseException;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 22/01/2026 23:30
 * @since 1.0.0
 */
public class TicketCategoryNotFoundException extends BaseException {
    
    private static String message = "Esta categoria não existe.";
    
    public TicketCategoryNotFoundException() {
        super(message);
    }
    
    public TicketCategoryNotFoundException(List<String> errors) {
        super(message, errors);
    }
    
}