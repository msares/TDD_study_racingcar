package racingcar.model;

public class CarInfo {
    private final Car car;
    private final CarMove carMove;

    public CarInfo(String name, int moveCnt) {
        this.car = new Car(name);
        this.carMove = new CarMove(moveCnt);
    }

    public String getCar() {
        return car.getName();
    }

    public int getCarMove() {
        return carMove.getMoveCnt();
    }
}
