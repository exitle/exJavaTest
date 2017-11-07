package d3_20171104.Algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by exitle on 04.11.17.
 */
public class Z3 {

    public static void main(String[] args) {
        int[] x = rotate(new int[]{3,9,5,5,1,0,5,7}, 3);
        for (int i : x) {
            System.out.println(i);
        }
    }

    public static int[] rotate(int[] ti, int k){
        if (ti==null)
            return null;

        int k1 = (k>ti.length) ? k%ti.length : k;

        int[] a1 = Arrays.copyOfRange(ti,ti.length-k1,ti.length);
        int[] a2 = Arrays.copyOfRange(ti,0,ti.length-k1);
        return IntStream.concat(Arrays.stream(a1), Arrays.stream(a2)).toArray();
    }

}
