package fstop.user;

import fstop.exception.user.AdminDeleteException;
import fstop.exception.user.UserNotFoundException;
import fstop.user.address.infrastructure.AddressEntity;
import fstop.user.document.infrastructure.DocumentEntity;
import fstop.user.dto.UserMapper;
import fstop.user.dto.UserRequest;
import fstop.user.dto.UserResponse;
import fstop.user.infrastructure.UserRepository;
import fstop.user.infrastructure.UserRoleEnum;
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
    public List<UserResponse> create(UserRequest request) {
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
        return mapper.toList(List.of(userEntity));
    }
    
    public List<UserResponse> findAll() {
        var list = repository.findAll();
        return mapper.toList(list);
    }
    
    public List<UserResponse> findById(UUID userId) {
        var entity = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        return mapper.toList(List.of(entity));
    }
    
    public void deleteById(UUID userId) throws Exception {
        var entity = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        if (entity.getRole() == UserRoleEnum.ADMIN) throw new AdminDeleteException();
        repository.delete(entity);
    }
    
    public List<UserResponse> update(UserRequest request, UUID userId) {
        var entity = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        mapper.mergeEntity(request, entity);
        return mapper.toList(List.of(repository.save(entity)));
    }
}