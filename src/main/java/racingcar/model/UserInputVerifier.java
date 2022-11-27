package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

import static racingcar.common.ErrorConstants.BLANK_STRING_ERROR;
import static racingcar.common.ErrorConstants.CAR_NAME_OUT_OF_BOUND_ERROR;
import static racingcar.common.ErrorConstants.WRONG_TRY_COUNT_OUT_OF_RANGE_ERROR;
import static racingcar.common.GameConstants.MAX_CAR_NAME_LENGTH;
import static racingcar.common.GameConstants.NUMBER_ZERO;

public class UserInputVerifier {
  public static void validateCarName(String name) {
    if (StringUtils.isBlank(name)) {
      throw new IllegalArgumentException(BLANK_STRING_ERROR);
    }
    if (MAX_CAR_NAME_LENGTH < name.length()) {
      throw new IllegalArgumentException(CAR_NAME_OUT_OF_BOUND_ERROR);
    }
  }

  public static Integer validateTryCount(String tryCount) {
    if (StringUtils.isBlank(tryCount)) {
      throw new IllegalArgumentException(BLANK_STRING_ERROR);
    }
    int tryCnt = Integer.parseInt(tryCount);
    if (tryCnt < NUMBER_ZERO) {
      throw new IllegalArgumentException(WRONG_TRY_COUNT_OUT_OF_RANGE_ERROR);
    }
    return tryCnt;
  }
}
