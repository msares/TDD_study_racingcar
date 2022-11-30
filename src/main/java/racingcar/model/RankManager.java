package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static racingcar.common.GameConstants.NUMBER_ZERO;

public class RankManager {
  private static List<RacingCar> cars;
  private static List<String> winners;
  private static int winnerPosition;

  public RankManager(List<RacingCar> racingCars) {
    winners = new ArrayList<>();
    winnerPosition = 0;
    cars = racingCars;
  }

  public List<String> getWinners() {

    for (RacingCar car : cars) {
      winnerPosition = getWinnerPosition(car.getMovingStage());
    }

    if (winnerPosition == NUMBER_ZERO) {
      return winners;
    }

    for (RacingCar car : cars) {
      addWinners(car);
    }

    return winners;
  }

  private int getWinnerPosition(int compareValue) {
    return Math.max(winnerPosition, compareValue);
  }

  private void addWinners(RacingCar car) {
    if (car.getMovingStage() == winnerPosition) {
      winners.add(car.getName());
    }
  }
}
