package d2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by exitle on 22.10.17.
 */
public class Codility {

    public int s1(int N) {
        List<Integer> ln = new ArrayList<>();
        ln.add(N);

        while (N != 1) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N--;
            }
            ln.add(N);
        }
        System.out.println(ln);
        return ln.size();
    }

    public double s3(double[] A) {
        List<Double> dl = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j > i; j--) {
                dl.add(arrMultiply(Arrays.copyOfRange(A, i, j)));
            }
        }
        return Collections.max(dl);
    }

    private double arrMultiply(double[] A) {
        int temp = 1;
        for (double d : A) {
            temp *= d;
        }
        return temp;
    }

    public int s4(int[] A, int M) {
        List<List<Integer>> li = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                if (Math.abs(A[i] - A[j]) % M == 0) {
                    if (temp.indexOf(i) == -1) temp.add(i);
                    if (temp.indexOf(j) == -1) temp.add(j);
                }
            }
            li.add(temp);
        }

        int res = 0;
        for (List<Integer> l : li) {
            if (l.size() > res) res = l.size();
        }

        return res;
    }

    public int s5(int N) {
        List<String> perm = new ArrayList<>();
        permutation(N, perm);
        return perm.size();
    }

    private void permutation(int N, List<String> ls) {
        permutation("", String.valueOf(N), ls);
    }

    private void permutation(String perm, String word, List<String> ls) {
        if (word.isEmpty()) {
            if (ls.indexOf(perm + word) == -1) ls.add(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i)
                        + word.substring(i + 1, word.length()), ls);
            }
        }

    }


    /*
    Write a function:

    class Solution { public int solution(int[] A); }
    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
    Given A = [1, 2, 3], the function should return 4.
    Given A = [−1, −3], the function should return 1.

    Assume that:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
     */
    public int s6() {
        int[] A = new int[]{-1, -3};
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        int max = Collections.max(list);

        for (int i = 1; i < max; i++) {
            if (list.indexOf(i) == -1) {
                return i;
            }
        }
        return (max + 1 <= 0) ? 1 : max + 1;
    }


    /*

     */
    public int s7() {

        return 0;
    }

}
