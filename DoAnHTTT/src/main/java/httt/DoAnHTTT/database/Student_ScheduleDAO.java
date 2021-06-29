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
import httt.DoAnHTTT.model.StudentMapDTO;
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
	public ArrayList<Schedule> getTimeTableBySemesterAndUser(String id_semester, String id_user) {
		ArrayList<Schedule> arrList = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement(
					"select st.ID_Schedule from Student_ScheduleR st where st.ID_Semester=? and st.ID_Student=?");
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

	// Láº¥y ra danh sÃ¡ch student cá»§a 1 mÃ´n há»�c
	public ArrayList<StudentMapDTO> getListStudentBySubject(String ID_Course, String id_Semester) {
		ArrayList<StudentMapDTO> list = new ArrayList<StudentMapDTO>();
		try {
			pstmt = conn.prepareStatement(
					"select DISTINCT st.ID_Student,s.Student_Name from Student_ScheduleR st join Schedule sc on st.ID_Schedule = sc.ID_Schedule\r\n"
							+ "                                                             join Course_Offering co on sc.ID_Course_Offering = co.ID_Course_Offering\r\n"
							+ "                                                             join Course c on co.ID_Course = c.ID_Course\r\n"
							+ "                                                             join Student s on st.ID_Student = s.ID_Student\r\n"
							+ "where c.ID_Course = ? and st.ID_Semester = ?");
			pstmt.setString(1, ID_Course);
			pstmt.setString(2, id_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Student = rs.getString("ID_Student");
				String Student_Name = rs.getString("Student_Name");
				StudentMapDTO studentMapDTO = new StudentMapDTO(ID_Student, Student_Name);
				list.add(studentMapDTO);
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

	// Tìm xem nó đã được lưu cái bảng real chưa
	public boolean checkExitsInRealTimeTable(String id_Semester, String id_Student, String id_Schedule) {
		boolean result = false;
		try {
			pstmt = conn.prepareStatement("select strr.* from Student_ScheduleR strr\r\n"
					+ "where strr.ID_Semester = ? and strr.ID_Student = ? and strr.ID_Schedule = ?");
			pstmt.setString(1, id_Semester);
			pstmt.setString(2, id_Student);
			pstmt.setString(3, id_Schedule);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = true;
				break;
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

	// Đếm xem kỳ này đã đăng ký đủ 4 tín ở bảng ko real ko để đưa vô bảng real
	public int countSubjectInTimeTableFake(String id_Semester, String id_Student) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"select Count(DISTINCT c.ID_Course) as dem from Student_Schedule st join Schedule sc on st.ID_Schedule = sc.ID_Schedule\r\n"
							+ "                                               join Course_Offering co on sc.ID_Course_Offering = co.ID_Course_Offering\r\n"
							+ "                                               join Course c on co.ID_Course = c.ID_Course\r\n"
							+ "where st.ID_Semester = ? and st.ID_Student = ?");
			pstmt.setString(1, id_Semester);
			pstmt.setString(2, id_Student);
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
	public int countSubjectInTimeTableReal(String id_Semester, String id_Student) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"select Count(DISTINCT c.ID_Course) as dem from Student_ScheduleR st join Schedule sc on st.ID_Schedule = sc.ID_Schedule\r\n"
							+ "                                               join Course_Offering co on sc.ID_Course_Offering = co.ID_Course_Offering\r\n"
							+ "                                               join Course c on co.ID_Course = c.ID_Course\r\n"
							+ "where st.ID_Semester = ? and st.ID_Student = ?");
			pstmt.setString(1, id_Semester);
			pstmt.setString(2, id_Student);
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

	// lưu hết dữ liệu vô bảng real
	public void addToReal(Student_Schedule key) {
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Schedule = key.getSchedule().getiD_Schedule();
		String ID_Student = key.getStudent().getUser().getiD_User();
		try {
			pstmt = conn.prepareStatement("insert into Student_ScheduleR values(?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Schedule);
			pstmt.setString(3, ID_Student);
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

	// xóa ở bảng real
	public boolean deleteInRealTable(Student_Schedule key) {
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Schedule = key.getSchedule().getiD_Schedule();
		String ID_Student = key.getStudent().getUser().getiD_User();
		try {
			pstmt = conn.prepareStatement(
					"delete from Student_ScheduleR where ID_Semester=? and ID_Schedule=? and ID_Student=?");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Schedule);
			pstmt.setString(3, ID_Student);
			pstmt.executeUpdate();
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
		return false;
	}

	// lấy id_Schedule trong bảng Student_Schedule bởi id_Semester và id_Student
	public ArrayList<String> getId_Schedule(String id_Semester, String id_Student) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement("select st.ID_Schedule from Student_Schedule st\r\n"
					+ "where st.ID_Semester = ? and st.ID_Student = ?");
			pstmt.setString(1, id_Semester);
			pstmt.setString(2, id_Student);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id_Schedule = rs.getString("ID_Schedule");
				list.add(id_Schedule);
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
		return false;
	}

	public static void main(String[] args) {
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		System.out.println(student_ScheduleDAO.countSubjectInTimeTableFake("2020_2", "18130006"));
	}
}
