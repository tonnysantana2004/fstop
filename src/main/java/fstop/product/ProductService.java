package fstop.product;

import fstop.exception.product.ProductNotFoundException;
import fstop.product.dto.ProductMapper;
import fstop.product.dto.ProductRequest;
import fstop.product.dto.ProductResponse;
import fstop.product.infrastructure.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 23/01/2026 16:55
 * @since 1.0.0
 */

@Service
@AllArgsConstructor
public class ProductService {
    
    private final ProductMapper productMapper;
    private ProductRepository productRepository;
    
    public List<ProductResponse> findAll() {
        return productMapper.toList(productRepository.findAll());
    }
    
    public List<ProductResponse> findById(UUID productId) {
        var productEntity = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        return productMapper.toList(List.of(productEntity));
    }
    
    public List<ProductResponse> create(ProductRequest request)  {
        var entity = productMapper.toEntity(request) ;
        var saved = productRepository.save(entity);
        return productMapper.toList(List.of(saved));
    }
    
    public List<ProductResponse> update(ProductRequest request, UUID productId) {
        var entity = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        
        productMapper.mergeEntity(request,entity);
        
        return productMapper.toList(List.of(productRepository.save(entity)));
    }
    
    public void deleteById(UUID productId) {
        
        var productEntity = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        productRepository.deleteById(productId);
    }
    
}
