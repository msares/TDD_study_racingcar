package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInputModule {
  private static final String INPUT_CAR_NAME_MESSAGE = "경주할자동차이름(이름은쉼표(,)기준으로구분)";
  private static final String INPUT_TYR_CNT_MESSAGE = "시도할 회수";

  public UserInputModule() {

  }

  public String inputCarNames() {
    System.out.println(INPUT_CAR_NAME_MESSAGE);
    return Console.readLine();
  }

  public String inputTryCount() {
    System.out.println(INPUT_TYR_CNT_MESSAGE);
    return Console.readLine();
  }
}
