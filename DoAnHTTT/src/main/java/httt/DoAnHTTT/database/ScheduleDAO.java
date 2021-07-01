package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import httt.DoAnHTTT.model.Course_Offering;
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

	// phương thức xóa đi tất cả schedule ở tất cả các bảng có dính líu
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

	// Get all Schedule
	public HashMap<String,ArrayList<String>> getAllSchedule() {
		HashMap<String,ArrayList<String>> hashMap = new HashMap<String,ArrayList<String>>();
		hashMap.put("ID_Schedule", new ArrayList<String>());
		hashMap.put("ID_Course_Offering", new ArrayList<String>());
		hashMap.put("Id_Profeesor", new ArrayList<String>());
		hashMap.put("Theoretical", new ArrayList<String>());
		hashMap.put("Teaching_Day", new ArrayList<String>());
		hashMap.put("Start_Day", new ArrayList<String>());
		hashMap.put("End_Day", new ArrayList<String>());
		hashMap.put("Study_place", new ArrayList<String>());
		hashMap.put("Start_Slot", new ArrayList<String>());
		hashMap.put("End_Slot", new ArrayList<String>());
		try {
			pstmt = conn.prepareStatement("select * from Schedule");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Schedule = rs.getString("ID_Schedule");
				hashMap.get("ID_Schedule").add(ID_Schedule);
				String ID_Course_Offering = rs.getString("ID_Course_Offering");
				hashMap.get("ID_Course_Offering").add(ID_Course_Offering);
				String Id_Profeesor = rs.getString("Id_Profeesor");
				hashMap.get("Id_Profeesor").add(Id_Profeesor);
				String Theoretical = rs.getString("Theoretical");
				hashMap.get("Theoretical").add(Theoretical);
				int Teaching_Day = rs.getInt("Teaching_Day");
				hashMap.get("Teaching_Day").add(String.valueOf(Teaching_Day));
				Date Start_Day = new Date(rs.getDate("Start_Day").getTime());
				hashMap.get("Start_Day").add(Start_Day.toString());
				Date End_Day = new Date(rs.getDate("End_Day").getTime());
				hashMap.get("End_Day").add(End_Day.toString());
				String Study_place = rs.getString("Study_place");
				hashMap.get("Study_place").add(Study_place);
				int Start_Slot = rs.getInt("Start_Slot");
				hashMap.get("Start_Slot").add(String.valueOf(Start_Slot));
				int End_Slot = rs.getInt("End_Slot");
				hashMap.get("End_Slot").add(String.valueOf(End_Slot));
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
		return hashMap;
	}
	public static void main(String[] args) {	
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		HashMap<String,ArrayList<String>> hashmap = scheduleDAO.getAllSchedule();
		for (Map.Entry m : hashmap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
}