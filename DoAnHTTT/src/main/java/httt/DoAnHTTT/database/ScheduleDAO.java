package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Professor;
import httt.DoAnHTTT.model.Schedule;

public class ScheduleDAO implements IDAO<Schedule> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ScheduleDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Schedule getByKey(String key) {
		Schedule schedule = null;
		try {
			pstmt = conn.prepareStatement("select * from Schedule where ID_Schedule = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Course_Offering = rs.getString("ID_Course_Offering");
				Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
				Course_Offering course_Offering = course_OfferingDAO.getByKey(ID_Course_Offering);
				String Id_Profeesor = rs.getString("Id_Profeesor");
				ProfessorDAO professorDAO = new ProfessorDAO();
				Professor professor = professorDAO.getByKey(Id_Profeesor);
				String Theoretical = rs.getString("Theoretical");
				int Teaching_Day = rs.getInt("Teaching_Day");
				Date Start_Day = new Date(rs.getDate("Start_Day").getTime());
				Date End_Day = new Date(rs.getDate("End_Day").getTime());
				String Study_place = rs.getString("Study_place");
				int Start_Slot = rs.getInt("Start_Slot");
				int End_Slot = rs.getInt("End_Slot");
				schedule = new Schedule(key, course_Offering, professor, Theoretical, Teaching_Day, Start_Day, End_Day,
						Study_place, Start_Slot, End_Slot);

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
		return schedule;
	}

	public void updateProfessorForSchedule(String id_Schedule, String id_Professor) {
		try {
			pstmt = conn.prepareStatement("update Schedule set Id_Profeesor = ? where ID_Schedule = ?");
			pstmt.setString(1, id_Professor);
			pstmt.setString(2, id_Schedule);
			int row = pstmt.executeUpdate();
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
	}
    // Update xóa professor ra khỏi schedule
	public void updateProfessorForScheduleDelete(String id_Schedule) {
		try {
			pstmt = conn.prepareStatement("update Schedule set Id_Profeesor = null where ID_Schedule = ?");
			pstmt.setString(1, id_Schedule);
			int row = pstmt.executeUpdate();
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
	}
	@Override
	public Schedule getByKeyS(List<String> key) {
		return null;
	}

	@Override
	public boolean insert(Schedule key) {
		return false;
	}

	// update này bùn
	@Override
	public boolean update(Schedule key) {
		return false;
	}

	@Override
	public boolean delete(Schedule key) {
		return false;
	}

}