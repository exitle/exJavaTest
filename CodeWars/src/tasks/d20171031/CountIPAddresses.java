package tasks.d20171031;

public class CountIPAddresses {
/*
Write a function that accepts a starting and ending IPv4 address, and returns the number of IP addresses from start to end, excluding the end IP address.
All input to the ipsBetween function will be valid IPv4 addresses in the form of strings. The ending address will be at least one address higher than the starting address.


Examples:
ipsBetween("10.0.0.0", "10.0.0.50") => returns 50
ipsBetween("10.0.0.0", "10.0.1.0") => returns 256
ipsBetween("20.0.0.10", "20.0.1.0") => returns 246
 */

    public static long ipsBetween(String start, String end) {
        String[] s1 = start.split("\\.");
        String[] s2 = end.split("\\.");

        int i0 = Integer.parseInt(s2[0])-Integer.parseInt(s1[0]);
        int i1 = Integer.parseInt(s2[1])-Integer.parseInt(s1[1]);
        int i2 = Integer.parseInt(s2[2])-Integer.parseInt(s1[2]);
        int i3 = Integer.parseInt(s2[3])-Integer.parseInt(s1[3]);

        long res = (i0*256*256*256) + (i1*256*256) + (i2*256) + i3;

        return res;
    }
}
