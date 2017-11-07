package d3_20171104.Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by exitle on 04.11.17.
 */
public class Z1 {
    public static void main(String[] args) {
        System.out.println(nwd(30,20));
//        System.out.println(nww(5, 4));
    }

    public static int nwd(int a, int b) {
        int lesserVal = (a < b) ? a : b;
        for (int i = lesserVal; i > 0; i--) {
            if(a%i==0 && b%i==0)
                return i;
        }
        return 0;
    }

    public static int nww(int a, int b) {
        List<Integer> al = new ArrayList<>();
        List<Integer> bl = new ArrayList<>();
        int ax;
        int bx;

        for (int i = 2; i < a * b; i++) {
            ax = a * i;
            bx = b * i;
            al.add(ax);
            bl.add(bx);

            if (al.indexOf(bx) != -1)
                return bx;
            if (bl.indexOf(ax) != -1)
                return ax;
        }
        return 0;
    }

}
