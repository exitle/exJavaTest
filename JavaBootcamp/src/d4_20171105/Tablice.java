package d4_20171105;

import java.util.Arrays;

/**
 * Created: 05.11.17.
 */
public class Tablice {
    public static void main(String[] args) {
        int[] t1 = {2, 5, 4, 8, 9, 5, 10, 5, 3};
        int[] t2 = {9, 4, 8, 34, 76, 32, 87, 4, 3, 2};

        System.out.printf("Min: %s%nMax: %s%nAvg: %s%nMed: %s%n", arrMin(t1), arrMax(t1), arrAvg(t1), arrMed(t1));
        System.out.printf("Min: %s%nMax: %s%nAvg: %s%nMed: %s%n", arrMin(t2), arrMax(t2), arrAvg(t2), arrMed(t2));

    }

    private static double arrAvg(int[] ti) {
        double sum = 0;
        for (int i : ti) {
            sum += i;
        }
        return sum / ti.length;
    }

    private static int arrMax(int[] ti) {
        int max = Integer.MIN_VALUE;
        for (int i : ti) {
            max = (i > max) ? i : max;
        }
        return max;
//        return Collections.max(Arrays.stream(ti).boxed().collect(Collectors.toList()));
//        return Arrays.stream(ti).boxed().max(Comparator.naturalOrder()).get();
    }

    private static int arrMin(int[] ti) {
        int min = Integer.MAX_VALUE;
        for (int i : ti) {
            min = (i < min) ? i : min;
        }
        return min;
//        return Collections.min(Arrays.stream(ti).boxed().collect(Collectors.toList()));
    }

    private static double arrMed(int[] ti) {
        Arrays.sort(ti);
        if (ti.length % 2 == 0) {
            return ((double) ti[ti.length / 2] + (double) ti[ti.length / 2 - 1]) / 2;
        } else {
            return (double) ti[ti.length / 2];
        }
    }


}
