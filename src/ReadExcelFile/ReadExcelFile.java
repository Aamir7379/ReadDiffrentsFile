package ReadExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ReadExcelFile {
	public static void main(String[] args) throws IOException {

		String path = "D:\\Byzan\\45678910_DD_vodafone_IN_YESBANK_20210223-162731-838_300_03032021165526.xls";
		String str = "";
		try {
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			//XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				HSSFRow row = sheet.getRow(i); // abc| 1001| kurla, Ammir
				Iterator<Cell> cell = row.cellIterator();
				while (cell.hasNext()) {

					str += cell.next();
					str += "|";
				}
				str += "\n";
			}

			System.out.println(str);

		} catch (Exception e) {
			e.printStackTrace();
		}

		FileOutputStream fos = null;
		try {

			File file;
			file = new File("D:/Byzan/Excel.txt");
			fos = new FileOutputStream(file);

			if (!file.exists()) {
				file.createNewFile();
			}

			byte[] bytesArray = str.getBytes();

			fos.write(bytesArray);
			fos.flush();
			System.out.println("File Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.close();
			}
		}

	}
}
