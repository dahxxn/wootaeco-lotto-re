package com.example.lottore.exception;

public enum ExceptionMessage {
    NOT_NUMBER("숫자가 아닌 값이 올 수 없습니다. "),
    WRONG_PAY_COST_LACK_MONEY("구입 금액은 로또 가격보다 커야합니다. "),
    WRONG_PAY_COST("구입 금액은 로또 가격으로 나누어 떨어져야 합니다. "),
    WRONG_WINNING_NUMBERS_COUNT("당첨 번호는 6개가 입력되어야 합니다. "),
    WRONG_LOTTO_NUMBER_RANGE("로또 번호 범위를 벗어납니다. "),
    WRONG_LOTTO_NUMBER_DUPLICATED("중복된 번호가 존재하면 안됩니다.  ")
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
