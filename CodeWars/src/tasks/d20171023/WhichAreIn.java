package tasks.d20171023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WhichAreIn {
/*
Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.

#Example 1: a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]

#Example 2: a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []

Notes:

Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.

In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.

Beware: r must be without duplicates.
*/

    public static String[] inArray(String[] array1, String[] array2) {

        List<String> l1 = Arrays.asList(array1);
        List<String> l2 = Arrays.asList(array2);
        List<String> r = new ArrayList<>();

        for (String s2 : l2) {
            for (String s1 : l1) {
                if(s2.contains(s1) && r.indexOf(s1)==-1)
                    r.add(s1);
            }
        }
        Collections.sort(r);
        String[] rs = new String[r.size()];
        rs =r.toArray(rs);

        return rs;
    }


}
