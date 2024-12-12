package com.example.lottore.service;

import com.example.lottore.constant.WinningPrize;

public class LottoService {
    public WinningPrize findPrize(int winningNumberCount, boolean isBonusNumber){
        if(winningNumberCount == 5 && isBonusNumber){
            return WinningPrize.SECOND;
        }
        if(winningNumberCount == 6){
            return WinningPrize.FIRST;
        }
        if(winningNumberCount == 5){
            return WinningPrize.THIRD;
        }
        if(winningNumberCount == 4){
            return WinningPrize.FOURTH;
        }
        return null;
    }

}
