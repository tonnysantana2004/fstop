package fstop.auth.config;

import fstop.auth.AuthService;
import fstop.user.UserEntity;
import fstop.user.UserRoleEnum;
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
    
    @Override
    @Transactional
    public void run(String... args) throws Exception{
    
        var roleAdmin = UserRoleEnum.ADMIN;
        
        var userAdmin = service.findUserByUserName("admin");
        
        userAdmin.ifPresentOrElse(
                user -> IO.println("Admin existe"),
                () -> {
                    UserEntity user = new UserEntity();
                    user.setUserName("admin");
                    user.setFirstName("Administrador");
                    user.setLastName("Sistema");
                    user.setEmail("admin@email.com");
                    user.setPhone(null);
                    user.setProfileImage(null);
                    // chore: encode the password on user entity instead of here
                    user.setPassword(service.passwordEncoder.encode("123"));
                    user.setRole(roleAdmin);
                    
                    service.saveUser(user);
                }
        );
        
        
    }
}
