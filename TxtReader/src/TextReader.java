import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextReader {

   private List<List<String>> fileList = new ArrayList<List<String>>();

   TextReader(File file, String sep) {
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
         String lineVal;
         while ((lineVal = br.readLine()) != null) {
            List<String>  row = Arrays.asList(lineVal.split(sep));
            fileList.add(row);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   TextReader(File file) {
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
         String lineVal;
         while ((lineVal = br.readLine()) != null) {
            List<String> row = Arrays.asList(lineVal.split(","));
            fileList.add(row);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void transpose() {
      if (isFileOk() == false) {
         System.err.printf("%s%s", "File is corrupted", "Check file and try again");
      }
      List<List<String>> columnList = new ArrayList<List<String>>();
      for (int i = 0; i < fileList.get(0).size(); i++) {
         List<String> column = new ArrayList<String>();
         for (int j = 0; j < fileList.size(); j++) {
            column.add(fileList.get(j).get(i));
         }
         columnList.add(column);
      }
      this.fileList = columnList;
   }

   public boolean isFileOk() {
      Integer val = fileList.get(0).size();
      boolean check = true;
      for (List<String> l : fileList) {
         if (!val.equals(l.size())) {
            check = false;
         }
      }
      return check;
   }

   public List<List<String>> getFileList() {
      return fileList;
   }

   public List<String> getRow(int i) {
      try {
         return fileList.get(i - 1);
      } catch (Exception e) {
         System.err.printf("%s%s", "Provide a value between 1 and ", fileList.size());
         return null;
      }

   }

   @Override
   public String toString() {
      String contents = "";
      int i = 1;
      for (List<String> l : fileList) {
         contents += String.format("%s%s%s%n", i, ". ", l.toString());
         i++;
      }
      return contents;
   }

}
