import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {

   public static void main(String[] args) {
      
      DecimalFormat f = new DecimalFormat("##.00");

      // try {
      // Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","mkdir
      // /home/test18"});
      // } catch (IOException e) {
      // e.printStackTrace();
      // }

      // Properties p = new Properties(System.getProperties());
      // System.getProperties().list(System.out);

      TextReader tr = new TextReader(new File("FL_insurance_sample.csv"), ",");
//      System.out.println(tr.getFileMapList("eq_site_limit").size());

//      tr.transpose();
      
      List<String> pct = new ArrayList<String>();
      for (int i=0;i<tr.getFileMapList("eq_site_limit").size();i++){
         pct.add(Double.toString(Math.random()));
      }
      
      tr.getFileMap().put("Perc", pct);
      
      List<String> newCol = new ArrayList<String>();
      for (int i=0;i<tr.getFileMapList("eq_site_limit").size()-1;i++){
         double newVal = Double.parseDouble(tr.getFileMap().get("Perc").get(i))*Double.parseDouble(tr.getFileMap().get("eq_site_limit").get(i));
         newCol.add(Double.toString(newVal));
      }
      tr.getFileMap().put("newCol", newCol);
      
      
//      System.out.println(tr.getFileMap().get("Perc").toString());
//      System.out.println(tr.getFileMap().get("newCol"));
      
      // List<String> row = new ArrayList<String>(tr.getColumnCount());
      // for (int i = 0; i < tr.getColumnCount() - 3; i++) {
      // row.add("Kolumna" + i);
      // }
      // tr.addRow(row);
      //
      // List<String> col = new ArrayList<String>(tr.getRowCount());
      // for (int j = 0; j < tr.getRowCount() - 3; j++) {
      // col.add("Wiersz" + j);
      // }
      // tr.addColumn(col);

      // System.out.println(tr.getFileList().toString());
//       System.out.println(tr.getFileMap());

      //new TextWriter(tr, "Test.csv", ",");

   }

}
