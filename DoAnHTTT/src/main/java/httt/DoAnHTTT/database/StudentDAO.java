package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public StudentDAO() {
		conn = Connect.getConnection();
	}

	public void InsertStudent(String ID_Student, String Student_Name, String ID_Faculty, String Create_date, String Class_code,
			String Cert_number_required, String Cert_number_accumulated) {
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
	}
}
