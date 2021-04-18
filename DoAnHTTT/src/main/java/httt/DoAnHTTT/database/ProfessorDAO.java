package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Professor;
import httt.DoAnHTTT.model.User;

public class ProfessorDAO implements IDAO<Professor> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ProfessorDAO() {
		conn = Connect.getConnection();
	}

	public int selectTop1ID_Professor() {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("select top 1 ID_Professor from Professor order by ID_Professor DESC");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = Integer.parseInt(rs.getString("ID_Professor"));
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
		return result + 1;
	}

	@Override
	public Professor getByKey(String key) {
		Professor professor = null;
		try {
			pstmt = conn.prepareStatement("select * from Professor where ID_Professor = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDAO dao1 = new UserDAO();
				User user = dao1.getByKey(key);
				String Professor_Name = rs.getString("Professor_Name");
				String ID_Faculty = rs.getString("ID_Faculty");
				FacultyDAO dao2 = new FacultyDAO();
				Faculty faculty = dao2.getByKey(ID_Faculty);
				Date create_date = new Date(rs.getDate("Create_date").getTime());
				String Degree = rs.getString("Degree");
				professor = new Professor(user, Professor_Name, faculty, create_date, Degree);

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
		return professor;
	}

	@Override
	public Professor getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Professor key) {
		String ID_Professor = key.getUser().getiD_User();
		String Professor_Name = key.getProfessor_Name();
		String ID_Faculty = key.getFaculty().getiD_Faculty();
		Date date = key.getCreate_date();
		String Degree = key.getDegree();
		try {
			pstmt = conn.prepareStatement("insert into Professor Values(?,?,?,?,?)");
			pstmt.setString(1, ID_Professor);
			pstmt.setString(2, Professor_Name);
			pstmt.setString(3, ID_Faculty);
			pstmt.setDate(4, new java.sql.Date(date.getTime()));
			pstmt.setString(5, Degree);
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
		return false;
	}

	@Override
	public boolean update(Professor key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Professor key) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
//		java.util.Date date1 = new Date();
//		java.sql.Date date = new java.sql.Date(date1.getTime());
//		System.out.println(date);
		ProfessorDAO professorDAO = new ProfessorDAO();
		System.out.println(professorDAO.selectTop1ID_Professor());
	}
}
