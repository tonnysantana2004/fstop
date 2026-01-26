package fstop.user;

import fstop.auth.AuthProvider;
import fstop.exception.user.AdminDeleteException;
import fstop.exception.user.InvalidUserCredentialsException;
import fstop.exception.user.UserNotFoundException;
import fstop.user.address.infrastructure.AddressEntity;
import fstop.user.document.infrastructure.DocumentEntity;
import fstop.user.dto.UserMapper;
import fstop.user.dto.UserRequest;
import fstop.user.dto.UserResponse;
import fstop.user.infrastructure.UserEntity;
import fstop.user.infrastructure.UserRepository;
import fstop.user.infrastructure.UserRoleEnum;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@AllArgsConstructor
public class UserService {
    
    private final BCryptPasswordEncoder passwordEncoder;
    private UserRepository repository;
    private UserMapper mapper;
    
    
    public UserEntity create(UserRequest request, boolean admin) {
        // Entity
        var userEntity = mapper.toEntity(request);
        var password = passwordEncoder.encode(request.getPassword());
        userEntity.setPassword(password);
        
        // Document
        var document = new DocumentEntity();
        document.setUser(userEntity);
        userEntity.setDocument(document);
        
        // Address
        var address = new AddressEntity();
        address.setUser(userEntity);
        userEntity.setAddress(address);
        
        if (admin) userEntity.setRole(UserRoleEnum.ADMIN);
        
        try {
            repository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            
            // todo: tratar corretamente esse erro
            // throw new InvalidUserCredentialsException(List.of(e.getMessage()));
        
        }
        
        return userEntity;
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