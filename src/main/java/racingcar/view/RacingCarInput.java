package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarInput {
    public static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_RACING_GAME_CNT = "시도할 회수는 몇회인가요?";

    public String racingCarNameInput() {
        System.out.println(INPUT_CARS_NAME);
        return Console.readLine();
    }

    public int racingCarGameCntInput() {
        System.out.println(INPUT_RACING_GAME_CNT);
        return Integer.parseInt(Console.readLine());
    }
}
