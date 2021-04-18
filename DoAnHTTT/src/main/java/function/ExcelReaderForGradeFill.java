package function;

//reading value of a particular cell  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import httt.DoAnHTTT.database.CourseDAO;
import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.database.StudentDAO;
import httt.DoAnHTTT.database.Sub_PassDAO;
import httt.DoAnHTTT.model.Sub_Pass;

public class ExcelReaderForGradeFill {
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
		Sub_PassDAO sub_PassDAO = new Sub_PassDAO();
		SemesterDAO semesterDAO = new SemesterDAO();
		CourseDAO courseDAO = new CourseDAO();
		StudentDAO studentDAO = new StudentDAO();
		// obtaining input bytes from a file
		FileInputStream fis = new FileInputStream(new File("src\\main\\webapp\\File\\GradeFill.xlsx"));
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
				String ID_Course = FormatID(row.getCell(0).getStringCellValue());
				String Name_Course = row.getCell(1).getStringCellValue();
				double Score = row.getCell(2).getNumericCellValue();
				String ID_Student = FormatID(row.getCell(3).getStringCellValue());
				String ID_Semester = FormatID(row.getCell(4).getStringCellValue());
				System.out.println(
						ID_Course + "\t" + Name_Course + "\t" + Score + "\t" + ID_Student + "\t" + ID_Semester);
				// check xem student da hoc qua mon nay hay chua
				boolean check = sub_PassDAO.checkScoreSub_Pass(ID_Student, ID_Course);
				System.out.println(check);
				if (check == true) {
					if (Score < 4.0) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 0, "F"));
					} else if (Score >= 4.0 && Score < 5.0) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 1.0, "D"));
					} else if (Score >= 5.0 && Score < 5.5) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 1.5, "D+"));
					} else if (Score >= 5.5 && Score < 6.5) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 2.0, "C"));
					} else if (Score >= 6.5 && Score < 7.0) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 2.5, "C+"));
					} else if (Score >= 7.0 && Score < 8.0) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 3.0, "B"));

					} else if (Score >= 8.0 && Score < 8.5) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 3.5, "B+"));
					} else {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 4.0, "A"));
					}
				} else {
					if (Score < 4.0) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 0, "F"));
					} else if (Score >= 4.0 && Score < 5.0) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 1.0, "D"));
						int Course_certificate = courseDAO.getCourse_certificate(ID_Course);
						int Cert_number_accumulated = studentDAO.getCert_number_accumulated(ID_Student);
						studentDAO.updateStudent(ID_Student, Course_certificate + Cert_number_accumulated);
					} else if (Score >= 5.0 && Score < 5.5) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 1.5, "D+"));
						int Course_certificate = courseDAO.getCourse_certificate(ID_Course);
						int Cert_number_accumulated = studentDAO.getCert_number_accumulated(ID_Student);
						studentDAO.updateStudent(ID_Student, Course_certificate + Cert_number_accumulated);
					} else if (Score >= 5.5 && Score < 6.5) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 2.0, "C"));
						int Course_certificate = courseDAO.getCourse_certificate(ID_Course);
						int Cert_number_accumulated = studentDAO.getCert_number_accumulated(ID_Student);
						studentDAO.updateStudent(ID_Student, Course_certificate + Cert_number_accumulated);
					} else if (Score >= 6.5 && Score < 7.0) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 2.5, "C+"));
						int Course_certificate = courseDAO.getCourse_certificate(ID_Course);
						int Cert_number_accumulated = studentDAO.getCert_number_accumulated(ID_Student);
						studentDAO.updateStudent(ID_Student, Course_certificate + Cert_number_accumulated);
					} else if (Score >= 7.0 && Score < 8.0) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 3.0, "B"));
						int Course_certificate = courseDAO.getCourse_certificate(ID_Course);
						int Cert_number_accumulated = studentDAO.getCert_number_accumulated(ID_Student);
						studentDAO.updateStudent(ID_Student, Course_certificate + Cert_number_accumulated);

					} else if (Score >= 8.0 && Score < 8.5) {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 3.5, "B+"));
						int Course_certificate = courseDAO.getCourse_certificate(ID_Course);
						int Cert_number_accumulated = studentDAO.getCert_number_accumulated(ID_Student);
						studentDAO.updateStudent(ID_Student, Course_certificate + Cert_number_accumulated);
					} else {
						sub_PassDAO.insert(new Sub_Pass(semesterDAO.getByKey(ID_Semester),
								courseDAO.getByKey(ID_Course), studentDAO.getByKey(ID_Student), Score, 4.0, "A"));
						int Course_certificate = courseDAO.getCourse_certificate(ID_Course);
						int Cert_number_accumulated = studentDAO.getCert_number_accumulated(ID_Student);
						studentDAO.updateStudent(ID_Student, Course_certificate + Cert_number_accumulated);
					}
				}
			}
		}
		wb.close();
	}

	public static void main(String[] args) throws IOException {
		ExcelReaderForGradeFill.InsertByExcel();
	}
}