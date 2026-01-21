package fstop.user.address;

import fstop.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:25
 * @since 1.0.0
 */

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository repository;
    @Autowired
    private AddressMapper mapper;
    @Autowired
    private UserRepository userRepository;
    
    public final AddressResponseDTO getResponseEntity(UUID userId) {
        
        return mapper.toResponse(repository.findByUserId(userId).orElseThrow());
        
    }
    
    public final AddressResponseDTO create(AddressRequestDTO requestDTO, UUID userId) {
        
        var user = userRepository.findById(userId).orElseThrow();
        
        var entity = mapper.toEntity(requestDTO);
        
        entity.setUser(user);
        
        return mapper.toResponse(repository.save(entity));
    }
    
    public final AddressResponseDTO update(AddressRequestDTO requestDTO, UUID userId) {
        
        var entity = repository.findByUserId(userId).orElseThrow();
        
        mapper.mergeEntity(requestDTO, entity);
        
        return mapper.toResponse(repository.save(entity));
    }
    
}
