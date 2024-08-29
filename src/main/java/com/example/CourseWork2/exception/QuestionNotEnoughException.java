package com.example.CourseWork2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionNotEnoughException extends RuntimeException {
    public QuestionNotEnoughException() {
    }

    public QuestionNotEnoughException(String message) {
        super(message);
    }

    public QuestionNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionNotEnoughException(Throwable cause) {
        super(cause);
    }

    public QuestionNotEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
