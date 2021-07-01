package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Faculty;

public class CourseDAO implements IDAO<Course> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public CourseDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Course getByKey(String key) {
		Course course = null;
		try {
			pstmt = conn.prepareStatement("select * from Course where ID_Course = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Faculty = rs.getString("ID_Faculty");
				FacultyDAO dao = new FacultyDAO();
				Faculty faculty = dao.getByKey(ID_Faculty);
				String Name_Course = rs.getString("Name_Course");
				int Course_certificate = rs.getInt("Course_certificate");
				int years = rs.getInt("years");
				int numberS = rs.getInt("numberS");
				course = new Course(key, Name_Course, faculty, Course_certificate, years, numberS);

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
		return course;
	}

	@Override
	public Course getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Course key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Course key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Course key) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCourse_certificate(String ID_Course) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("select Course_certificate from Course where ID_Course = ?");
			pstmt.setString(1, ID_Course);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("Course_certificate");
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
		return result;
	}

	// lấy all list
	public HashMap<String, ArrayList<String>> getAllCourse() {
		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
		hashMap.put("ID_Course", new ArrayList<String>());
		hashMap.put("ID_Faculty", new ArrayList<String>());
		hashMap.put("Name_Course", new ArrayList<String>());
		hashMap.put("Course_certificate", new ArrayList<String>());
		hashMap.put("years", new ArrayList<String>());
		hashMap.put("numberS", new ArrayList<String>());
		try {
			pstmt = conn.prepareStatement("Select * from Course");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Course = rs.getString("ID_Course");
				hashMap.get("ID_Course").add(ID_Course);
				String ID_Faculty = rs.getString("ID_Faculty");
				hashMap.get("ID_Faculty").add(ID_Faculty);
				String Name_Course = rs.getString("Name_Course");
				hashMap.get("Name_Course").add(Name_Course);
				int Course_certificate = rs.getInt("Course_certificate");
				hashMap.get("Course_certificate").add(String.valueOf(Course_certificate));
				int years = rs.getInt("years");
				hashMap.get("years").add(String.valueOf(years));
				int numberS = rs.getInt("numberS");
				hashMap.get("numberS").add(String.valueOf(numberS));
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
		return hashMap;
	}

	public static void main(String[] args) {
		CourseDAO courseDAO = new CourseDAO();
		HashMap<String, ArrayList<String>> hashMap = courseDAO.getAllCourse();
	    for (String string : hashMap.keySet()) {
			System.out.println(hashMap.get(string).get(1));
		}
	}
}
