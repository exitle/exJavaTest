package d2;

import java.util.*;

/**
 * Created by exitle on 22.10.17.
 */
public class ZCollections {

    public void s1() {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int los;
        for (int i = 0; i < 6; i++) {
            los = 1 + (int) (Math.random() * ((49 - 1) + 1));
            if (numbers.indexOf(los) == -1) {
                numbers.add(los);
            }
        }
        System.out.println(numbers.toString());
    }

    public void s2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj ilość liczb");
        int n = sc.nextInt();
        if (!sc.hasNext()) {
            sc.nextLine();
        }
        System.out.println("Podaj liczby (oddzielane spacją)");
        String s = sc.nextLine();
        System.out.println(s);
        String[] st = s.split(" ");

        List<List<Integer>> ls = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for (String str : st) {
            if (mp.containsKey(Integer.parseInt(str))) {
                mp.put(Integer.parseInt(str), mp.get(Integer.parseInt(str)) + 1);
            } else {
                mp.put(Integer.parseInt(str), 1);
            }
        }
        System.out.println(mp);
    }

    public String s3(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("mama", "mother");
        return map.get(s);
    }

    public void s4(int n) {
        System.out.println(Integer.toString(n, 2));
    }

}
