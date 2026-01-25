package fstop.exception.product;

import fstop.exception.BaseException;

import java.util.List;

/**
 * @author Tonny Santana
 * @date 25/01/2026 05:36
 * @since 1.0.0
 */
public class ProductCategoryNotFoundException extends BaseException {
    
    private static String message = "Categoria de produto não encontrada.";
    
    public ProductCategoryNotFoundException() {
        super(message);
    }
    
    public ProductCategoryNotFoundException(List<String> errors) {
        super(message, errors);
    }
    
}
