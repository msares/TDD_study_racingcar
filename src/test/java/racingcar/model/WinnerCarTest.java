package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerCarTest {
    @Test
    void 우승자_찾기() {
        CarInfo[] carInfos = new CarInfo[]{
                new CarInfo("SSJ", 3)
                , new CarInfo("KHN", 5)
                , new CarInfo("LHG", 1)
        };
        assertThat(WinnerCar.findWinner(carInfos)).isEqualTo("KHN");
    }
    @Test
    void 중복_우승자_찾기() {
        CarInfo[] carInfos = new CarInfo[]{
                new CarInfo("SSJ", 3)
                , new CarInfo("KHN", 5)
                , new CarInfo("LHG", 5)
        };
        assertThat(WinnerCar.findWinner(carInfos)).isEqualTo("KHN, LHG");
    }
}
