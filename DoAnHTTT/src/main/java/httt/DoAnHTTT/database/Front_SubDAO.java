package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Front_Sub;

public class Front_SubDAO implements IDAO<Front_Sub>{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Front_SubDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Front_Sub getByKey(String key) {
		Front_Sub front_Sub = null;
		try {
			pstmt = conn.prepareStatement("select * from Front_Sub where ID_Course = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_CourseB = rs.getString("ID_CourseB");
				CourseDAO courseDAO = new CourseDAO();
				Course course = courseDAO.getByKey(key);
				Course courseB = courseDAO.getByKey(ID_CourseB);
				front_Sub = new Front_Sub(course, courseB);

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
		return front_Sub;
	}

	@Override
	public Front_Sub getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Front_Sub key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Front_Sub key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Front_Sub key) {
		// TODO Auto-generated method stub
		return false;
	}
}
