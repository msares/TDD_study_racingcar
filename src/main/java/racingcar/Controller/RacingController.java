package racingcar.Controller;

import racingcar.Model.RacingUser;

import java.util.ArrayList;

public class RacingController {
    private ArrayList<RacingUser> userList;

    public RacingController(){
        userList = new ArrayList<RacingUser>();
    }

    public void addRacingUserToList(String name)
    {
        RacingUser user = new RacingUser(name);
        userList.add(user);
    }

    public ArrayList<RacingUser> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<RacingUser> userList) {
        this.userList = userList;
    }



}
