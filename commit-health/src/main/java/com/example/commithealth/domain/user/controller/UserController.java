package com.example.commithealth.domain.user.controller;

import com.example.commithealth.domain.user.controller.dto.request.LoginRequest;
import com.example.commithealth.domain.user.controller.dto.request.SignupRequest;
import com.example.commithealth.domain.user.controller.dto.request.changePwRequest;
import com.example.commithealth.domain.user.service.UserService;
import com.example.commithealth.global.security.jwt.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @PostMapping("/sign-up")
    public void signup(@RequestBody @Valid SignupRequest request){
        service.signup(request);
    }
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request){
        return service.login(request);
    }
    @PatchMapping("/update/password")
    public void changePw(@RequestBody @Valid changePwRequest request){
        service.changePw(request);
    }
}