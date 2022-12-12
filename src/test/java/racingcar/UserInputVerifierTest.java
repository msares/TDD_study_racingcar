package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.common.ErrorConstants;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;
import racingcar.model.UserInputVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.TestConstants.USER_DUNA;
import static racingcar.common.TestConstants.USER_HANA;
import static racingcar.common.TestConstants.USER_NAMES;

public class UserInputVerifierTest extends NsTest {
  @Test
  public void testCarName_split_car_names() {
    List<RacingCar> carList = new RacingCarBuilder().createCars(USER_NAMES);
    assertThat(carList.get(0).getName()).isEqualTo(USER_HANA);
    assertThat(carList.get(1).getName()).isEqualTo(USER_DUNA);
  }

  @Test
  void carName_empty_string_test() {
    assertThatThrownBy(
      () -> new RacingCarBuilder()
        .createCars(" ,duna"))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage(ErrorConstants.BLANK_STRING_ERROR);
  }

  @Test
  void carName_outOfRange_test() {
    assertThatThrownBy( // hasMessageContaining()
      () -> new RacingCarBuilder().createCars("hanaIsHappy,duna"))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage(ErrorConstants.CAR_NAME_OUT_OF_BOUND_ERROR);
  }

  @Test
  void tryCount_test() {
    assertThat(new UserInputVerifier().validateTryCount("5")).isEqualTo(5);
  }

  @Test
  void tryCount_invalid_number_format_test() {
    assertThatThrownBy(
      () -> new UserInputVerifier().validateTryCount("a"))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage(ErrorConstants.NUMBER_FORMAT_ERROR);
  }

  @Test
  void tryCount_number_out_of_range_test() {
    assertThatThrownBy(
      () -> new UserInputVerifier().validateTryCount("-1"))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage(ErrorConstants.NUMBER_OUT_OF_RANGE_ERROR);
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
