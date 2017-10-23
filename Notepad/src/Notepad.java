import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {
   private File f;

   Notepad(File f) {
      this.f = f;
      if (!f.exists()) {
         try {
            f.createNewFile();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   private String readFile() {
      BufferedReader br;
      StringBuilder sb = new StringBuilder();
      try {
         br = new BufferedReader(new FileReader(this.f));
         String ln = "";
         while ((ln = br.readLine()) != null) {
            sb.append(String.format("%s%n", ln));
         }
         br.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return sb.toString();
   }

   private void writeFile(String text) {
      try {
         FileWriter fw = new FileWriter(this.f);
         fw.write(text);
         fw.flush();
         fw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   public String read() {
      return readFile();
   }

   public void write(String text) {
      writeFile(text);
   }
   
   public void append(String text) {
      String content = read();
      write(content + String.format("%s%n", text));
   }

}
