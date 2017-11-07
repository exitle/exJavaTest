package d1_20171021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by exitle on 21.10.17.
 */
public class ZMetody {

    public ZMetody() {

    }

    //a5
    public boolean isPythagorean(int a, int b, int c) {
        List<Integer> li = new ArrayList<>();
        li.add(a);
        li.add(b);
        li.add(c);
        Collections.sort(li);

        return li.get(0) * li.get(0) + li.get(1) * li.get(1) == li.get(2) * li.get(2);
    }

    public boolean isSquare(int a) {
        return (Math.sqrt((double) a) % 1 == 0) ? true : false;
    }

    public boolean isCube(int a) {
        return (Math.cbrt((double) a) % 1 == 0) ? true : false;
    }

    public boolean isPrime(int a){

        return false;
    }

    public int sumOfDigits(int a) {
        int sum = 0;

//        while(a != 0){
//            sum += a%10;
//            a = a/10;
//        }

        String str = Integer.toString(a);
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.valueOf(Character.toString(str.charAt(i)));
        }
        return sum;
    }

}
