package fstop.user.document;

import fstop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tonny Santana
 * @date 19/01/2026 03:21
 * @since 1.0.0
 */

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository repository;
    @Autowired
    private DocumentMapper mapper;
    @Autowired
    private UserRepository userRepository;
    
    public final DocumentResponseDTO getUserDocument(Long userId) {
        
        var entity = userRepository
                .findById(userId)
                .orElseThrow()
                .getDocument()
                ;
        
        return mapper.toResponse(entity);
    }
    
    
    public final DocumentResponseDTO create(DocumentRequestDTO requestDTO, Long userId) {
        
        var entity = mapper.toEntity(requestDTO);
        
        var user = userRepository
                .findById(userId)
                .orElseThrow();
        
        // Preenchendo os dados do usuário no documento
        entity.setUser(user);
        
        // Salvando o documento
        repository.save(entity);
        
        return mapper.toResponse(entity);
    }
    
    public final DocumentResponseDTO update(DocumentRequestDTO requestDTO, Long userId) {
        
        var user = userRepository.findById(userId).orElseThrow();
        
        var entity = user.getDocument();
        
        // Edita o entity
        mapper.mergeEntity(requestDTO, entity);
        
        repository.save(entity);
        
        return mapper.toResponse(entity);
    }
}
