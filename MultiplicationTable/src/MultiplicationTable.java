//import java.util.Arrays;
import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input values - x,y [columns,rows]: ");
		String wk = sc.nextLine();
		sc.close();
		String[] inVal = wk.split(",");
//		System.out.println(Arrays.toString(inVal));
		System.out.println("");

		try {
			int k = Integer.parseInt(inVal[0]);
			int w = Integer.parseInt(inVal[1]);

			if(k<100 && 2<100){
				System.out.println("Multiplication table ["+k+"x"+w+"]:\n");
				
				for(int i=1; i<=k; i++){
					System.out.print("\t"+((i<10) ? "  "+i : ((i<100) ? " "+i : ""+i)));
				}
				
				System.out.print("\n     ");
				for(int i=1; i<=(k*8); i++){
					System.out.print("_");
				}
				System.out.println("");
				
				for(int i=1; i<=w; i++){
					System.out.print(((i<10) ? "  "+i : ((i<100) ? " "+i : ""+i)));
					for(int j=1; j<=k; j++){
						System.out.print(((i*j)<1000) ? "  |  " : "  | ");
						System.out.print((((i*j)<10) ? "  "+(i*j) : (((i*j)<100) ? " "+(i*j) : ""+(i*j))));
					}
					System.out.print("  |\n");
				}
			} else {
				System.out.println("Value too high. Both values must be less than 100.");
			}
		} catch(Exception e){
			System.out.println("Invalid input.");
		}

	}

}
