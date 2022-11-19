package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerCar {

    public static List<String> findWinner(CarInfo[] carInfos) {
        Map<String, Integer> carMap = new HashMap<>();
        for(CarInfo carInfo : carInfos){
            carMap.put(carInfo.getName(), carInfo.getAdvance());
        }
        return sortCarAdvance(carMap);
    }

    private static List<String> sortCarAdvance(Map<String, Integer> carMap) {
        List<String> keySet = new ArrayList<>(carMap.keySet());
        keySet.sort((o1, o2) -> carMap.get(o2).compareTo(carMap.get(o1)));
        return keySet;
    }
}
