package function;

//reading value of a particular cell  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import httt.DoAnHTTT.database.StudentDAO;

public class ExcelReader {
	public static String FormatID(String s) {
		return s.substring(1, s.length() - 1);
	}

	public static String FormatNumber(String s) {
		StringTokenizer st = new StringTokenizer(s, ".");
		return st.nextToken();
	}

	public static String FormatDate(String s) {
		String[] s2 = s.split("/");
		String day = s2[0];
		String month = s2[1];
		String year = s2[2];
		return year + "-" + month + "-" + day;
	}

	public static void StudentAdd() throws IOException {
		FileInputStream fis = new FileInputStream(new File("src\\main\\webapp\\File\\1.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		StudentDAO dao = new StudentDAO();
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			if (row.getRowNum() == 0) {
				continue;
			} else {
				try {
					Iterator<Cell> cellIterator = row.cellIterator();
					int khoa = (int) cellIterator.next().getNumericCellValue();
					String name = cellIterator.next().getStringCellValue();
					String maNganh = cellIterator.next().getStringCellValue();
					dao.insertN(khoa, name, maNganh);
				} catch (Exception e) {
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		StudentAdd();
	}
}