package racingcar.Model;

public class RacingUser {

    private String name = "";
    private Integer position = 0;
    private String status = "";

    public RacingUser() {
        name = "";
    }
    public RacingUser(String name) {
        this.name = name;
        position = 0;
    }

    public void move()
    {
        position += 1;
        status += "-";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
