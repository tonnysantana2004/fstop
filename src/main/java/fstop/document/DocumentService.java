package fstop.document;

import fstop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    
    public final DocumentResponseDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow();
        return mapper.toResponse(entity);
    }
    
    
    public final DocumentResponseDTO create(DocumentRequestDTO requestDTO) {
        
        var entity = mapper.toEntity(requestDTO);
        
        // Encontrando o usuário
        var userId = entity.getUser().getId();
        var user = userRepository.findById(userId).orElseThrow();
        
        // Preenchendo os dados do usuário no documento
        entity.setUser(user);
        
        // Salvando o documento
        repository.save(entity);
        
        return  mapper.toResponse(entity);
    }
    
    public final DocumentResponseDTO update(DocumentRequestDTO requestDTO, Long id) {
        
        var entity = repository.findById(id).orElseThrow();
        
        // Edita o entity
        mapper.mergeEntity(requestDTO, entity);
        
        repository.save(entity);
        
        return mapper.toResponse(entity);
    }
}
