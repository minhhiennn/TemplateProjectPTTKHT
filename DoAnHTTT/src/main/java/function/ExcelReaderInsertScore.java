package function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import httt.DoAnHTTT.database.CourseDAO;
import httt.DoAnHTTT.database.Final_ResultDAO;
import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.database.Semester_ResultDAO;
import httt.DoAnHTTT.database.StudentDAO;
import httt.DoAnHTTT.database.Sub_PassDAO;
import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Final_Result;
import httt.DoAnHTTT.model.Semester;
import httt.DoAnHTTT.model.Semester_Result;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.Sub_Pass;

public class ExcelReaderInsertScore {
	
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

	public static void InsertByScore() throws IOException {
		SemesterDAO dao = new SemesterDAO();
		StudentDAO dao2=new StudentDAO();
		CourseDAO dao3=new CourseDAO();
		
		// obtaining input bytes from a file
		FileInputStream fis = new FileInputStream(new File("src\\main\\webapp\\File\\Score.xlsx"));
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
				
				String ID_Semester = FormatID(row.getCell(3).getStringCellValue());
				 Semester semester=dao.getByKey(ID_Semester);
				 String ID_Course = FormatID(row.getCell(1).getStringCellValue());
				 Course course= dao3.getByKey(ID_Course);
				float Score=(float) row.getCell(2).getNumericCellValue();
				
				String ID_Student = FormatID(row.getCell(0).getStringCellValue());
				Student student =dao2.getByKey(ID_Student);
				Sub_PassDAO dao4=new Sub_PassDAO();
				String Rated=dao4.checkRated(Score);
				Sub_Pass pass=new Sub_Pass(semester, course, student, Score,Rated);
				dao4.insert(pass);
				Semester_ResultDAO dao5=new Semester_ResultDAO();
				Semester_Result result=new Semester_Result(semester, student,dao5.sumScore(ID_Semester) , dao5.sumcre(ID_Semester));
				dao5.insert(result);
				
			
				System.out.println(ID_Semester + "\t" + ID_Course + "\t" + ID_Student + "\t" + Score+"\t");
				System.out.println(dao5.sumScore(ID_Semester)+"\t"+dao5.sumcre(ID_Semester));
			}
		}
		wb.close();

}


public static void main(String[] args) throws IOException {
	InsertByScore();
}
}