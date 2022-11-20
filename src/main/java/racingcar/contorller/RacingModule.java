package racingcar.contorller;

import racingcar.model.RacingCar;

import java.util.List;

public class RacingModule {
    public static void race(String carNames, int tryCount) {
        List<RacingCar> racingCars = new RacingCarBuilder(carNames).createCars();
    }
}
