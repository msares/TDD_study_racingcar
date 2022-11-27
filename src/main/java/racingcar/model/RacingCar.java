package racingcar.model;

import static racingcar.model.UserInputVerifier.validateCarName;

public class RacingCar {
  private static final int COMPARE_VALUE = 4;
  private static final String MOVE_SINGE = "-";

  private String name;
  private String position;

  public RacingCar(String name) {
    validateCarName(name);
    this.name = name;
    this.position = "";
  }

  public void runCar(int randomNum) {
    if (COMPARE_VALUE <= randomNum) {
      position += MOVE_SINGE;
    }
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }

  public void printCarInfo() {
    System.out.println(name + " : " + position);
  }
}
