package com.spring_security.service.impl;

import com.spring_security.dto.SaveUser;
import com.spring_security.exception.InvalidPasswordException;
import com.spring_security.persistence.entity.User;
import com.spring_security.persistence.entity.util.Role;
import com.spring_security.persistence.repository.UserRepository;
import com.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // Method to create a User and save it to the database
    @Override
    public User createOneCustomer(SaveUser newUser) {
        // Validate password
        validatePassword(newUser);

        // Register a client 
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRole(Role.ROLE_CUSTOMER);
        
        return userRepository.save(user);
    }

    private void validatePassword(SaveUser dto) {
        if (!StringUtils.hasText(dto.getPassword()) ||
                !StringUtils.hasText(dto.getRepeatedPassword()) ||
                !dto.getPassword().equals(dto.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }
    }
}
