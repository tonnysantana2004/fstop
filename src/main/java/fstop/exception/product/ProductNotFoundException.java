package fstop.exception.product;

import fstop.exception.BaseException;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 25/01/2026 04:58
 * @since 1.0.0
 */
public class ProductNotFoundException extends BaseException {
    
    private static String message = "Este produto não foi encontrado.";
    
    public ProductNotFoundException() {
        super(message);
    }
    
    public ProductNotFoundException(List<String> errors) {
        super(message, errors);
    }
    
}
