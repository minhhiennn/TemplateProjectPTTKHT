package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import httt.DoAnHTTT.model.Class;
import httt.DoAnHTTT.model.Faculty;

public class ClassDAO implements IDAO<Class> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ClassDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Class getByKey(String key) {
		Class class1 = null;
		try {
			pstmt = conn.prepareStatement("select * from Class where Class_code = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int max_Size = rs.getInt("Max_Size");
				int current_Size =rs.getInt("Current_Size");
				FacultyDAO dao = new FacultyDAO();
				Faculty faculty = dao.getByKey(key);
				class1 = new Class(key, faculty, max_Size, current_Size);

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
		return class1;
	}

	@Override
	public Class getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Class key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Class key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Class key) {
		// TODO Auto-generated method stub
		return false;
	}

	public Class getByForNStudent(int khoa, String maNganh) {
		// TODO Auto-generated method stub
		return null;
	}

}
