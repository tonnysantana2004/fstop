package fstop.user;

import fstop.user.address.AddressEntity;
import fstop.user.document.DocumentEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@Service
public class UserService {
    
    private UserRepository repository;
    private UserMapper mapper;
    private PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository r, UserMapper m, PasswordEncoder p) {
        this.repository = r;
        this.mapper = m;
        this.passwordEncoder = p;
    }
    
    @Transactional
    public UserResponseDTO create(UserRequestDTO request) {
        var userEntity = mapper.toEntity(request);
        
        // Password Hash
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        
        // Document
        var document = new DocumentEntity();
        document.setUser(userEntity);
        userEntity.setDocument(document);
        
        // Address
        var address = new AddressEntity();
        address.setUser(userEntity);
        userEntity.setAddress(address);
        
        repository.saveAndFlush(userEntity);
        return mapper.toResponse(userEntity);
    }
    
    public List<UserResponseDTO> findAll() {
        var list = repository.findAll();
        return mapper.toList(list);
    }
    
    public UserResponseDTO findById(UUID userId) {
        var entity = repository
                .findById(userId)
                .orElseThrow();
        return mapper.toResponse(entity);
    }
    
    public void deleteById(UUID userId) throws Exception {
        var entity = repository
                .findById(userId)
                .orElseThrow();
        
        if(entity.getRole() == UserRoleEnum.ADMIN) {
            throw new Exception("you can't procceed this action.");
        }
        
        repository.delete(entity);
    }
    
    public UserResponseDTO update(UserRequestDTO requestDTO, UUID userId) {
        var entity = repository
                .findById(userId)
                .orElseThrow();
        mapper.mergeEntity(requestDTO, entity);
        return mapper.toResponse(repository.save(entity));
    }
}