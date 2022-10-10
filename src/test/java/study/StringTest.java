package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2 문자열을 , 기준으로 Split 테스트")
    void splitTest() {
        String actual = "1,2";
        String[] expected = {"1", "2"};
        String[] result = actual.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly(expected);
    }

    @Test
    @DisplayName("() 문자열 제거하기")
    void subStringTest() {
        String actual = "(1,2)";
        String expected = "1,2";
        String result = actual.substring(1, 4);

        assertThat(expected).isEqualTo(result);
    }

    @Test
    @DisplayName("특정 위치의 문자 가져올 때 위치값을 벗어나면 에러발생")
    void charAtTest() {
        String actual = "abc";
        int index = 5;

        assertThatThrownBy(() -> actual.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(index));
    }
}
