package racingcar;

import racingcar.Controller.RacingController;
import racingcar.Model.RacingUser;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    static final int NAME_MAX_LENGTH = 5;
    static final int ERROR_NAME_LENGTH_EXCEED_MAX = 101;
    static final int ERROR_NAME_LENGTH_ZERO = 102;


    static ArrayList<String> list = new ArrayList<String>();//DB연동 전이어서 list를 활용
    static RacingController racingController;
    public static void main(String[] args) {
        racingController= new RacingController();
        getNameInput();
    }

    public static void getNameInput(){
        boolean done = false;
        Scanner scan = new Scanner(System.in); // 객체 생성.
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String inputName = scan.nextLine();  // 문자열 읽기.

        while(true)
        {
            System.out.println("이름:" + inputName);
            String[] tokens= inputName.split(",");
            try{
                getNameFromTokens(tokens);
                break;
            }catch(IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            inputName = scan.nextLine();  // 문자열 읽기.
        }
        scan.close();

    }

    public static void getNameFromTokens(String[] tokens){
        String name;
        for(int i=0;i<tokens.length;i++) {
            isValidateName(tokens[i]);
            racingController.addRacingUserToList(tokens[i].toString());
        }
    }
    public static void isValidateName(String name){
        if(name.length()>NAME_MAX_LENGTH)
            errorHandler(ERROR_NAME_LENGTH_EXCEED_MAX);
        if(name.length() == 0)
            errorHandler(ERROR_NAME_LENGTH_ZERO);
    }

    public static void errorHandler(int error) throws IllegalArgumentException{
        if(error == ERROR_NAME_LENGTH_EXCEED_MAX){
            IllegalArgumentException lengthMaxError = new IllegalArgumentException("Length of name should be less than 6");
            throw lengthMaxError;
        }
        if(error == ERROR_NAME_LENGTH_ZERO){
            IllegalArgumentException lengthZeroError = new IllegalArgumentException("Blank name found, Retry another name");
            throw lengthZeroError;
        }
    }

    public static ArrayList<RacingUser> getControllerUserList()
    {
        return racingController.getUserList();
    }

}
