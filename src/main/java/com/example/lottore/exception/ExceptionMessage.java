package com.example.lottore.exception;

public enum ExceptionMessage {
    ;

    private final String ERROR_MESSAGE_HEAD = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return this.ERROR_MESSAGE_HEAD + message;
    }

}
