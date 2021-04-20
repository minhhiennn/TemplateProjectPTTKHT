package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Semester;

public class SemesterDAO implements IDAO<Semester> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public SemesterDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Semester getByKey(String key) {
		Semester semester = null;
		try {
			pstmt = conn.prepareStatement("select * from Semester where ID_Semester = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Date startDate = new Date(rs.getDate("startDate").getTime());
				Date endDate = new Date(rs.getDate("endDate").getTime());
				int years = rs.getInt("years");
				int numberS = rs.getInt("numberS");
				semester = new Semester(key, startDate, endDate, years, numberS);

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
		return semester;
	}

	@Override
	public Semester getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Semester key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Semester key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Semester key) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
         SemesterDAO semesterDAO = new SemesterDAO();
	}
}
