package racingcar.model;

public class AdvanceCount {

    public static final int CAR_ADVANCE_OR_NOT_BASELINE = 3;

    public int totalAdvanceCount(int racingCarGameCntInput) {
        int totalAdvance = 0;
        for (int i = 0; i < racingCarGameCntInput; i++) {
            totalAdvance += isThatAdvance(RandomNumber.makeRandomNumber());
        }
        return totalAdvance;
    }

    private int isThatAdvance(int makeRandomNumber) {
        if (makeRandomNumber > CAR_ADVANCE_OR_NOT_BASELINE) {
            return 1;
        }
        return 0;
    }
}
