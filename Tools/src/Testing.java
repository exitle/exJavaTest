
public class Testing {

	public static void main(String[] args) {
		FileControl fc = new FileControl("testing.txt");
//		fc.writeFile("test1");
		fc.readFile();
		System.out.println(fc.printFile());
	}

}
