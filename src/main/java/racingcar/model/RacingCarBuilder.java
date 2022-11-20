package racingcar.model;

import org.junit.platform.commons.util.StringUtils;
import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarBuilder {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String DELIMITER = ",";
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String BLANK_STRING_ERROR = ERROR_PREFIX + " Car name cannot be empty string.";
    private static final String OUT_OF_BOUND_ERROR = ERROR_PREFIX + " Max length of car name is " + MAX_CAR_NAME_LENGTH + ".";

    private final String carNames;

    public RacingCarBuilder(String carNames) {
        this.carNames = carNames;
    }

    public List<RacingCar> createCars() {
        List<RacingCar> cars = new ArrayList<>();

        for (String carName : carNames.split(DELIMITER)) {
            String name = carName.trim();
            try {
                checkCarName(name);
            } catch (RuntimeException e) {
            }
            cars.add(new RacingCar(name));
        }

        return cars;
    }

    private void checkCarName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException(BLANK_STRING_ERROR, new IllegalArgumentException());
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException(OUT_OF_BOUND_ERROR, new IllegalArgumentException());
        }
    }
}
