import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class WriteToFileExample {
	public static void main(String[] args) {
		
		try {
			File file = new File("ToDo.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		int selection = 1;
		while(selection != 0){
			
			File file = new File("ToDo.txt");
			ArrayList<String> taskList = new ArrayList<String>();
			taskList = readFile(file);
			
			System.out.println(
				"Co zrobić?\n" +
				"1. Wyświetl listę	|	" +
				"2. Dodaj do listy	|	" +
				"3. Usuń z listy	|	" +
				"0. Zakończ"
				);
			System.out.print("$ ");
			selection = sc.nextInt();
			
			switch(selection){
				case 1:
					printFile(taskList);
					System.out.println("\n");
					break;
				case 2:
					System.out.print("Dodaj: ");
					writeFile(file, sc.next());
					System.out.println("\n");
					break;
				case 3:
					System.out.print("Usuń: ");
					removeTask(file, taskList, sc.nextInt());
					System.out.println("Usunięto\n\n");
					break;
				case 0:
					System.out.println("Do zobaczenia");
					break;
				default:
					System.out.println("Niewłaściwe polecenie");
			}
			
		}
		
		sc.close();
		
		
		
//		writeFile("Zabić się");	//Dodawanie do pliku.
		
		
		

		
//		removeTask(file, taskList, 2);
		

		
		
//		System.out.println(Arrays.toString(readFile(file).toArray()));
	}


	private static void removeTask(File file, ArrayList<String> list, int x) {
		clearFile(file);
		ArrayList<String> tempList = new ArrayList<String>();
		tempList=list;
		tempList.remove(x-1);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < list.size(); i++) {
				bw.append(tempList.get(i)+"\n");
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


	private static void printFile(ArrayList<String> list) {
		System.out.println("Lista:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
	}
	
	private static ArrayList<String> readFile(File file){
		ArrayList<String> list = null;
		try {
			Scanner s = new Scanner(file);
			list = new ArrayList<String>();
			while (s.hasNextLine()){
			    list.add(s.nextLine());
			}
			s.close();
		//	System.out.println(Arrays.toString(list2.toArray()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	private static void writeFile(File file, String content) {
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(content+"\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}