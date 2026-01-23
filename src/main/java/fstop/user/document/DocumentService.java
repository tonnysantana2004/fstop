package fstop.user.document;

import fstop.exception.user.UserNotFoundException;
import fstop.user.document.dto.DocumentMapper;
import fstop.user.document.dto.DocumentRequest;
import fstop.user.document.dto.DocumentResponse;
import fstop.user.document.infrastructure.DocumentEntity;
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
    
    public List<DocumentResponse> getUserDocument(UUID userId) {
        var user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        var document = user.getDocument();
        if (document == null) document = this.create(userId);
        return mapper.toList(List.of(document));
    }
    
    public DocumentEntity create(UUID userId) {
        var user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        var document = new DocumentEntity();
        document.setUser(user);
        return repository.save(document);
    }
    
    public List<DocumentResponse> update(DocumentRequest request, UUID userId) {
        var user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        var documentEntity = user.getDocument();
        mapper.mergeEntity(request, documentEntity);
        return mapper.toList(List.of(repository.save(documentEntity)));
    }
}
