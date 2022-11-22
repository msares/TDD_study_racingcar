package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitCarTest {
    @Test
    @DisplayName("참여자의_이름_split하고_자동차생성")
    void 참여자의_이름_split하고_자동차생성() {
        ArrayList<Car> car = SplitCar.splitAndCreate("SSJ,KHN");
        assertThat(car.get(0).getCarName()).isEqualTo("SSJ");
        assertThat(car.get(1).getCarName()).isEqualTo("KHN");
    }
}
