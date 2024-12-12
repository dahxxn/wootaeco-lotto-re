package com.example.lottore.controller;

import com.example.lottore.constant.PrintMessage;
import com.example.lottore.exception.CustomException;
import com.example.lottore.service.ValidateRawInput;
import com.example.lottore.view.InputView;
import com.example.lottore.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    ValidateRawInput validateRawInput = new ValidateRawInput();

    public int getInputPayCost(){
        String rawPayCost = inputView.readInput(PrintMessage.INPUT_PAY_COST_MESSAGE.toString());
        int payCost = 0;
        try{
            payCost = validateRawInput.validateRawPayCost(rawPayCost);
        }catch(CustomException e){
            outputView.printMessage(e.getMessage());
            getInputPayCost();
        }
        return payCost;
    }

    public List<Integer> getInputWinningNumbers(){
        while(true){
            String rawWinningNumbers = inputView.readInput(PrintMessage.INPUT_WINNING_NUMBER_MESSAGE.toString());


            List<Integer> winningNumbers = new ArrayList<>();
            return winningNumbers;
        }
    }

    public int getInputBonusNumber(){
        while(true){
            String rawBonusNumber = inputView.readInput(PrintMessage.INPUT_BONUS_NUMBER_MESSAGE.toString());

            int bonusNumber = Integer.parseInt(rawBonusNumber);
            return bonusNumber;
        }
    }

    public void run(){
        //사용자에게 입력받기
        getInputPayCost();



    }
}
