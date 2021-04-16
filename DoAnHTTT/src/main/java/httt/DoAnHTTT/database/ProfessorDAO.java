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
		// TODO Auto-generated method stub
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
}
