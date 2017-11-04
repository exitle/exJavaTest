import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {

   private File file;

   public TextWriter(TextReader fileList, String filename, String separator) {
      try {
         this.file = new File(filename);
         if (!this.file.exists()) {
            this.file.createNewFile();
         }
         clearFile(this.file);

         if (fileList.isTransposed())
            fileList.transpose();

         FileWriter fw = new FileWriter(this.file.getAbsoluteFile(), true);
         BufferedWriter bw = new BufferedWriter(fw);

         for (int i = 0; i < fileList.getFileList().size(); i++) {
            bw.append(String.format("%s%n", fileList.getStringRow(fileList.getRow(i))));
         }

         bw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private static void clearFile(File file) {
      try {
         FileWriter fw = new FileWriter(file.getAbsoluteFile());
         BufferedWriter bw = new BufferedWriter(fw);
         bw.append("");
         bw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
