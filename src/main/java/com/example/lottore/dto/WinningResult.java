package com.example.lottore.dto;

public class WinningResult {
    int winningNumberCount;
    boolean isBonusNumber;

    public WinningResult(int winningNumberCount, boolean isBonusNumber) {
        this.winningNumberCount = winningNumberCount;
        this.isBonusNumber = isBonusNumber;
    }

    public int getWinningNumberCount() {
        return winningNumberCount;
    }

    public boolean getIsBonusNumber() {
        return isBonusNumber;
    }

}
