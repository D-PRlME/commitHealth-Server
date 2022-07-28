package com.example.commithealth.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class changePwRequest {
    private String password;
    private String newPassword;
}
