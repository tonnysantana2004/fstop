package fstop.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    
    public List<ProductResponse> create(ProductRequest request)  {
        var entity = productMapper.toEntity(request) ;
        var saved = productRepository.save(entity);
        return productMapper.toList(List.of(saved));
    }
    
}
