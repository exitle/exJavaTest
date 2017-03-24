import java.io.File;

public class TxtReader {

   public static void main(String[] args) {

      TextReader tr = new TextReader(new File("Book.csv"), ",");
      System.out.println(tr.toString());
      tr.transpose();
      System.out.println(tr.toString());

   }

}
