package com.example.commithealth.domain.user.controller;

import com.example.commithealth.domain.user.controller.dto.request.SignupRequest;
import com.example.commithealth.domain.user.service.UserService;
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
}