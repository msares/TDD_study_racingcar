package racingcar.contorller;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarBuilder;

import java.util.List;

public class RacingModule {
    public static void race(String carNames, int tryCount) {
        List<RacingCar> racingCars = new RacingCarBuilder(carNames).createCars();
    }
}
