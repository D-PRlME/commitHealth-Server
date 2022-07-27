package com.example.commithealth.domain.user.exception;

import com.example.commithealth.global.error.CustomException;
import com.example.commithealth.global.error.ErrorCode;

public class AlreadyExistEmailException extends CustomException {
    public static final CustomException EXCEPTION =
            new AlreadyExistEmailException();

    private AlreadyExistEmailException() {
        super(ErrorCode.EMAIL_EXIST);
    }
}