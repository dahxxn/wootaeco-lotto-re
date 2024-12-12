package com.example.lottore.exception;

public class CustomException extends IllegalArgumentException {
    public CustomException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.toString());
    }
}
