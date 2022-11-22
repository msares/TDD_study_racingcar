package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerCarTest {
    @Test
    void 우승자_찾기() {
        CarInfo[] carInfos = new CarInfo[]{
                new CarInfo("SSJ", 3)
                , new CarInfo("KHN", 1)
                , new CarInfo("LHG", 5)
        };
        List<String> strings =  WinnerCar.findWinner(carInfos);
        assertThat(strings.get(0)).isEqualTo("LHG");
    }
}
