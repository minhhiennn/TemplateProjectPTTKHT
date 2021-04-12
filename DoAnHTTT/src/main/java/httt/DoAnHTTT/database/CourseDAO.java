package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import httt.DoAnHTTT.model.Course;

public class CourseDAO implements IDAO<Course> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public CourseDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Course getByKey(List<String> key) {
		Course course = null;
		try {
			pstmt = conn.prepareStatement("Select * from Course where ID_Course = ?");
			pstmt.setString(1, key.get(0));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String iD_Course = rs.getString("ID_Course");
				String name_Course = rs.getString("Name_Course");
				int course_certificate = rs.getInt("Course_certificate");
				int years = rs.getInt("years");
				int numberS = rs.getInt("numberS");
				course = new Course(iD_Course, name_Course, course_certificate, years, numberS);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return course;
	}

	public static void main(String[] args) {
         CourseDAO courseDAO = new CourseDAO();
         ArrayList<String> list = new ArrayList<String>();
 		 list.add("200101");
         Course course = courseDAO.getByKey(list);
         System.out.println(course);
	}
}
