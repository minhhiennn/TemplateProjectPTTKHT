package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import httt.DoAnHTTT.model.Professor_Schedule;
import httt.DoAnHTTT.model.Schedule;

public class Professor_ScheduleDAO implements IDAO<Professor_Schedule> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Professor_ScheduleDAO() {
		conn = Connect.getConnection();
	}

	public ArrayList<Schedule> getSubAvaliableForProfessor(String id_Professor) {
		ArrayList<Schedule> arrList = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement("select * from checkSubjectForProfessor(?)");
			pstmt.setString(1, id_Professor);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Schedule = rs.getString("ID_Schedule");
				Schedule schedule = new ScheduleDAO().getByKey(ID_Schedule);
				arrList.add(schedule);
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
		return arrList;
	}

	public ArrayList<Schedule> getTimetableForProfessor(String id_Professor) {
		ArrayList<Schedule> arrList = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement("select * from TimeTablePr(?)");
			pstmt.setString(1, id_Professor);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Schedule = rs.getString("ID_Schedule");
				Schedule schedule = new ScheduleDAO().getByKey(ID_Schedule);
				arrList.add(schedule);
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
		return arrList;
	}

	public boolean checkDayPr(String ID_Schedule, String Id_Professor) {
		boolean bool = true;
		try {
			pstmt = conn.prepareStatement("select * from checkDayPr(?,?)");
			pstmt.setString(1, ID_Schedule);
			pstmt.setString(2, Id_Professor);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bool = false;
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
		return bool;
	}

	// Đếm số môn học professor đã đăng ký trong kỳ
	public int getCount(String id_Professor, String id_Semester) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"select COUNT(*) as dem from Professor_Schedule pr where pr.ID_Professor = ? and pr.ID_Semester = ?");
			pstmt.setString(1, id_Professor);
			pstmt.setString(2, id_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("dem");
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
		return result;
	}

	@Override
	public Professor_Schedule getByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor_Schedule getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Professor_Schedule key) {
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Schedule = key.getSchedule().getiD_Schedule();
		String ID_Professor = key.getProfessor().getUser().getiD_User();
		try {
			pstmt = conn.prepareStatement("insert into Professor_Schedule values(?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Schedule);
			pstmt.setString(3, ID_Professor);
			int row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
		return true;
	}

	@Override
	public boolean update(Professor_Schedule key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Professor_Schedule key) {
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Schedule = key.getSchedule().getiD_Schedule();
		String ID_Professor = key.getProfessor().getUser().getiD_User();
		try {
			pstmt = conn.prepareStatement(
					"delete from Professor_Schedule where ID_Semester = ? and ID_Schedule=? and ID_Professor=?");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Schedule);
			pstmt.setString(3, ID_Professor);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		Professor_ScheduleDAO professor_ScheduleDao = new Professor_ScheduleDAO();
		System.out.println(professor_ScheduleDao.checkDayPr("37", "224"));
	}
}
