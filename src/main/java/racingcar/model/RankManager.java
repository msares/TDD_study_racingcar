package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RankManager {
  private static List<RacingCar> cars;
  private static List<String> winners;
  private static int winnerPosition;

  public RankManager(List<RacingCar> racingCars) {
    winners = new ArrayList<>();
    winnerPosition = 0;
    cars = racingCars;
  }

  public static List<String> getWinners() {
    for (RacingCar car : cars) {
      winnerPosition = getWinnerPosition(car.getMovingStage());
    }

    for (RacingCar car : cars) {
      addWinners(car);
    }

    return winners;
  }

  private static int getWinnerPosition(int compareValue) {
    return Math.max(winnerPosition, compareValue);
  }

  private static void addWinners(RacingCar car) {
    if (car.getMovingStage() == winnerPosition) {
      winners.add(car.getName());
    }
  }
}
