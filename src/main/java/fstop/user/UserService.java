package fstop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    
    public final UserResponseDTO findById(Long id) {
        var entity = repository
                .findById(id)
                .orElseThrow();
        return mapper.toResponse(entity);
    }
    
    public final UserResponseDTO findByEmail(String email) {
        var entity = repository
                .findByEmail(email)
                .orElseThrow();
        return mapper.toResponse(entity);
    }
    
    public final void deleteById(Long id) {
        var entity = repository
                .findById(id)
                .orElseThrow();
        repository.delete(entity);
    }
    
    public final UserResponseDTO update(UserRequestDTO requestDTO, Long id) {
       
        var entity = repository.findById(id).orElseThrow();
        
        // Está alterando o entity!!! Lembre-se que é uma referência
        mapper.mergeEntity(requestDTO, entity);
        
        return mapper.toResponse(repository.save(entity));
    }
}