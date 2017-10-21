import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by exitle on 21.10.17.
 */
public class ZString {

    public void a1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert String value: ");
        System.out.println(sc.next().length());
    }

    public void a2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert string & int");
        String s = sc.next();
        int i = sc.nextInt();
        System.out.println(s.substring(s.length() - 3));
    }

    public void a3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert string");
        System.out.println((sc.next().toUpperCase().endsWith("M")) ? "tak" : "nie");
    }

    public void a4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert string");
        List<String> ls = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            ls.add(Integer.toString(i));
        }
        int ind = ls.indexOf(Character.toString(sc.next().charAt(0)));
        System.out.println((ind != -1) ? "tak" : "nie");
    }

    public void a5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert string");
        String str = sc.next();
        boolean res = Character.toString(str.charAt(0)).equals(Character.toString(str.charAt(str.length()-1)));
        System.out.println((res) ? "tak" : "nie");
    }

   public void a7(){
       System.out.println("\"Mowa jest srebrem, a milczenie złotem\"");
   }

   public void a8(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Insert 2 strings");
       String str = sc.next();
       String str2 = sc.next();
       boolean res = str.equals(str2);
       System.out.println((res) ? "tak" : "nie");
   }

}
