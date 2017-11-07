package d3_20171104.Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by exitle on 04.11.17.
 */
public class Z4 {

    public static void main(String[] args) {
        System.out.println(mainValue(new int[]{2,2,2,7,1,5}));
        System.out.println(mainValue(new int[]{2,2,2,2,7,1,5}));
    }

    public static int mainValue(int[] ti){
        Map<Integer, Integer> im = new HashMap<>();
        int len = ti.length;

        for(int i : ti) {
            if(im.get(i)==null){
                im.put(i,1);
            } else {
                int imVal = im.get(i);
                im.put(i, imVal+1);
                if(imVal+1>len/2)
                    return i;
            }
        }

        return -1;
    }

}
