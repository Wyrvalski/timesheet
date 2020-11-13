package com.timesheet.auth.v1.service;

import com.timesheet.auth.domain.model.UserEntity;
import com.timesheet.auth.domain.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final CustomUserRepository customUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(CustomUserRepository customUserRepository,
                       @Lazy PasswordEncoder passwordEncoder) {
        this.customUserRepository = customUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public UserEntity findByEmail(String email) {
        return customUserRepository.findByEmailCustomUser(email);
    }

}
