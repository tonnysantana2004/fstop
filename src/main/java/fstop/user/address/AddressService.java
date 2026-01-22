package fstop.user.address;

import fstop.user.address.dto.AddressMapper;
import fstop.user.address.dto.AddressRequest;
import fstop.user.address.dto.AddressResponse;
import fstop.user.address.infrastructure.AddressRepository;
import fstop.user.infrastructure.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 19/01/2026 18:25
 * @since 1.0.0
 */

@Service
@AllArgsConstructor
public class AddressService {
    
    private AddressRepository repository;
    private AddressMapper mapper;
    private UserRepository userRepository;
    
    public final AddressResponse findByUserId(UUID userId) {
        
        // chore: create the document if it doesnt exist...
        return mapper.toResponse(repository
                .findByUserId(userId)
                .orElseThrow());
    }
    
    public final AddressResponse create(AddressRequest request, UUID userId) {
        var entity = mapper.toEntity(request);
        var user = userRepository
                .findById(userId)
                .orElseThrow();
        entity.setUser(user);
        return mapper.toResponse(repository.save(entity));
    }
    
    public final AddressResponse update(AddressRequest request, UUID userId) {
        var entity = repository
                .findByUserId(userId)
                .orElseThrow();
        mapper.mergeEntity(request, entity);
        return mapper.toResponse(repository.save(entity));
    }
    
}
