package fstop.product.category;

import fstop.exception.product.ProductCategoryNotFoundException;
import fstop.product.category.dto.ProductCategoryMapper;
import fstop.product.category.dto.ProductCategoryRequest;
import fstop.product.category.dto.ProductCategoryResponse;
import fstop.product.category.infrastructure.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 25/01/2026 05:31
 * @since 1.0.0
 */

@Service
@AllArgsConstructor
public class ProductCategoryService {
    
    private ProductCategoryRepository repository;
    private ProductCategoryMapper mapper;
    
    public List<ProductCategoryResponse> findAll() {
        return mapper.toList(repository.findAll());
    }
    
    public List<ProductCategoryResponse> findById(UUID categoryId) {
        var entity = repository.findById(categoryId).orElseThrow(ProductCategoryNotFoundException::new);
        return mapper.toList(List.of(entity));
    }
    
    public List<ProductCategoryResponse> create(ProductCategoryRequest request) {
        var entity = mapper.toEntity(request);
        var created = repository.save(entity);
        return mapper.toList(List.of(created));
    }
    
    public List<ProductCategoryResponse> update(ProductCategoryRequest request, UUID categoryId) {
        var actuallySaved = repository.findById(categoryId).orElseThrow(ProductCategoryNotFoundException::new);
        
        mapper.mergeEntity(request, actuallySaved);
        
        var saved = repository.save(actuallySaved);
        
        return mapper.toList(List.of(saved));
    }
    
    public void delete(UUID categoryId) {
        var actuallySaved = repository.findById(categoryId).orElseThrow(ProductCategoryNotFoundException::new);
        repository.delete(actuallySaved);
    }
}
