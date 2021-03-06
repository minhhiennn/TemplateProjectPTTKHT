package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

	public List<Course_Offering> getAll() {
		List<Course_Offering> list = new ArrayList<Course_Offering>();
		try {
			pstmt = conn.prepareStatement("select * from Course_Offering");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Course_Offering = rs.getString("ID_Course_Offering");
				String ID_Course = rs.getString("ID_Course");
				CourseDAO courseDAO = new CourseDAO();
				Course course = courseDAO.getByKey(ID_Course);
				String Class_code = rs.getString("Class_code");
				ClassDAO classDAO = new ClassDAO();
				httt.DoAnHTTT.model.Class class1 = classDAO.getByKey(Class_code);
				int Max_Size = rs.getInt("Max_Size");
				int Current_Size = rs.getInt("Current_Size");
				list.add(new Course_Offering(ID_Course_Offering, course, class1, Max_Size, Current_Size));
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
		return list;
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

	// L???y id_CourseOffering by id_Course
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
		String ID_Course_Offering = key.getiD_Course_Offering();
		try {
			pstmt = conn.prepareStatement("delete from Course_Offering where ID_Course_Offering = ?");
			pstmt.setString(1, ID_Course_Offering);
			int row = pstmt.executeUpdate();
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
		return false;
	}

	public boolean delete2(String ID_Course_Offering) {
		try {
			pstmt = conn.prepareStatement("delete from Course_Offering where ID_Course_Offering = ?");
			pstmt.setString(1, ID_Course_Offering);
			int row = pstmt.executeUpdate();
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
		return false;
	}

	// Get ALL Course_Offering
	public HashMap<String, ArrayList<String>> getAllCourseOffering() {
		HashMap<String, ArrayList<String>> hashMap = new LinkedHashMap<String, ArrayList<String>>();
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

	// check xem c?? ????? 30 ng?????i ????ng k?? hay ko
	public boolean checkCurrentSize(String ID_Course_Offering) {
		boolean bool = false;
		try {
			pstmt = conn.prepareStatement(
					"select * from Course_Offering where Current_Size < 30 and  ID_Course_Offering = ?");
			pstmt.setString(1, ID_Course_Offering);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bool = true;
				break;
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
		return bool;
	}

	// check xem c?? gi??o vi??n ????ng k?? m??n ???? hay ko
	public boolean checkProfessor(String ID_Course_Offering) {
		boolean bool = true;
		try {
			pstmt = conn.prepareStatement(
					"select DISTINCT sc.Id_Profeesor from Course_Offering co join Course c on co.ID_Course = c.ID_Course\r\n"
							+ "                               join Schedule sc on co.ID_Course_Offering = sc.ID_Course_Offering\r\n"
							+ "                               where co.ID_Course_Offering = ?;\r\n" + "");
			pstmt.setString(1, ID_Course_Offering);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("Id_Profeesor") == null) {
					bool = false;
					break;
				}
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
		return bool;
	}

	// L???y id Professor
	public String getIDProfessor(String ID_Course_Offering) {
		String ID_Professor = null;
		try {
			pstmt = conn.prepareStatement(
					"select DISTINCT sc.Id_Profeesor from Course_Offering co join Course c on co.ID_Course = c.ID_Course\r\n"
							+ "                               join Schedule sc on co.ID_Course_Offering = sc.ID_Course_Offering\r\n"
							+ "                               where co.ID_Course_Offering = ?;\r\n" + "");
			pstmt.setString(1, ID_Course_Offering);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ID_Professor = rs.getString("Id_Profeesor");
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
		return ID_Professor;
	}

	// L???y list ID_Course_Offering ko ????? ti??u chu???n ????? chu???n b??? delete
	public ArrayList<String> getListIDCourseOfferingToDelete() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement(
					"select DISTINCT co.ID_Course_Offering from Course_Offering co join Course c on co.ID_Course = c.ID_Course\r\n"
							+ "                               join Schedule sc on co.ID_Course_Offering = sc.ID_Course_Offering\r\n"
							+ "                               where sc.Id_Profeesor is null or co.Current_Size < 30");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Course_Offering = rs.getString(1);
				list.add(ID_Course_Offering);
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
		return list;
	}

	public static void main(String[] args) {
		Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
	}

}
