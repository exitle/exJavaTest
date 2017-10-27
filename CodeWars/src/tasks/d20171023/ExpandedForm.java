package tasks.d20171023;

public class ExpandedForm {
    /*
    Write Number in Expanded Form

You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
NOTE: All numbers will be whole numbers greater than 0.
     */

    public static String expandedForm(int num) {

        if(num==0) return "0";
        int nonZero = String.valueOf(num).replace("0","").length();
        char[] ct = String.valueOf(num).toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ct.length; i++) {
            if(!String.valueOf(ct[i]).equals("0")){
                sb.append(ct[i]);
                for(int j=1;j<ct.length-i;j++){
                    sb.append("0");
                }
                if (i!=ct.length-1 && nonZero!=1) sb.append(" + ");
            }
        }
        return sb.toString();
    }
}
