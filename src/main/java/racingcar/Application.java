package racingcar;

import racingcar.contorller.RacingModule;
import racingcar.view.UserInputModule;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNames = UserInputModule.inputCarNames();
        int tryCnt = UserInputModule.inputTryCount();
        RacingModule.race(carNames, tryCnt);
    }
}
