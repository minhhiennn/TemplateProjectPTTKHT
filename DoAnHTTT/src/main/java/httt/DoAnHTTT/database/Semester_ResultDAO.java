package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Professor;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.Semester;
import httt.DoAnHTTT.model.Semester_Result;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.Sub_Pass;

public class Semester_ResultDAO implements IDAO<Semester_Result>{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Semester_ResultDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Semester_Result getByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Semester_Result getByKeyS(List<String> key) {
		Semester_Result semester_Result = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from Semester_Result where ID_Semester = ? and ID_Student = ?");
			pstmt.setString(1, key.get(0));
			pstmt.setString(2, key.get(1));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SemesterDAO semesterDAO = new SemesterDAO();
				Semester semester = semesterDAO.getByKey(key.get(0));
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.getByKey(key.get(2));
				float gradeAv = rs.getFloat("gradeAv");
				int creditGet = rs.getInt("creditGet");
				semester_Result = new Semester_Result(semester, student, gradeAv, creditGet);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return semester_Result;
	}

	@Override
	public boolean insert(Semester_Result key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Semester_Result key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Semester_Result key) {
		// TODO Auto-generated method stub
		return false;
	}

}