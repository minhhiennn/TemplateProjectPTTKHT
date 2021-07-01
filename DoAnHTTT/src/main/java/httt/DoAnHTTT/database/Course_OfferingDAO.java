package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;

import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.User;

public class Course_OfferingDAO implements IDAO<Course_Offering> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Course_OfferingDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Course_Offering getByKey(String key) {
		Course_Offering course_Offering = null;
		try {
			pstmt = conn.prepareStatement("select * from Course_Offering where ID_Course_Offering = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Course = rs.getString("ID_Course");
				CourseDAO courseDAO = new CourseDAO();
				Course course = courseDAO.getByKey(ID_Course);
				String Class_code = rs.getString("Class_code");
				ClassDAO classDAO = new ClassDAO();
				httt.DoAnHTTT.model.Class class1 = classDAO.getByKey(Class_code);
				int Max_Size = rs.getInt("Max_Size");
				int Current_Size = rs.getInt("Current_Size");

				course_Offering = new Course_Offering(key, course, class1, Max_Size, Current_Size);

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
		return course_Offering;
	}

	@Override
	public Course_Offering getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Course_Offering key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Course_Offering key) {
		try {
			pstmt = conn.prepareStatement(
					"UPDATE dbo.Course_Offering SET ID_Course = ?, Class_code = ?, Max_Size = ?,Current_Size = ? WHERE ID_Course_Offering = ?");
			pstmt.setString(1, key.getCourse().getiD_Course());
			pstmt.setString(2, key.getClass1().getClass_Code());
			pstmt.setInt(3, key.getMax_Size());
			pstmt.setInt(4, key.getCurrent_Size());
			pstmt.setString(5, key.getiD_Course_Offering());
			int row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
		return true;
	}

	// Lấy id_CourseOffering by id_Course
	public String getIDCourseOfferingByIdCourse(String id_Course) {
		String ID_CourseOffering = null;
		try {
			pstmt = conn
					.prepareStatement("select co.ID_Course_Offering from Course_Offering co where co.ID_Course = ?");
			pstmt.setString(1, id_Course);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Course_Offering = rs.getString("ID_Course_Offering");
				ID_CourseOffering = ID_Course_Offering;
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
		return ID_CourseOffering;
	}

	@Override
	public boolean delete(Course_Offering key) {
		// TODO Auto-generated method stub
		return false;
	}

	// Get ALL Course_Offering
	public HashMap<String,ArrayList<String>> getAllCourseOffering() {
		HashMap<String,ArrayList<String>> hashMap = new HashMap<String,ArrayList<String>>();
		hashMap.put("ID_Course_Offering", new ArrayList<String>());
		hashMap.put("ID_Course", new ArrayList<String>());
		hashMap.put("Class_code", new ArrayList<String>());
		hashMap.put("Max_Size", new ArrayList<String>());
		hashMap.put("Current_Size", new ArrayList<String>());
		try {
			pstmt = conn.prepareStatement("select * from Course_Offering");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Course_Offering = rs.getString("ID_Course_Offering");
				hashMap.get("ID_Course_Offering").add(ID_Course_Offering);
				String ID_Course = rs.getString("ID_Course");
				hashMap.get("ID_Course").add(ID_Course);
				String Class_code = rs.getString("Class_code");
				hashMap.get("Class_code").add(Class_code);
				int Max_Size = rs.getInt("Max_Size");
				hashMap.get("Max_Size").add(String.valueOf(Max_Size));
				int Current_Size = rs.getInt("Current_Size");
				hashMap.get("Current_Size").add(String.valueOf(Current_Size));
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
		Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
		System.out.println(course_OfferingDAO.getIDCourseOfferingByIdCourse("214274"));
	}
}
