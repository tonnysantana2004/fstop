package fstop.products;

import fstop.response.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    
    @GetMapping("/{productId}")
    public Object findById(@PathVariable UUID productId) {
        return ResponseService.success("Produto encontrado.", productService.findById(productId));
    }
    
    @PostMapping
    public Object create(@RequestBody ProductRequest request) {
        return ResponseService.success("Produto Criado.", productService.create(request));
    }
    
    @PutMapping("/{productId}")
    public Object update(@RequestBody ProductRequest request, @PathVariable UUID productId) {
        return ResponseService.success("Produto Editado.", productService.update(request, productId));
    }
    
    @DeleteMapping("/{productId}")
    public Object delete(@PathVariable UUID productId) {
        productService.deleteById(productId);
        return ResponseService.success("Produto Excluído.", null);
    }
    
}
