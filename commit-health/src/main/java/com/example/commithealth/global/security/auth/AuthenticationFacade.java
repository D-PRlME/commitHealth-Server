package com.example.commithealth.global.security.auth;

import com.example.commithealth.domain.user.domain.User;
import com.example.commithealth.domain.user.domain.repository.UserRepository;
import com.example.commithealth.global.exception.AuthNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {
    private final UserRepository repository;
    public User getCurrentUser(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    public User getUserByEmail(String email){
        return repository.findByEmail(email)
                .orElseThrow(() -> AuthNotFoundException.EXCEPTION);
    }
}