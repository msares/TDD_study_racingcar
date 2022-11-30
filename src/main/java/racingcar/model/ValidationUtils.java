package racingcar.model;

public class ValidationUtils {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static String validateCarName(String carName) {
        if (isNullCarName(carName)) {
            throw new IllegalArgumentException(MessageUtil.NULL_INPUT_CAR_NAME);
        }
        if (invalidSizeCarName(carName)) {
            throw new IllegalArgumentException(MessageUtil.INVALID_INPUT_CAR_NAME);
        }
        return carName;
    }

    private static boolean invalidSizeCarName(String carName) {
        return carName.length() > MAX_CAR_NAME_LENGTH;
    }

    private static boolean isNullCarName(String carName) {
        return carName == null || carName.isEmpty();
    }
}
