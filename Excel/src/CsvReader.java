import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class CsvReader {
	public static void main(String[] args) {
		try {
			CSVReader reader = new CSVReader(new FileReader("Book.csv"));

			//// Iterator
			// String [] nextLine;
			// while ((nextLine = reader.readNext()) != null) {
			// // nextLine[] is an array of values from the line
			// System.out.println(nextLine[0] + nextLine[1] + "etc...");
			// }

			// Get all
			List<String[]> myEntries = reader.readAll();
			for (String[] t : myEntries) {
				List<Object> z = Arrays.asList(t);
				System.out.println(Arrays.toString(t));
				// for (String s : t) {
				// System.out.println(s.toString());
				// }
			}
			
			
			reader.close();
		} catch (Exception e) {

		}
	}

}
