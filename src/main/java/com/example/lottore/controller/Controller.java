package com.example.lottore.controller;

import com.example.lottore.constant.PrintMessage;
import com.example.lottore.constant.WinningPrize;
import com.example.lottore.entity.TotalLotto;
import com.example.lottore.exception.CustomException;
import com.example.lottore.service.LottoService;
import com.example.lottore.service.ValidateRawInput;
import com.example.lottore.view.InputView;
import com.example.lottore.view.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    ValidateRawInput validateRawInput = new ValidateRawInput();
    LottoService lottoService = new LottoService();

    TotalLotto totalLotto;

    public int getInputPayCost(){
        String rawPayCost = inputView.readInput(PrintMessage.INPUT_PAY_COST_MESSAGE.toString());
        int payCost = 0;
        try{
            payCost = validateRawInput.validateRawPayCost(rawPayCost);
        }catch(CustomException e){
            outputView.printMessage(e.getMessage());
            getInputPayCost();
        }
        outputView.printLineBreak();
        return payCost;
    }

    public List<Integer> getInputWinningNumbers(){
        String rawWinningNumbers = inputView.readInput(PrintMessage.INPUT_WINNING_NUMBER_MESSAGE.toString());
        List<Integer> winningNumbers = new ArrayList<>();
        try{
            winningNumbers = validateRawInput.validateRawWinningNumbers(rawWinningNumbers);
        }catch(CustomException e){
            outputView.printMessage(e.getMessage());
            getInputWinningNumbers();
        }
        outputView.printLineBreak();

        return winningNumbers;
    }

    public int getInputBonusNumber(List<Integer> winningNumbers){
        String rawBonusNumber = inputView.readInput(PrintMessage.INPUT_BONUS_NUMBER_MESSAGE.toString());
        int bonusNumber = 0;
        try{
            bonusNumber = validateRawInput.validateRawBonusNumber(rawBonusNumber, winningNumbers);
        }catch(CustomException e){
            outputView.printMessage(e.getMessage());
            getInputBonusNumber(winningNumbers);
        }
        outputView.printLineBreak();

        return bonusNumber;
    }

    public void run(){
        int payCost = getInputPayCost();
        int lottoCount = lottoService.CalculateLottoCount(payCost);
        totalLotto = new TotalLotto();
        totalLotto.buyLottos(lottoCount);
        outputView.printTotalLotto(totalLotto, lottoCount);

        List<Integer> winningNumbers = getInputWinningNumbers();
        int bonusNumber = getInputBonusNumber(winningNumbers);

        HashMap<WinningPrize,Integer> winningResult = totalLotto.checkTotalWinningResult(winningNumbers,bonusNumber);
        outputView.printWinningResult(winningResult);

        long totalPrize = totalLotto.calculateTotalPrize();
        double rateOfReturn = totalLotto.calculateRateOfReturn(payCost, totalPrize);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
