package racingcar.model;

public class CarInfo {
    private final String name;
    private final int advance;

    public CarInfo(String name, int advance) {
        this.name = name;
        this.advance = advance;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAdvance() {
        return this.advance;
    }


}
