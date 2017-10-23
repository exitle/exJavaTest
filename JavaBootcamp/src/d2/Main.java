package d2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Created by exitle on 22.10.17.
 */
public class Main {
    public static void main(String[] args) {

//        ZPowtorka zp = new ZPowtorka();
//        System.out.println(zp.isCorrectUrl("https://www.google.pl"));
//        System.out.println(zp.startsWithCapital("Asd"));
//        zp.everySecondChar("test1234");
//        zp.digitsInWord("tes2t12aaa3xce4");
//        System.out.println(zp.circle(5));

//        Codility cd = new Codility();
//        System.out.println(cd.s1(18));
//        System.out.println(cd.s3(new double[]{3,3,2,2,3}));
//        System.out.println(cd.s4(new int[]{-3,-2,1,0,8,7,1},3));
//        System.out.println(cd.s5(1213));
//        System.out.println(cd.s6());

//        Elevator el = new Elevator();
//        int out = el.solution(new int[]{40,40,100,80,20}, new int[]{3,3,2,2,3}, 3, 5, 200);
//        System.out.println(out);

//        ZCollections zc = new ZCollections();
//        zc.s1();
//        zc.s2();
//        System.out.println(zc.s3("mama"));
//        zc.s4(5);
        System.out.println(Period.between(LocalDate.now(),LocalDate.of(2018,05,21)).getUnits());

    }
}
