package racingcar.model;

public class MessageUtil {
    private static final String ERROR_PREFIX_MESSAGE = "[ERROR]";
    public static final String INVALID_INPUT_CAR_NAME = makeIllegalArgumentException("자동차이름의 크기는 1자이상 5자 이하여야합니다.");
    public static final String NULL_INPUT_CAR_NAME = makeIllegalArgumentException("자동차이름이 입력되지 않았습니다.");

    private static String makeIllegalArgumentException(String exceptionCause) {
        return ERROR_PREFIX_MESSAGE + exceptionCause;
    }
}
