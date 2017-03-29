import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {

	public static void main(String[] args) {

		// try {
		// Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","mkdir
		// /home/test18"});
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// Properties p = new Properties(System.getProperties());
		// System.getProperties().list(System.out);

		TextReader tr = new TextReader(new File("Book.csv"), ",");

		tr.transpose();

		List<String> row = new ArrayList<String>(tr.getColumnCount());
		for (int i = 0; i < tr.getColumnCount() - 3; i++) {
			row.add("Kolumna" + i);
		}
		tr.addRow(row);

		List<String> col = new ArrayList<String>(tr.getRowCount());
		for (int j = 0; j < tr.getRowCount() - 3; j++) {
			col.add("Wiersz" + j);
		}
		tr.addColumn(col);

		// System.out.println(tr.getFileList().toString());
		// System.out.println(tr.getFileMap());

		new TextWriter(tr, "Test.csv", ",");

	}

}
