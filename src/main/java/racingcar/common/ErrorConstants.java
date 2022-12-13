package racingcar.common;

public class ErrorConstants {
  public static final String ERROR_PREFIX = "[ERROR]";
  public static final String BLANK_STRING_ERROR = ERROR_PREFIX + " Input cannot be empty string.";
  public static final String CAR_NAME_OUT_OF_BOUND_ERROR = ERROR_PREFIX + " Car name out ouf range.  Max length of car name : " + GameConstants.MAX_CAR_NAME_LENGTH;
  public static final String NUMBER_FORMAT_ERROR = ERROR_PREFIX + " Only numbers can be entered for the number of attempts.";
  public static final String NUMBER_OUT_OF_RANGE_ERROR = ERROR_PREFIX + "The number of attempts must be positive.";
}
