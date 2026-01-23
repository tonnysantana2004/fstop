package fstop.exception.ticket;

import fstop.exception.BaseException;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 22/01/2026 23:31
 * @since 1.0.0
 */
public class TicketNotFoundException extends BaseException {
    
    private static String message = "Este ticket não existe.";
    
    public TicketNotFoundException() {
        super(message);
    }
    
    public TicketNotFoundException(List<String> errors) {
        super(message, errors);
    }
    
}