package com.example.commithealth.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @Email
    private String email;

    private String password;
}
