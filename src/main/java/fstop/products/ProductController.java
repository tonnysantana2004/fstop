package fstop.products;

import fstop.response.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tonny Santana
 * @date 23/01/2026 16:54
 * @since 1.0.0
 */

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    
    ProductService productService;
    
    @GetMapping()
    public Object findAll() {
        return ResponseService.success("Produtos encontrados.", productService.findAll());
    }
    
    @PostMapping
    public Object create(@RequestBody ProductRequest request) {
        return ResponseService.success("Produto Criado.", productService.create(request));
    }
}
