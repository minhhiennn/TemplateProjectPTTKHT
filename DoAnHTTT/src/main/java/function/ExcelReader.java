package function;

//reading value of a particular cell  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
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

	public static void main(String[] args) throws IOException {
		// obtaining input bytes from a file
		FileInputStream fis = new FileInputStream(new File("src\\main\\webapp\\File\\1.xlsx"));
		// creating workbook instance that refers to .xls file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// creating a Sheet object to retrieve the object
		XSSFSheet sheet = wb.getSheetAt(0);
		// evaluating cell type
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		for (int i = 0; i < 2; i++) // iteration over row using for each loop
		{
			Row row = sheet.getRow(i);
			if (row.getRowNum() == 0) {
				continue;
			} else {
				String ID_Student = FormatID(row.getCell(0).getStringCellValue());
				String Student_Name = row.getCell(1).getStringCellValue();
				String ID_Faculty = row.getCell(2).getStringCellValue();
				String Create_date = FormatDate(row.getCell(3).getStringCellValue());
				String Class_Code = row.getCell(4).getStringCellValue();
				String Cert_number_requiredS = FormatNumber(row.getCell(5).toString());
				String Cert_number_accumulatedS = FormatNumber(row.getCell(6).toString());
				System.out.println(ID_Student + "\t" + Student_Name + "\t" + ID_Faculty + "\t" + Class_Code + "\t"
						+ Create_date + "\t" + Cert_number_requiredS + "\t" + Cert_number_accumulatedS);
				StudentDAO studentDAO = new StudentDAO();
				studentDAO.Test(ID_Student, Student_Name, ID_Faculty, Create_date, Class_Code, Cert_number_requiredS,
						Cert_number_accumulatedS);
			}
		}
	}
}