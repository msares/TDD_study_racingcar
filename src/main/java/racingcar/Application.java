package racingcar;

import racingcar.contorller.GameController;

public class Application {

  public static void main(String[] args) {
    GameController gameController = new GameController();
    gameController.init();
    gameController.race();
  }
}
