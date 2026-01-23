package fstop.user.document;

import fstop.user.document.dto.DocumentMapper;
import fstop.user.document.dto.DocumentRequest;
import fstop.user.document.infrastructure.DocumentRepository;
import fstop.user.infrastructure.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    
    public Object getUserDocument(UUID userId) {
        var user = userRepository.findById(userId).orElseThrow();
        var documentEntity = user.getDocument();
        return mapper.toList(List.of(documentEntity));
    }
    
    public Object create(DocumentRequest request, UUID userId) {
        var documentEntity = mapper.toEntity(request);
        var user = userRepository.findById(userId).orElseThrow();
        documentEntity.setUser(user);
        return mapper.toList(List.of(repository.save(documentEntity)));
    }
    
    public Object update(DocumentRequest request, UUID userId) {
        var user = userRepository.findById(userId).orElseThrow();
        var documentEntity = user.getDocument();
        mapper.mergeEntity(request, documentEntity);
        return mapper.toList(List.of(repository.save(documentEntity)));
    }
}
