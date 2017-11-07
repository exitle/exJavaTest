package d2_20171022;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by exitle on 22.10.17.
 */
public class ZPowtorka {

    public boolean isCorrectUrl(String url) {
        Pattern p = Pattern.compile("^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$");
        Matcher m;
        m = p.matcher(url);
        return m.matches();
    }

    public boolean startsWithCapital(String s) {
        String s1 = s.substring(0, 1);
        return s1.equals(s1.toUpperCase());
    }

    public void everySecondChar(String s) {
        char[] ct = s.toCharArray();
        for (int i = 0; i < ct.length; i++) {
            if (i % 2 == 0)
                System.out.print(ct[i]);
        }
        System.out.println();
    }

    public boolean isPallindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public void digitsInWord(String s) {
        String numberOnly = s.replaceAll("[^0-9]", "");
        System.out.println(numberOnly);
    }

    public double circle(double r) {
        return Math.PI * r * r;
    }

    public int sumLeft(int[] arr, int index){
        int[] tmp = Arrays.copyOfRange(arr,0,index-1);
        return IntStream.of(tmp).sum();
    }

}
