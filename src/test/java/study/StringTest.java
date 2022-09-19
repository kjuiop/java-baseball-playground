package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
