package com.example.lottore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.lottore.dto.WinningResult;
import com.example.lottore.entity.Lotto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTests {
    @Test
    public void 로또_객체_생성_및_당첨_결과_테스트(){
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1,2,3,11,22,33));
        int bonusNumber = 10;
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        WinningResult actual = lotto.checkWinningNumbers(winningNumbers, bonusNumber);
        WinningResult expected = new WinningResult(3,false);

        assertEquals(expected.getWinningNumberCount(),actual.getWinningNumberCount());
        assertEquals(expected.getIsBonusNumber(),actual.getIsBonusNumber());
    }
}
