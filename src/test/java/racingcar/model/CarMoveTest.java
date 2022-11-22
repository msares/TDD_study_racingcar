package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveTest {

    @Test
    @DisplayName("자동차_이동_거리에_따라_특수기호_생성하기")
    void 자동차_이동_거리에_따라_특수기호_생성하기() {
        String moveSign = CarMove.showMoveSign(new CarMove(3));
        assertThat(moveSign).isEqualTo("---");
    }
}
