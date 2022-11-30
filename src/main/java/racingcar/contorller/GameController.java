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
  private UserInputVerifier userInputVerifier;
  private UserInputModule userInputModule ;
  private RankManager rankManager;

  public GameController() {

  }

  public void race() {
    userInputVerifier = new UserInputVerifier();
    userInputModule = new UserInputModule();
    getUserInput();
    for (int i = 0; i < tryCount; i++) {
      runCars();
    }
    rankManager = new RankManager(racingCars);
    printWinners(rankManager.getWinners());
  }


  private void getUserInput() {
    racingCars = null;
    while (racingCars == null) {
      racingCars = createCars();
    }

    tryCount = null;
    while (tryCount == null) {
      tryCount = getTryCount();
    }
  }

  private List<RacingCar> createCars() {
    try {
      String carNames = userInputModule.inputCarNames();
      return new RacingCarBuilder().createCars(carNames);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    return null;
  }

  private Integer getTryCount() {
    String userInput = userInputModule.inputTryCount();
    try {
      return userInputVerifier.validateTryCount(userInput);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void runCars() {
    for (RacingCar car : racingCars) {
      car.runCar(MoveManager.getRandomValue());
    }
  }

  private static void printWinners(List<String> winners) {
    if (winners.isEmpty()) {
      System.out.println(WINNER_PREFIX + "없음");
      return;
    }
    System.out.println(WINNER_PREFIX + String.join(DELIMITER, winners));
  }
}
