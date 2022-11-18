package racingcar;

public class ValidationUtils {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ERROR_PREFIX_MESSAGE = "[ERROR]";
    private static final String INVALID_INPUT_CAR_NAME = "자동차이름의 크기는 1자이상 5자 이하여야합니다.";
    private static final String NULL_INPUT_CAR_NAME = "자동차이름이 입력되지 않았습니다.";

    public static String validateCarName(String carName) {
        if (isNullCarName(carName)) {
            makeIllegalArgumentException(NULL_INPUT_CAR_NAME);
        }
        if (invalidSizeCarName(carName)) {
            makeIllegalArgumentException(INVALID_INPUT_CAR_NAME);
        }
        return carName;
    }

    private static void makeIllegalArgumentException(String exceptionCause) {
        throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + exceptionCause);
    }

    private static boolean invalidSizeCarName(String carName) {
        return carName.length() > MAX_CAR_NAME_LENGTH;
    }

    private static boolean isNullCarName(String carName) {
        return carName == null || carName.isEmpty();
    }
}
