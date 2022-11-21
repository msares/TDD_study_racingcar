package racingcar;

import racingcar.Controller.RacingController;
import racingcar.Model.RacingUser;

import java.util.ArrayList;
import java.util.Iterator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static final int NAME_MAX_LENGTH = 5;
    static final int GAME_SIZE_MAX_LENGTH = 100;
    static RacingErrorCode errorCode = new RacingErrorCode();
    static RacingController racingController;
    public static void main(String[] args) {
        racingController= new RacingController();
        scanNameInput();
        scanGameCountInput();
        racingController.racingMatchStarts();
        printWinner();
    }

    public static void scanNameInput(){
        String inputName;
        while(true) {
            try{
                System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
                inputName = readLine();  // 문자열 읽기.
                getNameFromTokens(inputName);
                break;
            }catch(IllegalArgumentException | IllegalStateException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
        System.out.println("이름:" + inputName);
    }

    public static void scanGameCountInput(){
        int gameSize = 0;
        while(true) {
            try{
                System.out.println("시도 할 횟수");
                gameSize = Integer.parseInt(readLine());  // 문자열 읽기.
                isValidateGameCount(gameSize);
                break;
            }catch(IllegalArgumentException | IllegalStateException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
        System.out.println("카운트 : " + gameSize);
        racingController.setGameSize(gameSize);
    }

    public static void getNameFromTokens(String inputLine){
        String[] tokens= inputLine.split(",");
        for(int i=0;i<tokens.length;i++) {
            isValidateName(tokens[i]);
            racingController.addRacingUserToList(tokens[i].toString());
        }
    }

    public static void isValidateName(String name){
        if(name.length()>NAME_MAX_LENGTH)
            errorHandlerForName(errorCode.ERROR_NAME_LENGTH_EXCEED_MAX);
        if(name.length() == 0)
            errorHandlerForName(errorCode.ERROR_NAME_LENGTH_ZERO);
        duplicateName(name);
    }

    public static void duplicateName(String name){
        for(RacingUser user : getControllerUserList()) {
            isSameName(user.getName(), name);
        }
    }

    public static void isSameName(String userName, String newName) {
        if(userName.equals(newName)) {
            errorHandlerForName(errorCode.ERROR_NAME_DUPLICATED);
        }
    }

    public static void isValidateGameCount(Integer count){
        if(count == 0 || count > GAME_SIZE_MAX_LENGTH || count < 0){
            errorHandlerForMatchCount(errorCode.ERROR_GAME_COUNT_NOT_VALID);
        }
    }

    public static void errorHandlerForName(int error) throws IllegalArgumentException,IllegalStateException{
        clearUserList();
        if(error == errorCode.ERROR_NAME_LENGTH_EXCEED_MAX){
            throw new IllegalArgumentException("Length of name should be less than 6");
        }
        if(error == errorCode.ERROR_NAME_LENGTH_ZERO){
            throw new IllegalStateException("Blank name found, Try another name");
        }
        if(error == errorCode.ERROR_NAME_DUPLICATED){
            throw new IllegalArgumentException("There are same name for users, Try Another names");
        }
    }
    public static void errorHandlerForMatchCount(int error) throws IllegalArgumentException,IllegalStateException {
        if(error == errorCode.ERROR_GAME_COUNT_NOT_VALID){
            throw new IllegalArgumentException("Not a Valid Number for match count, Try another number");
        }
    }


    public static void printWinner(){
        String message = "최종 우승자 : ";
        for (String winnerName : getControllerWinnerList()) {
            message += winnerName + ", ";
        }
        if(message.substring(message.length() - 2).equals(", ")){
            System.out.println("FOUND");

            message = message.substring(0,message.length() - 2);
        }
        System.out.println(message);
    }

    public static ArrayList<RacingUser> getControllerUserList() {
        return racingController.getUserList();
    }

    public static ArrayList<String> getControllerWinnerList(){
        return racingController.getWinnerList();
    }
    public static void clearUserList() {
        racingController.getUserList().clear();
    }
}
