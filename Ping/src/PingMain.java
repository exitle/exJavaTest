import java.util.ArrayList;
import java.util.List;

public class PingMain {
	private String[] ipTab;
	private List<List<Integer>> ipL = new ArrayList<List<Integer>>();
	private List<Integer> ip1;

	PingMain(String ip) {
		this.ipTab = ip.split("\\.");
		if (checkInputString()) {
			loopIp();
		}
	}

	private List<Integer> fillList(String s) {
		List<Integer> li = new ArrayList<Integer>();
		;
		if (s.equals("*")) {
			for (int i = 0; i <= 255; i++) {
				li.add(i);
			}
		} else {
			if (s.indexOf("-") != -1) {
				String[] tmp = s.split("\\-");
				for (int i = Integer.parseInt(tmp[0]); i <= Integer.parseInt(tmp[1]); i++) {
					li.add(i);
				}
			} else {
				li.add(Integer.parseInt(s));
			}
		}
		return li;
	}

	private void loopIp() {
		for (int i : ipL.get(0)) {
			System.out.print((ipL.get(0).size() > 1) ? String.format("%s%d%s%n", "Checking range: ", i, ".*.*.*") : "");
			for (int j : ipL.get(1)) {
				System.out.print((ipL.get(1).size() > 1)
						? String.format("%s%d%s%d%s%n", "Checking range:", i, ".", j, ".*.*") : "");
				for (int k : ipL.get(2)) {
					System.out.print(String.format("%s%d%s%d%s%d%s%n", "Checking range:", i, ".", j, ".", k, ".*"));
					for (int l : ipL.get(3)) {
						String ipVal = i + "." + j + "." + k + "." + l;
						new Ping(ipVal).start();
					}
				}
			}
		}
	}

	public boolean checkInputString() {
		boolean check = false;
		boolean isNaN;

		for (int i = 0; i < ipTab.length; i++) {

			try {
				Integer.parseInt(ipTab[i]);
				isNaN = false;
			} catch (Exception ex) {
				isNaN = true;
			}

			if (((ipTab[i].indexOf("-") == ipTab[i].lastIndexOf("-")) && ipTab[i].indexOf("-") != -1)
					|| ipTab[i].equals("*") || !isNaN) {
				ip1 = fillList(ipTab[i]);
				ipL.add(ip1);
				check = true;
			} else {
				check = false;
				System.out.printf("%s%d%s%s%n", "Argument ", i + 1, " [" + ipTab[i] + "]", " is invalid.");
				break;
			}

		}

		return check;
	}

}
