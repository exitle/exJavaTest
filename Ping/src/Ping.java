import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ping {

	public static void main(String[] args) {
		String ip;
		
		for (int i = 200; i <= 255; i++) {
			ip = "192.168.0." + i;
			boolean isAlive = isAlive(ip);
			if (isAlive) System.out.println(ip + " : " + isAlive);
		}

	}

	private static boolean isAlive(String ip) {
		String line = " ";
		Process p;
		try {
			p = Runtime.getRuntime().exec(new String[] { "bash", "-c", "ping -c 1 " + ip + " | grep '1 received'" });
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			line = br.readLine();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("e");
		}
		return (line==null) ? false : true;
	}

}
