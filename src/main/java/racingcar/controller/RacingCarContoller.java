package racingcar.controller;

import racingcar.model.*;
import racingcar.view.RacingCarInput;
import java.util.ArrayList;
import java.util.List;

public class RacingCarContoller {

    public static void inputRacingInfo() {
        RacingCarInput racingCarInput = new RacingCarInput();
        List<Car> cars = SplitCar.splitAndCreate(racingCarInput.racingCarNameInput());
        makeCarInfo(cars, racingCarInput.racingCarGameCntInput());
    }

    private static void makeCarInfo(List<Car> cars, int racingGameCnt) {
        List<CarInfo> carInfos = new ArrayList<>();
        for (Car car : cars) {
            carInfos.add(
                    new CarInfo(car.getName()
                            , new AdvanceCount().totalAdvanceCount(racingGameCnt))
            );
        }
        StartRacingGame.start(carInfos);
    }
}
