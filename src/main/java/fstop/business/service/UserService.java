package fstop.business.service;

import fstop.business.dto.request.UserRequestDTO;
import fstop.infrastructure.entity.User;
import fstop.infrastructure.repository.UserRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public User save(User user) {
        return repository.save(user);
    }
    
    public UserRequestDTO findById(Integer id) {
        
        User userEntity = repository.findById(id).get();
        UserRequestDTO dto = new UserRequestDTO(userEntity);
        return dto;
        
    }
    
    public UserRequestDTO findByEmail(String email) {
        
        User userEntity = repository.findByEmail(email).get();
        UserRequestDTO dto = new UserRequestDTO(userEntity);
        return dto;
        
    }
    
    
    public void update(User entity) {
        
        // Usuário do banco de dados
        var updatedEntity =  repository
                .findById(entity.getId())
                .orElseThrow();
        
        
        // Transforam os usuários em feijões
        BeanWrapper entityBeanWrapper = new BeanWrapperImpl(entity);
        BeanWrapper dbEntityBeanWrapper = new BeanWrapperImpl(updatedEntity);
        
        // Faz um loop cada campo, baseado no modelo do banco de dados
        for (var propertyDescription : dbEntityBeanWrapper.getPropertyDescriptors()) {
            
            String propertyName = propertyDescription.getName();
            
            // Apenas campos com setters
            if (!dbEntityBeanWrapper.isWritableProperty(propertyName))
                continue;
            
            // Existe um metodo padrão chamado getClass, por isso checamos
            if ("class".equals(propertyName))
                continue;
            
            ArrayList fillable = User.fillable;
            // Só atualiza campos do fillable
            if(!fillable.contains(propertyName)) continue;
            
            // Talvez utiliza o novo valor
            var newEntityPropertyValue = entityBeanWrapper.getPropertyValue(propertyName);
            
            if (newEntityPropertyValue != null) {
                dbEntityBeanWrapper.setPropertyValue(propertyName, newEntityPropertyValue);
            }
        }
        
        repository.saveAndFlush(updatedEntity);
        
    }
}