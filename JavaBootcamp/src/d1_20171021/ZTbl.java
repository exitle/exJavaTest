package d1_20171021;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by exitle on 21.10.17.
 */
public class ZTbl {

    public void a1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert comma separated numbers");
        String input = sc.next();
        List<String> li = new ArrayList<>();
        li = Arrays.asList(input.split(","));
        Collections.reverse(li);
        System.out.println(li);
    }

    public void a2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 3 values:");
        List<Integer> li = new ArrayList<Integer>();
        li.add(sc.nextInt());
        li.add(sc.nextInt());
        li.add(sc.nextInt());

        System.out.println(Collections.min(li));
    }

    public void a3() {
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(3);
        li.add(5);
        li.add(3);
        li.add(8);
        li.add(2);
        li.add(7);

        int freq = 0;
        int val = 0;
        for (int i : li) {
            if (Collections.frequency(li, i) > freq) {
                freq = Collections.frequency(li, i);
                val = i;
            }
        }
        System.out.println(val);
    }

    public void a4() {
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(3);
        li.add(5);
        li.add(3);
        li.add(8);
        li.add(2);
        li.add(7);

        int sum = 0;
        int avg = 0;

        for (int i : li) {
            sum += i;
        }
        avg = sum / li.size();

        System.out.println("Sum: " + sum + " | Avg: " + avg);
    }

    public void a5() {
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(3);
        li.add(5);
        li.add(3);
        li.add(8);
        li.add(2);
        li.add(7);

        int min = Collections.min(li);
        int max = Collections.max(li);

        System.out.printf("%s%n%s", "Min: " + min, "Max: " + max);
    }

    public void a6() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> inList = Arrays.asList(sc.nextLine().split(" "));
        List<Integer> outList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> temp = inList.subList(i, inList.size());
            int tempVal = 0;
            for (String v : temp) {
                tempVal += Integer.valueOf(v);
            }
            outList.add(tempVal);
        }

        System.out.println(outList);
    }

    public void a7() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> inList = Arrays.asList(sc.nextLine().split(" "));
        boolean cond = false;
        for (String s : inList) {
            if (Collections.frequency(inList, s) >= 3) {
                cond = true;
                break;
            }
        }
        if (cond) {
            System.out.println("TAK");
        } else {
            System.out.println("NIE");
        }
    }

    public void a8() {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int mod;

        for (int i = 0; i < 15; i++) {
            input.add(sc.nextInt());
        }

        for (int i : input) {
            mod = i % 37;

            if (output.indexOf(mod) == -1) {
                output.add(mod);
            }
        }

        System.out.println(output.size());
    }

    public void a9() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> inList = Arrays.asList(sc.nextLine().split(" "));
        String k = sc.next();

        System.out.println(Collections.frequency(inList, k));

    }

    public int[] solution(int[] A, int K) {
        List<Integer> inList = new ArrayList<>();
        inList = Arrays.stream(A).boxed().collect(Collectors.toList());

        List<Integer> outList = inList.subList(K - 1, inList.size());
        for (int i = 0; i < K - 1; i++) {
            outList.add(inList.get(i));
        }

        return outList.stream().mapToInt(i -> i).toArray();
    }

    public int solution(int[] A) {
        List<Integer> inList = Arrays.stream(A).boxed().collect(Collectors.toList());

        int res = 0;
        for (int i : inList) {
            if (Collections.frequency(inList, i) == 1) {
                res = i;
                break;
            }
        }
        return res;
    }

    public int solution2(int[] A) {
        List<Integer> inList = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<List<Integer>> aList = new ArrayList<>();

        boolean greater = false;
        boolean lesser = false;
        int res = 0;
        for (int i = 0; i < inList.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i + 1; j < inList.size() - 1; j++) {
                if ((inList.get(j) > inList.get(j - 1) && inList.get(j + 1) < inList.get(j))
                        ||
                        (inList.get(j) < inList.get(j - 1) && inList.get(j + 1) > inList.get(j))
                        ) {
                    temp.add(inList.get(j));
                }
            }
            aList.add(temp);
        }

        int size = 0;
        for (List<Integer> li : aList) {
            System.out.println(li.size());
            if (li.size() > size) size = li.size();
        }

        return size;
    }

}
