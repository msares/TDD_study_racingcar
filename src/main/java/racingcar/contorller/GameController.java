package racingcar.contorller;

import racingcar.common.GameConstants;
import racingcar.model.MoveManager;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;
import racingcar.model.RankManager;
import racingcar.model.UserInputVerifier;
import racingcar.view.UserInputModule;

import java.util.List;


public class GameController {
  private UserInputVerifier userInputVerifier;
  private UserInputModule userInputModule;

  public GameController() {
  }

  public void init() {
    userInputVerifier = new UserInputVerifier();
    userInputModule = new UserInputModule();
  }

  public void race() {
    List<RacingCar> racingCars = createCarList();
    for (int i = 0; i < getUserInputTryCnt(); i++) {
      runCars(racingCars);
    }
    RankManager rankManager = new RankManager(racingCars);
    printWinners(rankManager.getWinners());
  }

  private List<RacingCar> createCarList() {
    List<RacingCar> racingCars = null;
    while (racingCars == null) {
      racingCars = createCars();
    }
    return racingCars;
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

  private Integer getUserInputTryCnt() {
    Integer tryCount = null;
    while (tryCount == null) {
      tryCount = getTryCount();
    }
    return tryCount;
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

  private void runCars(List<RacingCar> racingCars) {
    for (RacingCar car : racingCars) {
      car.runCar(MoveManager.getRandomValue());
    }
  }

  private static void printWinners(List<String> winners) {
    if (winners.isEmpty()) {
      System.out.println(GameConstants.WINNER_PREFIX + "없음");
      return;
    }
    System.out.println(GameConstants.WINNER_PREFIX + String.join(GameConstants.DELIMITER, winners));
  }
}
