package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.common.GameConstants.COMPARE_VALUE;
import static racingcar.common.GameConstants.MAX_RANDOM_NUMBER;
import static racingcar.common.GameConstants.NUMBER_ZERO;

public class MoveManager {
  public static int getRandomValue() {
    return Randoms.pickNumberInRange(NUMBER_ZERO, MAX_RANDOM_NUMBER);
  }

  public static boolean compareValue(int randomValue) {
    return COMPARE_VALUE <= randomValue;
  }
}
