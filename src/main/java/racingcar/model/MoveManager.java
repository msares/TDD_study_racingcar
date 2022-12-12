package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.GameConstants;

public class MoveManager {
  public static int getRandomValue() {
    return Randoms.pickNumberInRange(GameConstants.NUMBER_ZERO, GameConstants.MAX_RANDOM_NUMBER);
  }

  public static boolean compareValue(int randomValue) {
    return GameConstants.COMPARE_VALUE <= randomValue;
  }
}
