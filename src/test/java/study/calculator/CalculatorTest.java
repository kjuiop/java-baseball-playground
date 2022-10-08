package study.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.*;

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
    @CsvSource(value = {"5 + 3:false","2 * *:true"}, delimiter = ':')
    void isNotSuitableCalculatorTest(String element, boolean expected) {
        assertThat(calculator.isNotSuitableCalculator(element)).isEqualTo(expected);
    }

    @Test
    @DisplayName("계산이 불가능한 문자를 입력했을 때 예외를 발생시킨다.")
    void isNotSuitableCalculateExceptionTest() {

        String input = "2 * *";

        assertThatThrownBy(() -> {
            calculator.execute(input);
        }).isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("%s", "계산식에 적합하지 않습니다.");
    }

    @DisplayName("더하기 연산을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"5 + 3:8","2 + 4:6", "1 + 2 + 5:8"}, delimiter = ':')
    void addTest(String element, int expected) {
        assertThat(calculator.execute(element)).isEqualTo(expected);
    }

    @DisplayName("마이너스 연산을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"5 - 3:2","2 - 4 - 5:-7", "9 - 0 - 2:7"}, delimiter = ':')
    void minusTest(String element, int expected) {
        assertThat(calculator.execute(element)).isEqualTo(expected);
    }

    @DisplayName("곱하기 연산을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"5 * 3:15","2 * 4 * 5:40", "9 * 0 * 1:0"}, delimiter = ':')
    void multiplyTest(String element, int expected) {
        assertThat(calculator.execute(element)).isEqualTo(expected);
    }
}