package d2_20171022.classes1.vavatech;

/**
 * Created by exitle on 22.10.17.
 */
public class Task4 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 3, -2, 0, 1, 0, -3, 2, 3}));
    }

    public static int solution(int[] A) {
        int depth = 0;
        int P=0, Q=0, R=0;
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < A.length; k++) {
                    if (i == k || j == k) continue;
                    if (A[i]>A[j] && A[j]>A[k]) continue;

                    //dopisać sprawdzenie czy liczny bomiędzy i-j i j-k są malejące


                    if(i==2 && j==7 && k==9)
                        System.out.println("a");

                    tmp = Math.min(A[i]-A[j],A[k]-A[j]);
                    if (tmp>depth) {
                        depth = tmp;
                        P = i;
                        Q = j;
                        R = k;
                    }
                }
            }
        }
        System.out.println(P + " | " + Q+ " | " + R );
        return depth;
    }

}
