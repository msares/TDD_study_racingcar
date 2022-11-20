package racingcar.model;

import java.util.Random;

public class RacingCar {
    private static final Random RANDOM = new Random() ;
    private static final int COMPARE_VALUE = 4;
    private static final String MOVE_SINGE = "-";

    private  String name;
    private  String position;

    public RacingCar(String name) {
        this.name = name;
        this.position = "";
    }

    public void runCar() {
        if (COMPARE_VALUE <= getRandomValue()) {
            position += MOVE_SINGE;
        }
    }

    public void runCar(int randomNum) {
        if (COMPARE_VALUE <=randomNum) {
            position += MOVE_SINGE;
        }
    }

    public static int getRandomValue() {
        return RANDOM.nextInt(10);
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String toString() {
        return name + " : " + position;
    }

}
