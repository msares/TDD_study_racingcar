package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.common.TestConstants.MOVING_FORWARD;
import static racingcar.common.TestConstants.STOP;

public class RunCarTest {
  @Test
  public void car_position_test() {
    RacingCar hanaCar = new RacingCar("hana");
    RacingCar dunaCar = new RacingCar("duna");
    hanaCar.runCar(MOVING_FORWARD);
    dunaCar.runCar(STOP);
    assertThat(hanaCar.getPosition()).isEqualTo("-");
    assertThat(dunaCar.getPosition()).isEqualTo("");
  }
}
