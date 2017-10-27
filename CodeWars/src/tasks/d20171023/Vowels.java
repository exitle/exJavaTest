package tasks.d20171023;

public class Vowels {
    /*
    Return the number (count) of vowels in the given string.

We will consider a, e, i, o, and u as vowels for this Kata.
     */

    public static int getCount(String str) {
        return str.replaceAll("[^aeiou]","").length();
    }


}
