package racingcar.model;

import java.util.*;

public class WinnerCar {
    public static final String WINNER_DELIMETER = ", ";
    public static final String BLANK_DELIMETER = " ";
    public static final int FIRST_INDEX = 0;

    public static String findWinner(CarInfo[] carInfos) {
        List<CarInfo> carInfoList = new ArrayList<>(Arrays.asList(carInfos));
        return (
                findSameMaxMoveCntCars(findMaxMoveCnt(carInfoList), carInfoList)
                .trim())
                .replace(BLANK_DELIMETER, WINNER_DELIMETER);
    }

    private static int findMaxMoveCnt(List<CarInfo> carInfos) {
        List<Integer> maxMoveCntList = new ArrayList<>();
        for(CarInfo carInfo : carInfos){
            maxMoveCntList.add(carInfo.getCarMove());
        }
        return exportMaxMoveCnt(maxMoveCntList);
    }

    private static int exportMaxMoveCnt(List<Integer> maxMoveCntList) {
        maxMoveCntList.sort(Comparator.reverseOrder());
        return maxMoveCntList.get(FIRST_INDEX);
    }

    private static String findSameMaxMoveCntCars(int exportMoveCnt, List<CarInfo> carInfos) {
        StringBuilder winners = new StringBuilder();
        for(CarInfo carInfo : carInfos) {
            winners.append(sameMaxMoveCntCar(exportMoveCnt, carInfo));
        }
        return winners.toString();
    }

    private static String sameMaxMoveCntCar(int exportMoveCnt, CarInfo carInfo) {
        if(CarMove.isSameMoveCnt(exportMoveCnt, carInfo.getCarMove())){
            return carInfo.getCar() + BLANK_DELIMETER;
        }
        return "";
    }
}
