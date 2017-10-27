package tasks.d20171023;

public class Reverse {
/*
Your objective is to complete a function reverse() that receives str as String and returns the same string in reverse order


Examples:

reverse("hello world") = "dlrow olleh" (N = 11)
reverse("abcd") = "dcba" (N = 4)
reverse("12345") = "54321" (N = 5)
 */


    public String reverse(String str) {
        // your code here
        return new StringBuilder(str).reverse().toString();
    }

}
