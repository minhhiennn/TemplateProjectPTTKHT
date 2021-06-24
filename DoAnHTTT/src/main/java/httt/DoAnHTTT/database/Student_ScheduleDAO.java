package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.Semester;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.Student_Schedule;
import httt.DoAnHTTT.model.TimeTableItem;

public class Student_ScheduleDAO implements IDAO<Student_Schedule> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Student_ScheduleDAO() {
		conn = Connect.getConnection();
	}

	public ArrayList<Schedule> getTimeTableItem(String user_id) {
		ArrayList<Schedule> arrList = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement("select * from TimeTableSt(?)");
			pstmt.setString(1, user_id);
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
    // Get TimeTable By ID_Semester And ID_User
	public ArrayList<Schedule> getTimeTableBySemesterAndUser(String id_semester,String id_user) {
		ArrayList<Schedule> arrList = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement("select st.ID_Schedule from Student_Schedule st where st.ID_Semester=? and st.ID_Student=?");
			pstmt.setString(1, id_semester);
			pstmt.setString(2, id_user);
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
	// Test function SubAvailableST(OK het nhe)
	public ArrayList<Schedule> getSubAvailableST(String user_id) {
		ArrayList<Schedule> arrList = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement("select * from SubAvailableST(?)");
			pstmt.setString(1, user_id);
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

	public boolean checkDayST(String ID_Schedule, String ID_User) {
		boolean bool = true;
		try {
			pstmt = conn.prepareStatement("select * from checkDayST(?,?)");
			pstmt.setString(1, ID_Schedule);
			pstmt.setString(2, ID_User);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bool = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	public boolean checkSubExistInTimeTable(String ID_Student, String ID_Schedule) {
		boolean bool = false;
		try {
			pstmt = conn.prepareStatement(
					"select sa.ID_Schedule from SubAvailableST(?) sa join TimeTableSt(?) tt on sa.ID_Schedule = tt.ID_Schedule where sa.ID_Schedule = ?; ");
			pstmt.setString(1, ID_Student);
			pstmt.setString(2, ID_Student);
			pstmt.setString(3, ID_Schedule);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public Student_Schedule getByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student_Schedule getByKeyS(List<String> key) {
		Student_Schedule student_Schedule = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from Student_Schedule where ID_Semester = ? and ID_Schedule = ? and ID_Student = ?");
			pstmt.setString(1, key.get(0));
			pstmt.setString(2, key.get(1));
			pstmt.setString(3, key.get(2));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SemesterDAO semesterDAO = new SemesterDAO();
				Semester semester = semesterDAO.getByKey(key.get(0));
				ScheduleDAO scheduleDAO = new ScheduleDAO();
				Schedule schedule = scheduleDAO.getByKey(key.get(1));
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.getByKey(key.get(2));
				student_Schedule = new Student_Schedule(semester, schedule, student);

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
		return student_Schedule;
	}

	@Override
	public boolean insert(Student_Schedule key) {
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Schedule = key.getSchedule().getiD_Schedule();
		String ID_Student = key.getStudent().getUser().getiD_User();
		try {
			pstmt = conn.prepareStatement("insert into Student_Schedule values(?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Schedule);
			pstmt.setString(3, ID_Student);
			int row = pstmt.executeUpdate();
			System.out.println(row);
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
	public boolean update(Student_Schedule key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Student_Schedule key) {
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Schedule = key.getSchedule().getiD_Schedule();
		String ID_Student = key.getStudent().getUser().getiD_User();
		try {
			pstmt = conn.prepareStatement(
					"delete from Student_Schedule where ID_Semester=? and ID_Schedule=? and ID_Student=?");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Schedule);
			pstmt.setString(3, ID_Student);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		ArrayList<Schedule> list = student_ScheduleDAO.getTimeTableBySemesterAndUser("2_2020", "18130006");
		for (Schedule schedule : list) {
			System.out.println(schedule);
		}
	}
}
