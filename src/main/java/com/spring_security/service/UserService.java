package com.spring_security.service;

import com.spring_security.dto.SaveUser;
import com.spring_security.persistence.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createOneCustomer(SaveUser newUser);
}
