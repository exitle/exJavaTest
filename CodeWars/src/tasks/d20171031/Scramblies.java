package tasks.d20171031;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scramblies {
/*
Write function scramble(str1,str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

For example:
str1 is 'rkqodlw' and str2 is 'world' the output should return true.
str1 is 'cedewaraaossoqqyt' and str2 is 'codewars' should return true.
str1 is 'katas' and str2 is 'steak' should return false.

Only lower case letters will be used (a-z). No punctuation or digits will be included.
Performance needs to be considered
 */

    public static boolean scramble(String str1, String str2) {
        Pattern p = Pattern.compile("[" + str2 + "]");
        Matcher m = p.matcher(str1);

        if (m.lookingAt()) {
            for (char c : str2.toCharArray()) {
                if (!(str1.chars().filter(x -> x == c).count() >= str2.chars().filter(x -> x == c).count())) {
                    return false;
                }
            }
        }
        return m.lookingAt();
    }

}
