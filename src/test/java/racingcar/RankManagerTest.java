package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;
import racingcar.model.RankManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.common.TestConstants.MOVING_FORWARD;
import static racingcar.common.TestConstants.STOP;
import static racingcar.common.TestConstants.USER_DUNA;
import static racingcar.common.TestConstants.USER_HANA;

public class RankManagerTest {
  @Test
  public void get_one_winner_test() {
    List<RacingCar> carList = new RacingCarBuilder().createCars("hana,duna");
    RacingCar hanaCar = carList.get(0);
    RacingCar dunaCar = carList.get(1);
    hanaCar.runCar(MOVING_FORWARD);
    dunaCar.runCar(STOP);
    List<String> winners = new RankManager(carList).getWinners();
    assertThat(winners.get(0)).isEqualTo("hana");
  }

  @Test
  public void get_two_winner_test() {
    List<RacingCar> carList = new RacingCarBuilder().createCars("hana,duna");
    RacingCar hanaCar = carList.get(0);
    RacingCar dunaCar = carList.get(1);
    hanaCar.runCar(MOVING_FORWARD);
    dunaCar.runCar(MOVING_FORWARD);
    List<String> winners = new RankManager(carList).getWinners();
    assertThat(winners).contains(USER_HANA);
    assertThat(winners).contains(USER_DUNA);
  }

  @Test
  public void get_no_winner_test() {
    List<RacingCar> carList = new RacingCarBuilder().createCars("hana,duna");
    RacingCar hanaCar = carList.get(0);
    RacingCar dunaCar = carList.get(1);
    hanaCar.runCar(STOP);
    dunaCar.runCar(STOP);
    List<String> winners = new RankManager(carList).getWinners();
    assertThat(winners).isNotIn(USER_HANA);
    assertThat(winners).isNotIn(USER_DUNA);
  }
}
