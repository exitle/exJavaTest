package tasks.d20171031;

import java.math.BigInteger;

public class FactorialTailingZeros {
/*
Write a program that will calculate the number of trailing zeros in a factorial of a given number.

N! = 1 * 2 * 3 * ... * N

Be careful 1000! has 2568 digits...

For more info, see: http://mathworld.wolfram.com/Factorial.html

Examples

zeros(6) = 1
# 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero

zeros(12) = 2
# 12! = 479001600 --> 2 trailing zeros
 */


    public static int zeros(int n) {
        BigInteger bi = BigInteger.valueOf(n);
        String st = String.valueOf(factorial(bi));
        long maxPos = 0;
        for (int i = 1; i < 10; i++) {
            long x = st.lastIndexOf(String.valueOf(i))+1;
            if (x > maxPos) {
                maxPos = x;
            }
        }

        System.out.println(maxPos);
        System.out.println(n);
        return st.length() - (int) maxPos;
    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }


}
