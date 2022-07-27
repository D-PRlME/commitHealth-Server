package com.example.commithealth.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
public class SignupRequest {

    @Email(message = "이메일 형식에 맞춰주세요")
    private String email;

    private String password;

    private String studentId;

    private String name;
}
