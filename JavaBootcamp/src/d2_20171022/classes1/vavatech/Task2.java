package d2_20171022.classes1.vavatech;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by exitle on 22.10.17.
 */
public class Task2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,2,2,2,2,2,3,4,4,4,6}));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println(map);
        int res = -1;
        for (Integer i : map.keySet()) {
            if (map.get(i)>A.length/2)
                res = i;
        }

        return res;
    }

}
