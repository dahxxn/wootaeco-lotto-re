package com.example.lottore.entity;

import com.example.lottore.constant.Constant;
import com.example.lottore.dto.WinningResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public WinningResult checkWinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        Set<Integer> totalNumbers = new HashSet<>(winningNumbers);
        totalNumbers.addAll(numbers);

        List<Integer> checkDuplicateNumbers = new ArrayList<>(totalNumbers);
        int winningCount = Constant.LOTTO_COUNT.getValue() * 2 - checkDuplicateNumbers.size();
        boolean isBonusNumber = numbers.contains(bonusNumber);

        return new WinningResult(winningCount, isBonusNumber);
    }


}
