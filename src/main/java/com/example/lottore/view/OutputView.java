package com.example.lottore.view;

import static com.example.lottore.constant.PrintMessage.PRINT_BONUS_WINNING_STATE_MESSAGE;
import static com.example.lottore.constant.PrintMessage.PRINT_HORIZONTAL_LINE;
import static com.example.lottore.constant.PrintMessage.PRINT_TOTAL_LOTTO_COUNT_MESSAGE;
import static com.example.lottore.constant.PrintMessage.PRINT_TOTAL_RATE_OF_RETURN_MESSAGE;
import static com.example.lottore.constant.PrintMessage.PRINT_WINNING_STATE_MESSAGE;
import static com.example.lottore.constant.PrintMessage.PRINT_WINNING_STATISTICS_MESSAGE;

import com.example.lottore.constant.WinningPrize;
import com.example.lottore.entity.Lotto;
import com.example.lottore.entity.TotalLotto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class OutputView {
    public void printLineBreak() {
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printTotalLotto(TotalLotto totalLotto, int lottoCount) {
        System.out.printf(PRINT_TOTAL_LOTTO_COUNT_MESSAGE.toString(), lottoCount);
        printLineBreak();

        Iterator<Lotto> totalLottoIterator = totalLotto.getTotalLotto();
        while (totalLottoIterator.hasNext()) {
            Lotto lotto = totalLottoIterator.next();
            System.out.println(iteratorToList(lotto.getLottoNumber()));
        }
        printLineBreak();
    }

    private List<String> iteratorToList(Iterator<?> iterator) {
        List<String> result = new ArrayList<String>();
        while(iterator.hasNext()) {
            result.add(iterator.next().toString());
        }
        return result;
    }

    public void printWinningResult(HashMap<WinningPrize,Integer> winningResult){
        printMessage(PRINT_WINNING_STATISTICS_MESSAGE.toString());
        printMessage(PRINT_HORIZONTAL_LINE.toString());
        for(WinningPrize prize : WinningPrize.values()){
            if(prize.equals(WinningPrize.SECOND)){
                System.out.printf(PRINT_BONUS_WINNING_STATE_MESSAGE.toString(), prize.getCount(), prize.getPrize(), winningResult.get(prize));
                printLineBreak();
                continue;
            }
            System.out.printf(PRINT_WINNING_STATE_MESSAGE.toString(), prize.getCount(), prize.getPrize(), winningResult.get(prize));
            printLineBreak();
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(PRINT_TOTAL_RATE_OF_RETURN_MESSAGE.toString(), rateOfReturn);
        printLineBreak();
    }
}
