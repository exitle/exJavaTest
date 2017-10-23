package com.xl.l4;

import java.io.File;
import java.util.List;

public class L4 {
	public static void main(String[] args) {
		String L4 = L4o();
		System.out.println(L4);
	}

	public static String L4o() {
		TextReader tr = new TextReader(new File("DV_L4.csv"));
		tr.transpose();
		String cond = "CASE ";
		for (int i = 1; i <= tr.getFileMapList("CategoryID").size(); i++) {
			String cond1 = "WHEN ";
			int j = 1;
			for (List<String> l : tr.getFileList()) {

				if (l.get(0).equals("CategoryID")) {
				} else {
					if (!l.get(i).equals("")) {
						cond1 += l.get(0) + "='" + l.get(i) + "'";
						if (j < tr.getFileMapList("CategoryID").size()) {
							cond1 += " AND ";
						} else {
							cond1 += " THEN '" + tr.getFileMapList("CategoryID").get(i - 1) + "' ";
						}
						j += 1;
					}
				}
			}
			cond += cond1;
		}
		cond += "END AS CATEGORYID";
		return cond;
	}

}
