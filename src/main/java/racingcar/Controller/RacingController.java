package racingcar.Controller;

import racingcar.Model.RacingUser;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingController {
    private ArrayList<RacingUser> userList;
    private ArrayList<String> winnerList;
    private int gameSize = 0;
    public RacingController(){
        userList = new ArrayList<RacingUser>();
        winnerList = new ArrayList<String>();
    }

    public void addRacingUserToList(String name)
    {
        RacingUser user = new RacingUser(name);
        userList.add(user);
    }

    public void racingMatchStarts(){
        int i =0;
        while(winnerList.size() == 0) {
            getRandomNumberForUsers();
            System.out.println("");

        }
    }

    private void getRandomNumberForUsers() {
        for(RacingUser user : userList){
            int rndNumber = pickNumberInRange(0,9);
            moveUser(user,rndNumber);
            System.out.println(user.getName() + " : " +user.getStatus());
        }
    }

    private void moveUser(RacingUser user, int rndNum){
        if(rndNum >= 4)
            user.move();
        if(Integer.compare(user.getPosition(),gameSize) == 0){
            winnerList.add(user.getName());
        }
    }

    public ArrayList<RacingUser> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<RacingUser> userList) {
        this.userList = userList;
    }

    public int getGameSize() {
        return gameSize;
    }

    public void setGameSize(int gameSize) {
        this.gameSize = gameSize;
    }

    public ArrayList<String> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(ArrayList<String> winnerList) {
        this.winnerList = winnerList;
    }
}
