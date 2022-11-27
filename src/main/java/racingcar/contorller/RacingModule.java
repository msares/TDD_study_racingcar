package racingcar.contorller;

import racingcar.model.MovingUtil;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;

import java.util.ArrayList;
import java.util.List;

public class RacingModule {
  public static void race(String carNames, int tryCount) {
    List<RacingCar> racingCars = new RacingCarBuilder(carNames).createCars();
    for (int i = 0; i < tryCount; i++) {
      run(racingCars);
    }
  }

  private static void run(List<RacingCar> cars) {
    for (RacingCar car : cars) {
      car.runCar(MovingUtil.getRandomValue());
      car.printCarInfo();
    }
  }

  private static String getWinner(List<RacingCar> cars) {
    List<RacingCar> winner = new ArrayList<>();
    int maxPosition = 0;
    for (RacingCar car : cars) {

    }
    return null;
  }
}
