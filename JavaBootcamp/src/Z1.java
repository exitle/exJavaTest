import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by exitle on 21.10.17.
 */
public class Z1 {

    public void a2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 2 values:");
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();
        double w = (double) (i1 + i2) / 2;
        System.out.println("Avg: " + w);
        sc.close();
    }

    public void a3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 2 values:");
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();

        System.out.println((i1 % i2 == 0) ? i1 / i2 : (i2-1) + "x " + (i1/(i2-1)) + " | 1x " + i1 % (i2-1));
//        System.out.println(i1 % i2);
        sc.close();
    }

    public void a4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 3 values:");
        List<Integer> li = new ArrayList<Integer>();
        li.add(sc.nextInt());
        li.add(sc.nextInt());
        li.add(sc.nextInt());

        System.out.println(Collections.min(li));
    }

    public void a5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input value:");
        System.out.println((sc.nextInt()%3==0) ? true : false);
    }

    public void a6(){
        System.out.println((int) Math.ceil(Math.random())*100);
    }


}
