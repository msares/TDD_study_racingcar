package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {
    @Test
    void 랜덤넘버_만들기() {
        assertThat(RandomNumber.makeRandomNumber()).isBetween(0, 9);
    }
}
