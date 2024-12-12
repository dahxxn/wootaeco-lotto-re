package com.example.lottore.constant;

public enum Constant {
    LOTTO_COST(1000),
    LOTTO_NUMBER_RANGE_START(1),
    LOTTO_NUMBER_RANGE_END(45),
    LOTTO_COUNT(6)
    ;
    private int value;
    private Constant(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
