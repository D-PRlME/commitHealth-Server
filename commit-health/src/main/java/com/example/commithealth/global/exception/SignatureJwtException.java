package com.example.commithealth.global.exception;

import com.example.commithealth.global.error.CustomException;
import com.example.commithealth.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {
    public static final CustomException EXCEPTION =
            new SignatureJwtException();

    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }
}