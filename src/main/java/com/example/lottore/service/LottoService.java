package com.example.lottore.service;

import com.example.lottore.constant.Constant;

public class LottoService {

    public int CalculateLottoCount(int payCost){
        return payCost/Constant.LOTTO_COST.getValue();
    }

}
