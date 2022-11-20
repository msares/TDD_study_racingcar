package racingcar.model;

import java.util.Random;

public class RacingCar {
    private static final Random random = new Random();
    public static final int COMPARE_VALUE = 4;
    public static final String MOVE_SINGE = "-";
    private static String name;
    private static String position;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMovement() {
        return position;
    }

    public void runCar() {
        if (COMPARE_VALUE <= getRandomValue()) {
            position += MOVE_SINGE;
        }
    }

    public static int getRandomValue() {
        return random.nextInt(10);
    }
}
