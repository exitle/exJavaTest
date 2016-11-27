import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDo {

	private File file;
	private ArrayList<String> taskList;

	public ToDo() {
		try {
			this.file = new File("ToDo.html");
			if (!file.exists()) {
				file.createNewFile();
			}
			this.taskList = new ArrayList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int selection = 1;
		while (selection != 0) {

			ToDo tList = new ToDo();
			tList.readFile();

			System.out.println("Menu:\t"
					+ "1. Wyświetl listę    "
					+ "2. Dodaj do listy    "
					+ "3. Usuń z listy    "
					+ "0. Zakończ");
			System.out.print("$ ");

			try {
				selection = sc.nextInt();
				switch (selection) {
				case 1:
					System.out.println(tList.printFile());
					break;
				case 2:
					System.out.print("Dodaj: ");
					Scanner add = new Scanner(System.in);
					boolean wr = tList.writeFile(add.nextLine());
					System.out.println(wr == true ? "Dodano.\n" : "Niepowodzenie\n");
					break;
				case 3:
					System.out.print("Usuń: ");
					String deleted = tList.removeTask(sc.nextInt());					
					System.out.println((deleted != null) ? "Usunięto: " + deleted + "\n" : "Brak elementu do usunięcia.\n");
					break;
				case 0:
					System.out.println("Do zobaczenia.");
					break;
				default:
					System.out.println("\nNiewłaściwe polecenie.");
				}
			} catch (InputMismatchException e) {
				System.out.println("aaa");
				System.out.println("\nNiewłaściwe polecenie.");
				sc.nextLine();
			}

		}
		sc.close();

	}

	public ArrayList<String> readFile() {
		try {
			Scanner s = new Scanner(this.file);
			this.taskList = new ArrayList<String>();
			while (s.hasNextLine()) {
				this.taskList.add(s.nextLine());
			}
			s.close();
			return this.taskList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String printFile() {
		String contents = "Lista:\n";
		for (int i = 0; i < this.taskList.size(); i++) {
			contents += ("\t" + (i + 1) + ". " + this.taskList.get(i) + "\n");
		}
		return contents;
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

	public String removeTask(int x) {
		if (x < 0 || x > this.taskList.size()) {
			return null;
		} else {
			clearFile();
			String deleted = this.taskList.get(x - 1);
			this.taskList.remove(x - 1);
			try {
				FileWriter fw = new FileWriter(this.file.getAbsoluteFile(),
						true);
				BufferedWriter bw = new BufferedWriter(fw);
				for (int i = 0; i < this.taskList.size(); i++) {
					bw.append(this.taskList.get(i) + "\n");
				}
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return deleted;
		}
	}

	public boolean clearFile() {
		try {
			FileWriter fw = new FileWriter(this.file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("");
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
