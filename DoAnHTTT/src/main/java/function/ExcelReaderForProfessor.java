package function;

//reading value of a particular cell  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import httt.DoAnHTTT.database.FacultyDAO;
import httt.DoAnHTTT.database.ProfessorDAO;
import httt.DoAnHTTT.database.UserDAO;
import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Professor;
import httt.DoAnHTTT.model.User;

public class ExcelReaderForProfessor {
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

	public static void InsertByExcel() throws IOException {
		UserDAO userDao = new UserDAO();
		ProfessorDAO professorDAO = new ProfessorDAO();
		FacultyDAO facultyDAO = new FacultyDAO();
		// obtaining input bytes from a file
		FileInputStream fis = new FileInputStream(new File("src\\main\\webapp\\File\\Professor.xlsx"));
		// creating workbook instance that refers to .xls file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// creating a Sheet object to retrieve the object
		XSSFSheet sheet = wb.getSheetAt(0);
		// evaluating cell type
		for (int i = 0; i <= sheet.getLastRowNum(); i++) // iteration over row using for each loop
		{
			Row row = sheet.getRow(i);
			if (row.getRowNum() == 0) {
				continue;
			} else {
				String ID_Professor = FormatID(row.getCell(0).getStringCellValue());
				User user = new User(ID_Professor, "pr", ID_Professor+"@st.hcmuaf.edu.vn", "123456");
				userDao.insert(user);
				String Professor_Name = row.getCell(1).getStringCellValue();
				String ID_Faculty = row.getCell(2).getStringCellValue();
				Faculty faculty = facultyDAO.getByKey(ID_Faculty);
				String Degree = row.getCell(3).getStringCellValue();
				Professor professor = new Professor(user, Professor_Name, faculty, new java.util.Date(), Degree);
				professorDAO.insert(professor);
				System.out.println(ID_Professor + "\t" + Professor_Name + "\t" + ID_Faculty + "\t" + Degree);
			}
		}
		wb.close();
	}

	public static void main(String[] args) throws IOException {
		ExcelReaderForProfessor.InsertByExcel();
	}
}