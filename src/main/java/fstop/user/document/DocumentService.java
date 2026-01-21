package fstop.user.document;

import fstop.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:21
 * @since 1.0.0
 */

@Service
@AllArgsConstructor
public class DocumentService {
    
    private DocumentRepository repository;
    private DocumentMapper mapper;
    private UserRepository userRepository;
    
    public final DocumentResponseDTO getUserDocument(UUID userId) {
        var entity = userRepository
                .findById(userId)
                .orElseThrow()
                .getDocument();
        return mapper.toResponse(entity);
    }
    
    
    public final DocumentResponseDTO create(DocumentRequestDTO requestDTO, UUID userId) {
        var entity = mapper.toEntity(requestDTO);
        
        var user = userRepository
                .findById(userId)
                .orElseThrow();
        
        entity.setUser(user);
        repository.save(entity);
        
        return mapper.toResponse(entity);
    }
    
    public final DocumentResponseDTO update(DocumentRequestDTO requestDTO, UUID userId) {
        var user = userRepository
                .findById(userId)
                .orElseThrow();
        
        var entity = user.getDocument();
        mapper.mergeEntity(requestDTO, entity);
        repository.save(entity);
        
        return mapper.toResponse(entity);
    }
}
