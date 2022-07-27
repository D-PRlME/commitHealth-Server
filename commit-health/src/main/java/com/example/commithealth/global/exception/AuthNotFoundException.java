package com.example.commithealth.global.exception;

import com.example.commithealth.global.error.CustomException;
import com.example.commithealth.global.error.ErrorCode;

public class AuthNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new AuthNotFoundException();

    private AuthNotFoundException() {
        super(ErrorCode.AUTH_NOT_FOUND);
    }
}