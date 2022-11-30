package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    public static int makeRandomNumber() {
        return pickNumberInRange(0,9);
    }
}
