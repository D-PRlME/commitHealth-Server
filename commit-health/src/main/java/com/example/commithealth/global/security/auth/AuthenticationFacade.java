package com.example.commithealth.global.security.auth;

import com.example.commithealth.domain.user.domain.User;
import com.example.commithealth.domain.user.domain.repository.UserRepository;
import com.example.commithealth.global.exception.AuthNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {
    private final UserRepository repository;
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        return repository.findByEmail(authDetails.getUsername())
                .orElseThrow(() -> AuthNotFoundException.EXCEPTION);
    }
}