package racingcar.model;

import org.junit.platform.commons.util.StringUtils;
import racingcar.common.ErrorConstants;
import racingcar.common.GameConstants;

public class UserInputVerifier {
  public UserInputVerifier() {

  }

  public void validateCarName(String name) {
    if (StringUtils.isBlank(name)) {
      throw new IllegalArgumentException(ErrorConstants.BLANK_STRING_ERROR);
    }
    if (GameConstants.MAX_CAR_NAME_LENGTH < name.length()) {
      throw new IllegalArgumentException(ErrorConstants.CAR_NAME_OUT_OF_BOUND_ERROR);
    }
  }

  public Integer validateTryCount(String tryCount) {
    int tryCnt;

    if (StringUtils.isBlank(tryCount)) {
      throw new IllegalArgumentException(ErrorConstants.BLANK_STRING_ERROR);
    }

    try {
      tryCnt = Integer.parseInt(tryCount);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(ErrorConstants.NUMBER_FORMAT_ERROR);
    }

    if (tryCnt < GameConstants.NUMBER_ZERO) {
      throw new IllegalArgumentException(ErrorConstants.NUMBER_OUT_OF_RANGE_ERROR);
    }
    return tryCnt;
  }
}
