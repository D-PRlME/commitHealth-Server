package com.example.commithealth.domain.user.service;

import com.example.commithealth.domain.user.controller.dto.request.SignupRequest;
import com.example.commithealth.domain.user.domain.User;
import com.example.commithealth.domain.user.domain.repository.UserRepository;
import com.example.commithealth.domain.user.exception.AlreadyExistEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder encoder;
    private final UserRepository repository;

    public void signup(SignupRequest request) {
        Optional<User> user = repository.findByEmail(request.getEmail());
        if (user.isPresent())
            throw AlreadyExistEmailException.EXCEPTION;
        repository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(encoder.encode(request.getPassword()))
                        .studentId(request.getStudentId())
                        .name(request.getName())
                        .build());
    }
}