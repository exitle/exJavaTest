package dtcs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TextWriter {

	private File file;

	public TextWriter(TextReader fileList, String filename, String separator) {
		try {
			if (filename.endsWith(".csv")) {
				writeCSVFile(fileList, filename, separator);
			} else if (filename.endsWith(".xls")) {
				writeXLSFile(fileList, filename);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeCSVFile(TextReader fileList, String filename, String separator) {
		try {
			this.file = new File(filename);
			if (!this.file.exists()) {
				this.file.createNewFile();
			}
			clearFile(this.file);

			if (fileList.isTransposed())
				fileList.transpose();

			FileWriter fw = new FileWriter(this.file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < fileList.getFileList().size(); i++) {
				bw.append(String.format("%s%n", fileList.getStringRow(fileList.getRow(i))));
			}

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeCSVFile(List<List<String>> fileList, String filename, String separator) {
		try {
			this.file = new File(filename);
			if (!this.file.exists()) {
				this.file.createNewFile();
			}
			clearFile(this.file);

			FileWriter fw = new FileWriter(this.file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < fileList.size(); i++) {
				bw.append(String.format("%s%n",
						fileList.get(i).toString().replace("[", "").replace("]", "").replace(", ", ",")));
			}

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeXLSFile(TextReader fileList, String filename) {
		try {
			String sheetName = filename.substring(((filename.lastIndexOf("/")==-1) ? filename.lastIndexOf("\\") : filename.lastIndexOf("/") )+1).replace(".xls", "");
			
			FileOutputStream fileOut = new FileOutputStream(filename);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(sheetName);

			if (fileList.isTransposed())
				fileList.transpose();

			int rn = 0;
			int cn = 0;
			for (List<String> r : fileList.getFileList()) {
				HSSFRow row = sheet.createRow(rn);
				for (String c : r) {
					HSSFCell cell = row.createCell(cn);
					cell.setCellValue(c);
					cn++;
				}
				rn++;
				cn = 0;
			}

			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeXLSFile(List<List<String>> fileList, String filename) {
		try {
			String sheetName = filename.substring(((filename.lastIndexOf("/")==-1) ? filename.lastIndexOf("\\") : filename.lastIndexOf("/") )+1).replace(".xls", "");

			FileOutputStream fileOut = new FileOutputStream(filename);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(sheetName);

			int rn = 0;
			int cn = 0;
			for (List<String> r : fileList) {
				HSSFRow row = sheet.createRow(rn);
				for (String c : r) {
					HSSFCell cell = row.createCell(cn);
					cell.setCellValue(c);
					cn++;
				}
				rn++;
				cn = 0;
			}

			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public TextWriter(List<List<String>> fileList, String filename, String separator) {
		try {
			if (filename.endsWith(".csv")) {
				writeCSVFile(fileList, filename, separator);
			} else if (filename.endsWith(".xls")) {
				writeXLSFile(fileList, filename);
			}
		} catch (Exception e) {
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

}
