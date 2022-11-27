package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.common.ErrorConstants.ERROR_PREFIX;

public class CarNameTest extends NsTest {
  @Test
  public void testCarName_split_car_names() {
    List<RacingCar> carList = new RacingCarBuilder().createCars("hana,duna");
    assertThat(carList.get(0).getName()).isEqualTo("hana");
    assertThat(carList.get(1).getName()).isEqualTo("duna");
  }

  @Test
  public void testCarName_empty_car_names() {
    List<RacingCar> carList = new RacingCarBuilder().createCars(" ,duna");
    assertSimpleTest(
      () -> {
        runException(" , duna");
        assertThat(output()).contains(ERROR_PREFIX);
      }
    );
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
