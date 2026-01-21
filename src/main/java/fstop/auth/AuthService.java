package fstop.auth;

import fstop.auth.dto.AuthRequest;
import fstop.user.UserEntity;
import fstop.user.UserMapper;
import fstop.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
