package com.example.lottore.entity;

import camp.nextstep.edu.missionutils.Randoms;
import com.example.lottore.constant.Constant;
import java.util.ArrayList;
import java.util.List;

public class TotalLotto {
    List<Lotto> totalLotto;

    public TotalLotto() {
        totalLotto = new ArrayList<Lotto>();
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

}
