package com.example.commithealth.domain.user.controller;

import com.example.commithealth.domain.user.controller.dto.request.LoginRequest;
import com.example.commithealth.domain.user.controller.dto.request.SignupRequest;
import com.example.commithealth.domain.user.service.UserService;
import com.example.commithealth.global.security.jwt.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @PostMapping("/sing-up")
    public void signup(@Valid SignupRequest request){
        service.signup(request);
    }
    @PostMapping("/login")
    public TokenResponse login(@Valid LoginRequest request){
        return service.login(request);
    }
}