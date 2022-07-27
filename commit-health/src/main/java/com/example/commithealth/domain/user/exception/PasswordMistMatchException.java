package com.example.commithealth.domain.user.exception;

import com.example.commithealth.global.error.CustomException;
import com.example.commithealth.global.error.ErrorCode;

public class PasswordMistMatchException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMistMatchException();

    private PasswordMistMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}