package fstop.user;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper mapper;
 
    
    public final UserResponseDTO save(UserRequestDTO request) {
        var entity = mapper.toEntity(request);
        
        repository.saveAndFlush(entity);
        
        return mapper.toResponse(entity);
    }
    
    public final List<UserResponseDTO> findAll() {
        var list = repository.findAll();
        return mapper.toList(list);
    }
    
    public final UserResponseDTO findById(UUID userId) {
        var entity = repository
                .findById(userId)
                .orElseThrow();
        return mapper.toResponse(entity);
    }
    
    public final UserResponseDTO findByEmail(String email) {
        var entity = repository
                .findByEmail(email)
                .orElseThrow();
        return mapper.toResponse(entity);
    }
    
    public final void deleteById(UUID userId) {
        var entity = repository
                .findById(userId)
                .orElseThrow();
        repository.delete(entity);
    }
    
    public final UserResponseDTO update(UserRequestDTO requestDTO, UUID userId) {
       
        var entity = repository.findById(userId).orElseThrow();
        
        // Está alterando o entity!!! Lembre-se que é uma referência
        mapper.mergeEntity(requestDTO, entity);
        
        return mapper.toResponse(repository.save(entity));
    }
}