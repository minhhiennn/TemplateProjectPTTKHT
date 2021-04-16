package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.Semester;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.Student_Schedule;
import httt.DoAnHTTT.model.Sub_Pass;

public class Sub_PassDAO implements IDAO<Sub_Pass> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Sub_PassDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Sub_Pass getByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sub_Pass getByKeyS(List<String> key) {
		Sub_Pass sub_Pass = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from Sub_Pass where ID_Semester = ? and ID_Course = ? and ID_Student = ?");
			pstmt.setString(1, key.get(0));
			pstmt.setString(2, key.get(1));
			pstmt.setString(3, key.get(2));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SemesterDAO semesterDAO = new SemesterDAO();
				Semester semester = semesterDAO.getByKey(key.get(0));
				CourseDAO courseDAO = new CourseDAO();
				Course course = courseDAO.getByKey(key.get(1));
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.getByKey(key.get(2));
				float Score = rs.getFloat("Score");
				String Rated = rs.getString("Rated");
				sub_Pass = new Sub_Pass(semester, course, student, Score, Rated);

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
		return sub_Pass;
	}

	@Override
	public boolean insert(Sub_Pass key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Sub_Pass key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Sub_Pass key) {
		// TODO Auto-generated method stub
		return false;
	}

}
