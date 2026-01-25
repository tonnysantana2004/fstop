package fstop.product.category;

import fstop.product.category.dto.ProductCategoryRequest;
import fstop.response.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 25/01/2026 05:48
 * @since 1.0.0
 */

@RestController
@RequestMapping("/products/categories")
@AllArgsConstructor
public class ProductCategoryController {
    
    private ProductCategoryService service;
    
    @GetMapping
    public Object findAll() {
        return ResponseService.success("Produtos Encontrados.", service.findAll());
    }
    
    @GetMapping("/{categoryId}")
    public Object findById(@PathVariable UUID categoryId) {
        return ResponseService.success("Produto Encontrado.", service.findById(categoryId));
    }
    
    @PostMapping
    public Object create(@RequestBody ProductCategoryRequest request) {
        return ResponseService.success("Produto Criado.", service.create(request));
    }
    
    @PutMapping("/{categoryId}")
    public Object update(@RequestBody ProductCategoryRequest request, @PathVariable UUID categoryId) {
        return ResponseService.success("Produto Editado.", service.update(request, categoryId));
    }
    
    @DeleteMapping("/{categoryId}")
    public Object delete(@PathVariable UUID categoryId) {
        service.delete(categoryId);
        return ResponseService.success("Produto Deletado.", null);
    }
    
    
}
