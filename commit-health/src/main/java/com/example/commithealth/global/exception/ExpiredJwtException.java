package com.example.commithealth.global.exception;

import com.example.commithealth.global.error.CustomException;
import com.example.commithealth.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {
    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}