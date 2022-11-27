package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RunTest {
  private static final int MOVING_FORWARD = 4;
  private static final int STOP = 3;
  @Test
  public void test_car_run() {
    List<RacingCar> carList = new RacingCarBuilder().createCars("hana,duna");
    RacingCar hanaCar = carList.get(0);
    RacingCar dunaCar = carList.get(1);
    hanaCar.runCar(MOVING_FORWARD);
    dunaCar.runCar(STOP);
    assertThat(hanaCar.getPosition()).isEqualTo("-");
    assertThat(dunaCar.getPosition()).isEqualTo("");
    System.out.println(hanaCar);
    System.out.println(dunaCar);
  }
}
