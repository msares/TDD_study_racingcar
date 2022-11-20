package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.contorller.RacingCarBuilder;
import racingcar.model.RacingCar;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    public void testCarName_split_car_names() {
        List<RacingCar> carList = new RacingCarBuilder("hana,duna").createCars();
        assertThat(carList.get(0).getName()).isEqualTo("hana");
        assertThat(carList.get(1).getName()).isEqualTo("duna");
    }

   @Test
   public void test_car_run() {
        List<RacingCar> carList = new RacingCarBuilder("hana,duna").createCars();
        for (RacingCar car : carList) {
            car.runCar();
            System.out.println(car.toString());
        }
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
