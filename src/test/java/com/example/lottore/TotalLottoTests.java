package com.example.lottore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.lottore.entity.TotalLotto;
import org.junit.jupiter.api.Test;

public class TotalLottoTests {
    TotalLotto totalLotto = new TotalLotto();

    @Test
    public void 수익률_계산_테스트(){
        int payCost = 8000;
        long totalPrize = 5000;

        double actual = totalLotto.calculateRateOfReturn(payCost, totalPrize);
        System.out.println(actual);
        double expected = 62.5;

        assertEquals(expected, actual);
    }
}
