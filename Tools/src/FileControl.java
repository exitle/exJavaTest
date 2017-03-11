import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileControl {
	private File file;
	private String fileContents;

	public FileControl(String fileName) {
		try {
			this.file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			this.fileContents = new String();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readFile() {
		try {
			Scanner s = new Scanner(this.file);
			while (s.hasNextLine()) {
				this.fileContents += "\n" +s.nextLine();
			}
			s.close();
			return this.fileContents;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
 
	public String printFile() {
		return fileContents;
	}

	public boolean writeFile(String content) {
		try {
			FileWriter fw = new FileWriter(this.file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content + "\n");
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
