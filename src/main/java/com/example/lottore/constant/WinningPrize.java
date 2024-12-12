package com.example.lottore.constant;

public enum WinningPrize {
    FIFTH(3,false,5000),
    FOURTH(4,false,50000),
    THIRD(5,false,1500000),
    SECOND(5,true,30000000),
    FIRST(6,false,2000000000),
    ;
    private int count;
    private boolean isBonusNumber;
    private int prize;

    WinningPrize(int count, boolean isBonusNumber, int prize) {
        this.count = count;
        this.isBonusNumber = isBonusNumber;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }
    public boolean isBonusNumber() {
        return isBonusNumber;
    }
    public int getPrize() {
        return prize;
    }


}
