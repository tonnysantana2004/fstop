package fstop.auth;

import fstop.auth.dto.AuthRequest;
import fstop.user.infrastructure.UserEntity;
import fstop.user.dto.UserMapper;
import fstop.user.infrastructure.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Tonny Santana
 * @date 20/01/2026 05:40
 * @since 1.0.0
 */

@Service
public class AuthService {
    
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }
    
    private UserRepository userRepository;
    private UserMapper userMapper;
    public PasswordEncoder passwordEncoder;
    
    
    public boolean isLoginCorrect(AuthRequest request, UserEntity user) {
        
        if (!passwordEncoder.matches(request.password(), user.getPassword())) return false;
        
        return true;
    }
    
    public Optional<UserEntity> findUserByUserName(String username) {
        
        var user = userRepository.findByUserName(username);
        
        return user;
    }
    
    public void saveUser(UserEntity user) {
        userRepository.saveAndFlush(user);
    }
}
