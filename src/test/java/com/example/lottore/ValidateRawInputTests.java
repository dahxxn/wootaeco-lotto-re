package com.example.lottore;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.lottore.service.ValidateRawInput;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidateRawInputTests {
    ValidateRawInput validateRawInput = new ValidateRawInput();

    @ParameterizedTest
    @ValueSource(strings = {"1000", " 2000", "8000 "})
    public void 구입_금액_검증_테스트(String rawPayCost) {
        assertDoesNotThrow(() -> validateRawInput.validateRawPayCost(rawPayCost));
    }

    @Test
    public void 구입_금액_검증_값_반환_테스트(){
        String rawPayCost = "1000";
        int expected = 1000;
        int actual = validateRawInput.validateRawPayCost(rawPayCost);

        assertEquals(expected,actual);
    }

    @Test
    public void 구입_금액_검증_예외_테스트_숫자가_아닐때(){
        String rawPayCost = "200asd!@";

        assertThatThrownBy(() -> validateRawInput.validateRawPayCost(rawPayCost))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구입_금액_검증_예외_테스트_1000원_이하일떄(){
        String rawPayCost = "200";

        assertThatThrownBy(() -> validateRawInput.validateRawPayCost(rawPayCost))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구입_금액_검증_예외_테스트_1000원_단위가_아닐때(){
        String rawPayCost = "1200";

        assertThatThrownBy(() -> validateRawInput.validateRawPayCost(rawPayCost))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", " 7 , 8, 9, 10, 11, 12"})
    public void 당첨_번호_검증_테스트(String rawWinningNumbers) {
        assertDoesNotThrow(() -> validateRawInput.validateRawWinningNumbers(rawWinningNumbers));
    }

    @Test
    public void 당첨_번호_검증_값_반환_테스트(){
        String rawWinningNumbers = " 1,20, 30,4 ,5,6 ";
        List<Integer> expected = new ArrayList<>(List.of(1,20,30,4,5,6));
        List<Integer> actual = validateRawInput.validateRawWinningNumbers(rawWinningNumbers);

        assertEquals(expected,actual);
    }

    @Test
    public void 당첨_번호_검증_예외_테스트_숫자가_아닌_문자가_있을때(){
        String rawWinningNumbers = " 1!!,2@0, 30,4 ,5,6 ";

        assertThatThrownBy(() -> validateRawInput.validateRawWinningNumbers(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호_검증_예외_테스트_숫자가_로또_범위_밖일떄(){
        String rawWinningNumbers = "100,200,300,400,500,600";

        assertThatThrownBy(() -> validateRawInput.validateRawWinningNumbers(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호_검증_예외_테스트_중복된_수_존재할때(){
        String rawWinningNumbers = "1,2,3,1,2,6";

        assertThatThrownBy(() -> validateRawInput.validateRawWinningNumbers(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호_검증_예외_테스트_당첨_번호_수가_6개가_아닐때(){
        String rawWinningNumbers = "1,2,3,4,5";

        assertThatThrownBy(() -> validateRawInput.validateRawWinningNumbers(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10"," 20 ", "30 "})
    public void 보너스_번호_검증_테스트(String rawBonusNumber) {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertDoesNotThrow(() -> validateRawInput.validateRawBonusNumber(rawBonusNumber, winningNumbers));
    }

    @Test
    public void 보너스_번호_검증_값_반환_테스트(){
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        String rawBonusNumber = " 10 ";

        int expected = 10 ;
        int actual = validateRawInput.validateRawBonusNumber(rawBonusNumber, winningNumbers);

        assertEquals(expected,actual);
    }

    @Test
    public void 보너스_번호_검증_예외_테스트_숫자가_아닐떄(){
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        String rawBonusNumber = " 1!@0 ";

        assertThatThrownBy(() -> validateRawInput.validateRawBonusNumber(rawBonusNumber,winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_번호_검증_예외_테스트_로또_범위_밖일때(){
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        String rawBonusNumber = " 100 ";

        assertThatThrownBy(() -> validateRawInput.validateRawBonusNumber(rawBonusNumber,winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_번호_검증_예외_테스트_중복된_수일때(){
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        String rawBonusNumber = " 1 ";

        assertThatThrownBy(() -> validateRawInput.validateRawBonusNumber(rawBonusNumber,winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
