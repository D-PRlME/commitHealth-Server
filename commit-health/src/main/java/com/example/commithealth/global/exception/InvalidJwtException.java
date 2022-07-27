package com.example.commithealth.global.exception;

import com.example.commithealth.global.error.CustomException;
import com.example.commithealth.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {
    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}