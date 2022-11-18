package racingcar.model;

public class CarMove {
    private static final String SHOW_MOVE_SIGN = "-";
    private final int moveCnt;

    public CarMove(int moveCnt) {
        this.moveCnt = moveCnt;
    }

    public static String showMoveSign(CarMove carMove) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carMove.moveCnt; i++) {
            sb.append(SHOW_MOVE_SIGN);
        }
        return sb.toString();
    }
}
