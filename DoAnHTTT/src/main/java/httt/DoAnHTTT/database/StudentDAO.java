package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Class;
import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.User;

public class StudentDAO implements IDAO<Student> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public StudentDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Student getByKey(String key) {
		Student student = null;
		try {
			pstmt = conn.prepareStatement("select * from Student where ID_Student = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Student = rs.getString("ID_Student");
				UserDAO userDao = new UserDAO();
				User user = userDao.getByKey(ID_Student);
				String Student_Name = rs.getString("Student_Name");
				String ID_Faculty = rs.getString("ID_Faculty");
				FacultyDAO facultyDAO = new FacultyDAO();
				Faculty faculty = facultyDAO.getByKey(ID_Faculty);
				Date create_date = rs.getDate("Create_date");
				String Class_code = rs.getString("Class_code");
				ClassDAO classDAO = new ClassDAO();
				httt.DoAnHTTT.model.Class class1 = classDAO.getByKey(Class_code);
				int Cert_number_required = rs.getInt("Cert_number_required");
				int Cert_number_accumulated = rs.getInt("Cert_number_accumulated");
				student = new Student(user, Student_Name, faculty, create_date, class1, Cert_number_required,
						Cert_number_accumulated);

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
		return student;
	}

	@Override
	public Student getByKeyS(List<String> key) {
		return null;
	}

	@Override
	public boolean insert(Student key) {
		return false;
	}

	@Override
	public boolean update(Student key) {
		return false;
	}

	@Override
	public boolean delete(Student key) {
		// TODO Auto-generated method stub
		return false;
	}

	public void insertN(int khoa, String name, String maNganh) {
		String ID_Student = getID_Student(khoa, maNganh);
		User user = new User(ID_Student, "st", ID_Student + "@st.hcmuaf.edu.vn", "123456");
		UserDAO dao = new UserDAO();
		dao.insert(user);
		FacultyDAO facultyDAO = new FacultyDAO();
		Faculty faculty = facultyDAO.getByKey(maNganh);
		ClassDAO classDAO = new ClassDAO();
		Class class1 = classDAO.getByForNStudent(khoa, maNganh);
		Student student = new Student(user, ID_Student, faculty, new Date(), class1, 0, 0);
		insert(student);

	}

	private String getID_Student(int khoa, String maNganh) {
		String ID_Student = null;
		try {
			pstmt = conn.prepareStatement("select * from class where SUBSTRING(Class_code,3,2) = ? and ID_Faculty = ?");
			pstmt.setString(1, new String("" + khoa).trim());
			pstmt.setString(2, maNganh);
			rs = pstmt.executeQuery();
			while (rs.next()) {

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
		return ID_Student;
	}

	public int getCert_number_accumulated(String ID_Student) {
		int Cert_number_accumulated = 0;
		try {
			pstmt = conn.prepareStatement("select Cert_number_accumulated from Student where ID_Student = ?;");
			pstmt.setString(1, ID_Student);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cert_number_accumulated = rs.getInt("Cert_number_accumulated");
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
		return Cert_number_accumulated;
	}

	public void updateStudent(String ID_Student, int Cert_number_accumulated) {
		try {
			pstmt = conn.prepareStatement("update Student Set Cert_number_accumulated = ? where ID_Student = ?");
			pstmt.setInt(1, Cert_number_accumulated);
			pstmt.setString(2, ID_Student);
			int row = pstmt.executeUpdate();
			System.out.println(row);
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
	}

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();
		// studentDAO.updateStudent("18130006", 0);
		// System.out.println(studentDAO.getCert_number_accumulated("18130006"));
		Student student = studentDAO.getByKey("18130005");
	}
}
