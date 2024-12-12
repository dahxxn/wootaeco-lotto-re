package com.example.lottore.entity;

import camp.nextstep.edu.missionutils.Randoms;
import com.example.lottore.constant.Constant;
import com.example.lottore.constant.WinningPrize;
import com.example.lottore.dto.WinningResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TotalLotto {
    List<Lotto> totalLotto;
    HashMap<WinningPrize, Integer> winningResult;

    public TotalLotto() {
        totalLotto = new ArrayList<Lotto>();
        winningResult = new HashMap<>();
        for(WinningPrize prize : WinningPrize.values()) {
            winningResult.put(prize,0);
        }
    }

    public void buyLottos(int lottoCount){
        for(int i = 0; i < lottoCount; i++){
            makeNewLotto();
        }
    }

    private void makeNewLotto(){
        Lotto newLotto = new Lotto(generateLottoNumbers());
        totalLotto.add(newLotto);
    }

    private List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(Constant.LOTTO_NUMBER_RANGE_START.getValue(), Constant.LOTTO_NUMBER_RANGE_END.getValue(), Constant.LOTTO_COUNT.getValue());
    }

    public void checkTotalWinningResult(List<Integer> winningNumbers, int bonusNumber){
        for(Lotto lotto : totalLotto){
            WinningResult result = lotto.checkWinningNumbers(winningNumbers,bonusNumber);
            WinningPrize prize = lotto.findPrize(result.getWinningNumberCount(), result.getIsBonusNumber());
            addWinningResult(prize);
        }
    }

    private void addWinningResult(WinningPrize prize){
        if(prize != null){
            winningResult.put(prize,winningResult.get(prize)+1);
        }
    }

    public long calculateTotalPrize(){
        long totalPrize = 0;
        for(WinningPrize prize : winningResult.keySet()){
            int winningCount = winningResult.get(prize);
            if(winningCount > 0){
                totalPrize += ((long) prize.getPrize() * winningCount);
            }
        }
        return totalPrize;
    }

    public double calculateRateOfReturn(int payCost, long totalPrize){
        return Math.round((float)(totalPrize/payCost)*100)/100.0;
    }

}
