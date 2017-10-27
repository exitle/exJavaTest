package tasks.d20171023;

public class JadenCase {
    /*
    Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013). Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known for almost always capitalizing every word.

Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.

Example:

Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
Note that the Java version expects a return value of null for an empty string or null.
     */


    public String toJadenCase(String phrase) {
        // TODO put your code below this comment
        if(phrase=="" || phrase==null)
            return null;
        String[] st = phrase.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : st){
            char [] ct = s.toCharArray();
            for (int i=0;i<ct.length;i++) {
                if(i==0) {
                    sb.append(String.valueOf(ct[i]).toUpperCase());
                } else {
                    sb.append(String.valueOf(ct[i]));
                }
            }
            sb.append(" ");
        }
        return  sb.toString().trim();
    }
}
