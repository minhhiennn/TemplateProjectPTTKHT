package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Professor;

public class FacultyDAO implements IDAO<Faculty>{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public FacultyDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Faculty getByKey(List<String> key) {
		Faculty faculty = null;
		try {
			pstmt = conn.prepareStatement("select * from Faculty where ID_Faculty = ?");
			pstmt.setString(1, key.get(0));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Faculty = rs.getString("ID_Faculty");
				String Name_Faculty = rs.getString("Name_Faculty");
				faculty = new Faculty(ID_Faculty, Name_Faculty);

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
		return faculty;
	}
}
