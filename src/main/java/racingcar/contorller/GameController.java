package racingcar.contorller;

import racingcar.model.MoveManager;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;
import racingcar.model.RankManager;
import racingcar.model.UserInputVerifier;
import racingcar.view.UserInputModule;

import java.util.List;

import static racingcar.common.GameConstants.DELIMITER;
import static racingcar.common.GameConstants.WINNER_PREFIX;

public class GameController {
  private static List<RacingCar> racingCars;
  private static Integer tryCount;

  public static void race() {
    getUserInput();
    for (int i = 0; i < tryCount; i++) {
      runCars();
    }
    printWinners(new RankManager(racingCars).getWinners());
  }


  private static void getUserInput() {
    racingCars = null;
    while (racingCars == null) {
      racingCars = createCars();
    }

    tryCount = null;
    while (tryCount == null) {
      tryCount = getTryCount();
    }
  }

  private static List<RacingCar> createCars() {
    try {
      String carNames = UserInputModule.inputCarNames();
      return new RacingCarBuilder().createCars(carNames);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static Integer getTryCount() {
    String userInput = UserInputModule.inputTryCount();
    try {
      return UserInputVerifier.validateTryCount(userInput);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static void runCars() {
    for (RacingCar car : racingCars) {
      car.runCar(MoveManager.getRandomValue());
      car.printCarInfo();
    }
  }

  private static void printWinners(List<String> winners) {
    System.out.println(WINNER_PREFIX + String.join(DELIMITER, winners));
  }
}
