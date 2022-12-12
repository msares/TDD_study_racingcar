package racingcar.model;

import racingcar.common.GameConstants;

public class RacingCar {
  private int movingStage;
  private String position;
  private String name;

  public RacingCar(String name) {
    new UserInputVerifier().validateCarName(name);
    this.name = name;
    this.position = "";
  }

  public void runCar(int randomNum) {
    if (MoveManager.compareValue(randomNum)) {
      movingStage++;
      position += GameConstants.MOVE_SINGE;
    }
    printCarInfo();
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }

  public int getMovingStage() {
    return movingStage;
  }

  public void printCarInfo() {
    System.out.println(name + " : " + position);
  }
}
