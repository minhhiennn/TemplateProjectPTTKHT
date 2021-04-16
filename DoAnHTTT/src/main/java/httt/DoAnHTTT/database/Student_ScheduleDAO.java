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


	public ArrayList<TimeTableItem> getTimeTableItem(String user_id) {
		ArrayList<TimeTableItem> arrList = new ArrayList<TimeTableItem>();
		try {
			pstmt = conn.prepareStatement("select * from TimeTableSt(?)");
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Schedule = rs.getString("ID_Schedule");
				Schedule schedule = new ScheduleDAO().getByKey(ID_Schedule);
				String ID_Professor = rs.getString("Id_Profeesor");
				TimeTableItem timeTableItem = new TimeTableItem(schedule, ID_Professor);
				arrList.add(timeTableItem);
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

	public static void main(String[] args) {
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		ArrayList<Schedule> arrList = student_ScheduleDAO.getSubAvailableST("18130005");
		for (Schedule schedule : arrList) {
			System.out.println(schedule);
		}
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
			pstmt = conn.prepareStatement("select * from Student_Schedule where ID_Semester = ? and ID_Schedule = ? and ID_Student = ?");
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
				student_Schedule = new Student_Schedule(semester, schedule,student);

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
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Student_Schedule key) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Student_Schedule key) {
		// TODO Auto-generated method stub
		return false;
	}
}
