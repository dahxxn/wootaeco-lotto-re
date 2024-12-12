package com.example.lottore.service;

import com.example.lottore.constant.Constant;
import com.example.lottore.constant.Regex;
import com.example.lottore.exception.CustomException;
import com.example.lottore.exception.ExceptionMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateRawInput {

    public int isNumber(String rawInput){
        if(!rawInput.matches(Regex.NUMBER.toString())){
            throw new CustomException(ExceptionMessage.NOT_NUMBER);
        }
        return Integer.parseInt(rawInput);
    }

    public void checkPayCostAmount(int payCost){
        if(payCost < Constant.LOTTO_COST.getValue()){
            throw new CustomException(ExceptionMessage.WRONG_PAY_COST_LACK_MONEY);
        }
    }

    public void checkPayCost(int payCost){
        if(payCost%Constant.LOTTO_COST.getValue()!=0){
            throw new CustomException(ExceptionMessage.WRONG_PAY_COST);
        }
    }

    public int validateRawPayCost(String rawPayCost){
        rawPayCost = rawPayCost.trim();
        int payCost = isNumber(rawPayCost);
        checkPayCostAmount(payCost);
        checkPayCost(payCost);
        return payCost;
    }

    public void checkWinningNumbersCount(List<Integer> winningNumbers){
        if(winningNumbers.size() != 6){
            throw new CustomException(ExceptionMessage.WRONG_WINNING_NUMBERS_COUNT);
        }
    }

    public List<Integer> checkAllWinningNumberIsNumber(String[] tokenWinningNumbers){
        List<Integer> winningNumbers = new ArrayList<>();
        for(String tokenWinningNumber : tokenWinningNumbers){
            tokenWinningNumber = tokenWinningNumber.trim();
            winningNumbers.add(isNumber(tokenWinningNumber));
        }
        return winningNumbers;
    }

    public void checkNumberInLottoRange(int number){
        if(Constant.LOTTO_NUMBER_RANGE_START.getValue() > number || Constant.LOTTO_NUMBER_RANGE_END.getValue() < number){
            throw new CustomException(ExceptionMessage.WRONG_LOTTO_NUMBER_RANGE);
        }
    }

    public void checkAllNumberInLottoRange(List<Integer> winningNumbers){
        for(Integer winningNumber : winningNumbers){
           checkNumberInLottoRange(winningNumber);
        }
    }

    public void checkDuplicatedNumberInList(List<Integer> winningNumbers){
        Set<Integer> set = new HashSet<>(winningNumbers);
        List<Integer> newWinningNumbers = new ArrayList<>(set);

        if(newWinningNumbers.size() < winningNumbers.size()){
            throw new CustomException(ExceptionMessage.WRONG_LOTTO_NUMBER_DUPLICATED);
        }
    }

    public String[] splitRawWinningNumbers(String rawWinningNumbers){
        return rawWinningNumbers.split(Regex.WINNING_NUMBER_DELIMITER.toString());
    }

    public List<Integer> validateRawWinningNumbers(String rawWinningNumbers){
        rawWinningNumbers = rawWinningNumbers.trim();
        String[] tokenWinningNumbers = splitRawWinningNumbers(rawWinningNumbers);
        List<Integer> winningNumbers = checkAllWinningNumberIsNumber(tokenWinningNumbers);
        checkAllNumberInLottoRange(winningNumbers);
        checkDuplicatedNumberInList(winningNumbers);
        checkWinningNumbersCount(winningNumbers);
        return winningNumbers;
    }

    public void checkBonusNumberInWinningNumbers(List<Integer> winningNumber, int bonusNumber){
        if(winningNumber.contains(bonusNumber)){
            throw new CustomException(ExceptionMessage.WRONG_LOTTO_NUMBER_DUPLICATED);
        }
    }

    public int validateRawBonusNumber(String rawBonusNumber, List<Integer> winningNumbers){
        rawBonusNumber = rawBonusNumber.trim();
        int bonusNumber = isNumber(rawBonusNumber);
        checkNumberInLottoRange(bonusNumber);
        checkBonusNumberInWinningNumbers(winningNumbers,bonusNumber);
        return bonusNumber;
    }
}
