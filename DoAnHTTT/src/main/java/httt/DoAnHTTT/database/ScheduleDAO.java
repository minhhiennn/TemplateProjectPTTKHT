package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public Schedule getByKey(List<String> key) {
		Schedule schedule = null;
		try {
			pstmt = conn.prepareStatement("select * from Schedule where ID_Schedule = ?");
			pstmt.setString(1, key.get(0));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Schedule = rs.getString("ID_Schedule");
				String ID_Course_Offering = rs.getString("ID_Course_Offering");
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add(ID_Course_Offering);
				Course_Offering course_Offering = new Course_OfferingDAO().getByKey(list1);
				String Id_Profeesor = rs.getString("Id_Profeesor");
				ArrayList<String> list2 = new ArrayList<String>();
				list2.add(Id_Profeesor);
				Professor professor = new ProfessorDAO().getByKey(list2);
				schedule = new Schedule(ID_Schedule, course_Offering, professor);
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
}
