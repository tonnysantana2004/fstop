package fstop.user.address;

import fstop.user.address.dto.AddressMapper;
import fstop.user.address.dto.AddressRequest;
import fstop.user.address.dto.AddressResponse;
import fstop.user.address.infrastructure.AddressRepository;
import fstop.user.infrastructure.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    
    public final Object findByUserId(UUID userId) {
        // chore: create the document if it doesnt exist...
        var entity = repository.findByUserId(userId).orElseThrow();
        return mapper.toList(List.of(entity));
    }
    
    public final Object create(AddressRequest request, UUID userId) {
        var entity = mapper.toEntity(request);
        var user = userRepository.findById(userId).orElseThrow();
        entity.setUser(user);
        return mapper.toList(List.of(repository.save(entity)));
    }
    
    public final Object update(AddressRequest request, UUID userId) {
        var entity = repository.findByUserId(userId).orElseThrow();
        mapper.mergeEntity(request, entity);
        return mapper.toList(List.of(repository.save(entity)));
    }
    
}
