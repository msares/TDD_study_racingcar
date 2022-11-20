package racingcar.view;

import java.util.Scanner;

public  class UserInputModule {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할자동차이름(이름은쉼표(,)기준으로구분)");
        return scanner.nextLine();
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수");
        return scanner.nextInt();
    }
}
