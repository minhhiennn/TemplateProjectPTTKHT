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

public class ProfessorDAO implements IDAO<Professor> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ProfessorDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Professor getByKey(List<String> key) {
		Professor professor = null;
		try {
			pstmt = conn.prepareStatement("select * from Professor where ID_Professor = ?");
			pstmt.setString(1, key.get(0));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Professor = rs.getString("ID_Professor");
				String Professor_Name = rs.getString("Professor_Name");
				String ID_Faculty = rs.getString("ID_Faculty");
				ArrayList<String> list = new ArrayList<String>();
				list.add(ID_Faculty);
				Faculty faculty = new FacultyDAO().getByKey(list);
				Date Create_date = rs.getDate("Create_date");
				String Degree = rs.getString("Degree");
				professor = new Professor(ID_Professor, Professor_Name, faculty, Create_date, Degree);
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
}
