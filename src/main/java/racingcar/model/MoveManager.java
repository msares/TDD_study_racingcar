package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.common.GameConstants.COMPARE_VALUE;

public class MoveManager {
  public static int getRandomValue() {
    int randomNum = Randoms.pickNumberInRange(0, 9);
    return randomNum;
  }

  public static boolean compareValue(int randomValue) {
    return COMPARE_VALUE <= randomValue;
  }
}
