package racingcar.model;

import racingcar.common.GameConstants;

import java.util.ArrayList;
import java.util.List;

public class RacingCarBuilder {
  public RacingCarBuilder() { // 모든 클래스는 반드시 하나이상의 생성자를 가져야 함. 개발자가 별도의 생성자를 작성하지 않을 경우 컴파일러가 빈 생성자(파라미터로 아무것도 받지 않는 생성자)를 추가하도록 설정되어 있음.
  }

  public List<RacingCar> createCars(String carNames) {
    List<RacingCar> cars = new ArrayList<>();
    for (String carName : carNames.split(GameConstants.DELIMITER)) {
      String name = carName.trim();
      cars.add(new RacingCar(name));
    }
    return cars;
  }
}