package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : JAKE
 * @date : 2022/09/21
 */
public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 의 size() 메소드를 활용해 Set 의 크기를 확인하는 테스트")
    void checkSetCollectionSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("컬렉션의 요소값을 포함하는지에 대한 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }

}
