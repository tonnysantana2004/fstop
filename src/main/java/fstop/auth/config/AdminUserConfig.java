package fstop.auth.config;

import fstop.auth.AuthService;
import fstop.user.UserService;
import fstop.user.dto.UserMapper;
import fstop.user.dto.UserRequest;
import fstop.user.infrastructure.UserEntity;
import fstop.user.infrastructure.UserRepository;
import fstop.user.infrastructure.UserRoleEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tonny Santana
 * @date 20/01/2026 06:40
 * @since 1.0.0
 */

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    
    @Autowired
    private AuthService service;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    
    @Override
    @Transactional
    public void run(String... args) throws Exception{
        
        var userAdmin = service.findUserByUserName("admin");
        
        userAdmin.ifPresentOrElse(
                user -> IO.println("Admin existe"),
                () -> {
                    
                    var request = new UserRequest();
                    request.setUserName("admin");
                    request.setFirstName("Administrador");
                    request.setLastName("Sistema");
                    request.setEmail("admin@email.com");
                    request.setPhone(null);
                    request.setProfileImage(null);
                    request.setPassword("123");
                    
                    userService.create(request, true).getFirst();
                    
                }
        );
        
        
    }
}
