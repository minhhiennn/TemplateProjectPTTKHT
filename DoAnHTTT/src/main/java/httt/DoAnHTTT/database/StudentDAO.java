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

	public void InsertStudent(String ID_Student, String Student_Name, String ID_Faculty, String Create_date,
			String Class_code, String Cert_number_required, String Cert_number_accumulated) {
		try {
			pstmt = conn.prepareStatement("insert into Student Values(?,?,?,?,?,?,?)");
			pstmt.setString(1, ID_Student);
			pstmt.setString(2, Student_Name);
			pstmt.setString(3, ID_Faculty);
			pstmt.setString(4, Create_date);
			pstmt.setString(5, Class_code);
			pstmt.setString(6, Cert_number_required);
			pstmt.setString(7, Cert_number_accumulated);
			int row = pstmt.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();
//		studentDAO.getID_Student(18, "dt");
		studentDAO.getByKey("18130005");
	}

	@Override
	public Student getByKey(String key) {
		Student student = null;
		try {
			pstmt = conn.prepareStatement("select * from Student where ID_Student = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				UserDAO userDao = new UserDAO();
				User user = userDao.getByKey(key);
				String Student_Name = rs.getString("Student_Name");
				String ID_Faculty = rs.getString("ID_Faculty");
				FacultyDAO facultyDAO = new FacultyDAO();
				Faculty faculty = facultyDAO.getByKey(ID_Faculty);
				Date create_date = new Date(rs.getDate("Create_date").getTime());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Student key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Student key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Student key) {
		// TODO Auto-generated method stub
		return false;
	}

	public void insertN(int khoa, String name, String maNganh) {
		String ID_Student = getID_Student(khoa,maNganh);
		User user = new User(ID_Student, "st", ID_Student+"@st.hcmuaf.edu.vn", "123456");
		UserDAO dao = new UserDAO();
		dao.insert(user);
		FacultyDAO facultyDAO = new FacultyDAO();
		Faculty faculty=  facultyDAO.getByKey(maNganh);
		ClassDAO classDAO = new ClassDAO();
		Class class1 = classDAO.getByForNStudent(khoa,maNganh);
		Student student = new Student(user, ID_Student, faculty, new Date(), class1, 0, 0);
		insert(student);
		
	}

	private String getID_Student(int khoa, String maNganh) {
		String ID_Student = null;
		try {
			pstmt = conn.prepareStatement("select * from class where SUBSTRING(Class_code,3,2) = ? and ID_Faculty = ?");
			pstmt.setString(1, new String(""+khoa).trim());
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
}
