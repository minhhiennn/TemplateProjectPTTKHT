package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Semester;

public class SemesterDAO implements IDAO<Semester> {
	private Connection conn = null;

	public SemesterDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Semester getByKey(String key) {
		Semester semester = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
		}finally {
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

	// Lấy ID_Semester bằng GETDATE();
	public String getID_SemesterByGetDate() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String ID_Semester = null;
		try {
			pstmt = conn
					.prepareStatement("select ID_Semester from Semester where GETDATE() between startDate and endDate");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ID_Semester = rs.getString("ID_Semester");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		return ID_Semester;
	}
    // Lấy ID_Semester bằng get top 1;
	public String getID_SemesterByGetTop1(String id_User) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String ID_Semester = null;
		try {
			pstmt = conn
					.prepareStatement("select TOP 1 st.ID_Semester from Student_ScheduleR st where st.ID_Student = ? group by st.ID_Semester order by st.ID_Semester desc");
			pstmt.setString(1, id_User);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ID_Semester = rs.getString("ID_Semester");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		return ID_Semester;
	}
	// Lấy Semester bằng years
	public ArrayList<Semester> getSemesterByTop3(String id_User){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Semester> list = new ArrayList<Semester>();
		try {
			pstmt = conn.prepareStatement("select TOP 3 st.ID_Semester from Student_ScheduleR st where st.ID_Student = ? group by st.ID_Semester order by st.ID_Semester desc");
			pstmt.setString(1, id_User);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Semester = rs.getString("ID_Semester");
				Semester semester = getByKey(ID_Semester);
				list.add(semester);
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
		return list;
	}

	public static void main(String[] args) throws InterruptedException {
		SemesterDAO semesterDAO = new SemesterDAO();
	}
}
