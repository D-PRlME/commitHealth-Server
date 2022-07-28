package com.example.commithealth.domain.user.service;

import com.example.commithealth.domain.user.controller.dto.request.LoginRequest;
import com.example.commithealth.domain.user.controller.dto.request.SignupRequest;
import com.example.commithealth.domain.user.controller.dto.request.changePwRequest;
import com.example.commithealth.domain.user.domain.User;
import com.example.commithealth.domain.user.domain.repository.UserRepository;
import com.example.commithealth.domain.user.exception.AlreadyExistEmailException;
import com.example.commithealth.domain.user.exception.PasswordMistMatchException;
import com.example.commithealth.global.exception.AuthNotFoundException;
import com.example.commithealth.global.security.auth.AuthenticationFacade;
import com.example.commithealth.global.security.jwt.JwtTokenProvider;
import com.example.commithealth.global.security.jwt.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder encoder;
    private final UserRepository repository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationFacade authenticationFacade;

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
    public TokenResponse login(LoginRequest request){
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> AuthNotFoundException.EXCEPTION);
        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMistMatchException.EXCEPTION;
        } else
            return TokenResponse.builder()
                    .accessToken(jwtTokenProvider.generateAccessToken(user.getStudentId()))
                    .build();
    }
    public void changePw(changePwRequest request){
        User user = authenticationFacade.getCurrentUser();
        if(!encoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordMistMatchException.EXCEPTION;
        } else
            user.updatePw(request.getNewPassword());
    }
}