package com.example.lottore.constant;

public enum PrintMessage {
    INPUT_PAY_COST_MESSAGE("구입금액을 입력해 주세요. "),
    PRINT_TOTAL_LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요. "),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요. "),
    PRINT_WINNING_STATISTICS_MESSAGE("당첨 통계"),
    PRINT_WINNING_STATE_MESSAGE("%d개 일치 (%,d원) - %d개"),
    PRINT_BONUS_WINNING_STATE_MESSAGE("%d개 일치, 보너스 볼 일치 (%d,원) - %d개"),
    PRINT_TOTAL_RATE_OF_RETURN_MESSAGE("총 수익률은 %.2f% 입니다.")
    ;
    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }
}
