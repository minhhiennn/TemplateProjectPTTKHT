package function;

//reading value of a particular cell  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import httt.DoAnHTTT.database.ClassDAO;
import httt.DoAnHTTT.database.StudentDAO;

public class ExcelReader {

	public ExcelReader() throws IOException {
	}

	public Map<String, Integer> StudentCount() throws IOException {
		FileInputStream fis = new FileInputStream(new File("src\\main\\webapp\\File\\1.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Map<String, Integer> map = new HashMap<String, Integer>();
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			if (row.getRowNum() == 0) {
				continue;
			} else {
				try {
					Iterator<Cell> cellIterator = row.cellIterator();
					int khoa = (int) cellIterator.next().getNumericCellValue();
					String ho = cellIterator.next().getStringCellValue();
					String ten = cellIterator.next().getStringCellValue();
					String maNganh = cellIterator.next().getStringCellValue();
					if (ten != null) {
						if (map.get(khoa + maNganh) == null) {
							map.put(khoa + maNganh, 1);
						} else {
							map.put(khoa + maNganh, map.get(khoa + maNganh) + 1);
						}
					}
				} catch (Exception e) {
				}
			}
		}
		return map;
	}

	public void StudentAdd() throws IOException {
		FileInputStream fis = new FileInputStream(new File("src\\main\\webapp\\File\\1.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		StudentDAO dao = new StudentDAO();
		ClassDAO classDAO = new ClassDAO();
		classDAO.createClass(StudentCount());
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			if (row.getRowNum() == 0) {
				continue;
			} else {
				try {
					Iterator<Cell> cellIterator = row.cellIterator();
					int khoa = (int) cellIterator.next().getNumericCellValue();
					String ho = cellIterator.next().getStringCellValue();
					String ten = cellIterator.next().getStringCellValue();
					String maNganh = cellIterator.next().getStringCellValue();
					dao.insertN(khoa, ho + " " + ten, maNganh);
				} catch (Exception e) {
				}
			}
		}
		classDAO.updateFullClassUpdate(StudentCount());
	}
	void StudentClean() {
	}
	public static void main(String[] args) throws IOException {
		ExcelReader excelReader = new ExcelReader();

		excelReader.StudentAdd();
	}
}