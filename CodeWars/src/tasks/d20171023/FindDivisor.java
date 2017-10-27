package tasks.d20171023;

public class FindDivisor {
    /*
    Find the number of divisors of a positive integer n.
     */

    public long numberOfDivisors(int n) {
        // TODO please write your code below this comment
        long div = 0;
        for (int i = n; i > 0; i--) {
            if (n % i == 0) {
                div++;
            }
        }
        return div;
    }

}
