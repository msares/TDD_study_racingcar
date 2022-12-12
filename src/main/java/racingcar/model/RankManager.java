package racingcar.model;

import racingcar.common.GameConstants;

import java.util.ArrayList;
import java.util.List;

public class RankManager {
  private static List<RacingCar> cars;
  private static List<String> winners;

  public RankManager(List<RacingCar> racingCars) {
    winners = new ArrayList<>();
    cars = racingCars;
  }

  public List<String> getWinners() {
    int winnerPosition = 0;
    for (RacingCar car : cars) {
      winnerPosition = getWinnerPosition(winnerPosition, car.getMovingStage());
    }

    if (winnerPosition == GameConstants.NUMBER_ZERO) {
      return winners;
    }

    for (RacingCar car : cars) {
      addWinners(car, winnerPosition);
    }

    return winners;
  }

  private int getWinnerPosition(int maxValue, int compareValue) {
    return Math.max(maxValue, compareValue);
  }

  private void addWinners(RacingCar car, int winnerPosition) {
    if (car.getMovingStage() == winnerPosition) {
      winners.add(car.getName());
    }
  }
}
