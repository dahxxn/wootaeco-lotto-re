package com.example.lottore.constant;

public enum Regex {
    NUMBER("(([1-9])([0-9])*)|([0-9])"),
    WINNING_NUMBER_DELIMITER(","),
    LOTTO_RANGE("[1-45]")
    ;
    private String regex;
    Regex(String regex) {
        this.regex = regex;
    }

    public String toString() {
        return regex;
    }

}
