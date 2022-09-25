package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : JAKE
 * @date : 2022/09/25
 *
 * 요구사항
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void SetUp() {
        calculator = new Calculator();
    }

    @DisplayName("문자를 입력했을 때 해당 문자가 계산가능한지 판별한다.")
    @ParameterizedTest
    @CsvSource(value = {"5 + 3:true","2 * *:false"}, delimiter = ':')
    void isSuitableCalculatorTest(String element, boolean expected) {
        assertThat(Calculator.isNotSuitableCalculator(element)).isEqualTo(expected);
    }
}