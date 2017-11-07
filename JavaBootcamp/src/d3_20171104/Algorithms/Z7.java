package d3_20171104.Algorithms;

import java.io.StringReader;
import java.util.*;

/**
 * Created by exitle on 04.11.17.
 */
public class Z7 {

    public static void main(String[] args) {
        int cost = phoneBill("00:01:07,400-123-000" +
                "00:05:01,512-513-514" +
                "00:05:00,400-123-000");

        System.out.println("Total cost: " + cost);

    }

    public static int phoneBill(String s) {
        Map<String, Integer> numCount = new HashMap<>();
        Map<String, Integer> numCost = new HashMap<>();
        String number;
        int duration;
        int cost;

        List<String> calls = Arrays.asList(s.split("(?<=\\G.{20})"));
        for (String row : calls) {
            String[] ts = row.split(",");
            number = ts[1];
            duration = strTimeToSeconds(ts[0]);
            cost = calculateCost(duration);

            if (numCount.get(number) == null) {
                numCount.put(number, 1);
                numCost.put(number, cost);
            } else {
                numCount.put(number, numCount.get(number) + 1);
                numCost.put(number, numCost.get(number) + cost);
            }

        }

        String freeNumber = Collections.max(numCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        numCost.put(freeNumber,0);

        return numCost.values().stream().mapToInt(Number::intValue).sum();
    }

    public static int strTimeToSeconds(String s) {
        String[] ts = s.split(":");
        return Integer.parseInt(ts[0]) * 3600 + Integer.parseInt(ts[1]) * 60 + Integer.parseInt(ts[2]);
    }

    public static int calculateCost(int seconds) {
        int breakPoint = 600;
        if(seconds>breakPoint){
            return seconds/60*150;
        } else {
            return seconds*3;
        }
    }


}
