package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import httt.DoAnHTTT.model.Class;
import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Professor;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.Semester;
import httt.DoAnHTTT.model.Student;

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
		return ID_Semester;
	}

	// Lấy ID_Semester bằng get top 1;
	public String getID_SemesterByGetTop1(String id_User) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String ID_Semester = null;
		try {
			pstmt = conn.prepareStatement(
					"select TOP 1 st.ID_Semester from Student_ScheduleR st where st.ID_Student = ? group by st.ID_Semester order by st.ID_Semester desc");
			pstmt.setString(1, id_User);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ID_Semester = rs.getString("ID_Semester");
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
		return ID_Semester;
	}

	// Lấy Semester bằng years
	public ArrayList<Semester> getSemesterByTop3(String id_User) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Semester> list = new ArrayList<Semester>();
		try {
			pstmt = conn.prepareStatement(
					"select TOP 3 st.ID_Semester from Student_ScheduleR st where st.ID_Student = ? group by st.ID_Semester order by st.ID_Semester desc");
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

	public Map<String, ArrayList<String>> getTableMap(String tableName) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		switch (tableName) {
		case "schedule":
			ScheduleDAO scheduleDAO = new ScheduleDAO();
			map = scheduleDAO.getAllSchedule();
			break;
		case "course":
			CourseDAO courseDAO = new CourseDAO();
			map = courseDAO.getAllCourse();
			break;
		case "course_offering":
			Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
			map = course_OfferingDAO.getAllCourseOffering();
			break;
		case "student":
			StudentDAO studentDAO = new StudentDAO();
			map = studentDAO.getAllStudent();
			break;
		case "professor":
			ProfessorDAO professorDAO = new ProfessorDAO();
			map = professorDAO.getAllProfessor();
			System.out.println(map.get(map.keySet().toArray()[0]).size());
			break;
		default:
			ScheduleDAO scheduleDAO1 = new ScheduleDAO();
			map = scheduleDAO1.getAllSchedule();
			break;

		}

		return map;
	}

	public Map<String, ArrayList<String>> getMapForPDT(String tableName, String key) {
		Map<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
		Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
		ProfessorDAO professorDAO = new ProfessorDAO();
		CourseDAO courseDAO = new CourseDAO();
		FacultyDAO facultyDAO = new FacultyDAO();
		StudentDAO studentDAO = new StudentDAO();
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		ClassDAO classDAO = new ClassDAO();
		switch (tableName) {
		case "schedule":
			Schedule schedule = scheduleDAO.getByKey(key);
			map.put("ID_Schedule", new ArrayList<String>());
			map.put("ID_Course_Offering", new ArrayList<String>());
			map.put("Id_Profeesor", new ArrayList<String>());
			map.put("Theoretical", new ArrayList<String>());
			map.put("Teaching_Day", new ArrayList<String>());
			map.put("Start_Day", new ArrayList<String>());
			map.put("End_Day", new ArrayList<String>());
			map.put("Study_place", new ArrayList<String>());
			map.put("Start_Slot", new ArrayList<String>());
			map.put("End_Slot", new ArrayList<String>());
			map.get("ID_Schedule").add(schedule.getiD_Schedule());
			map.get("ID_Course_Offering").add(schedule.getCourse_Offering().getiD_Course_Offering());
			for (Course_Offering course_Offering : course_OfferingDAO.getAll()) {
				if (!course_Offering.getiD_Course_Offering()
						.equals(schedule.getCourse_Offering().getiD_Course_Offering())) {
					map.get("ID_Course_Offering").add(course_Offering.getiD_Course_Offering());
				}
			}
			if (schedule.getProfessor() == null) {
				map.get("Id_Profeesor").add(null);
			} else {
				map.get("Id_Profeesor").add(schedule.getProfessor().getUser().getiD_User());
			}
			for (Professor professor : professorDAO.getAll()) {
				if (schedule.getProfessor() != null) {
					if (!professor.getUser().getiD_User().equals(schedule.getProfessor().getUser().getiD_User())) {
						map.get("Id_Profeesor").add(professor.getUser().getiD_User());
					}
				} else if (schedule.getProfessor() == null) {
					if (!professor.getUser().getiD_User().equals(null)) {
						map.get("Id_Profeesor").add(professor.getUser().getiD_User());
					}
				}
			}
			map.get("Theoretical").add(schedule.getTheoretical());
			map.get("Teaching_Day").add(schedule.getTeaching_Day() + "");
			map.get("Start_Day").add(schedule.getStart_Day() + "");
			map.get("End_Day").add(schedule.getEnd_Day() + "");
			map.get("Study_place").add(schedule.getStudy_place());
			map.get("Start_Slot").add(schedule.getStart_Slot() + "");
			map.get("End_Slot").add(schedule.getEnd_Slot() + "");
			break;
		case "course":
			map.put("ID_Course", new ArrayList<String>());
			map.put("ID_Faculty", new ArrayList<String>());
			map.put("Name_Course", new ArrayList<String>());
			map.put("Course_certificate", new ArrayList<String>());
			map.put("years", new ArrayList<String>());
			map.put("numberS", new ArrayList<String>());

			Course course = courseDAO.getByKey(key);
			map.get("ID_Course").add(course.getiD_Course());
			map.get("ID_Faculty").add(course.getFaculty().getiD_Faculty());
			for (Faculty faculty : facultyDAO.getAll()) {
				if (!faculty.getiD_Faculty().equals(course.getFaculty().getiD_Faculty())) {
					map.get("ID_Faculty").add(faculty.getiD_Faculty());
				}
			}
			map.get("Name_Course").add(course.getName_Course());
			map.get("Course_certificate").add(course.getCourse_certificate() + "");
			map.get("years").add(course.getYears() + "");
			map.get("numberS").add(course.getNumberS() + "");
			break;
		case "course_offering":
			map.put("ID_Course_Offering", new ArrayList<String>());
			map.put("ID_Course", new ArrayList<String>());
			map.put("Class_code", new ArrayList<String>());
			map.put("Max_Size", new ArrayList<String>());
			map.put("Current_Size", new ArrayList<String>());

			Course_Offering course_Offering = course_OfferingDAO.getByKey(key);

			map.get("ID_Course_Offering").add(course_Offering.getiD_Course_Offering());
			map.get("ID_Course").add(course_Offering.getCourse().getiD_Course());
			for (Course course1 : courseDAO.getAll()) {
				if (!course1.getiD_Course().equals(course_Offering.getCourse().getiD_Course())) {
					map.get("ID_Course").add(course1.getiD_Course() + "");
				}
			}
			map.get("Class_code").add(course_Offering.getClass1().getClass_Code() + "");
			for (httt.DoAnHTTT.model.Class class1 : classDAO.getAll()) {
				if (!class1.getClass_Code().equals(course_Offering.getClass1().getClass_Code())) {
					map.get("Class_code").add(class1.getClass_Code() + "");
				}
			}
			map.get("Max_Size").add(course_Offering.getMax_Size() + "");
			map.get("Current_Size").add(course_Offering.getCurrent_Size() + "");

			break;
		case "student":

			map.put("ID_Student", new ArrayList<String>());
			map.put("Student_Name", new ArrayList<String>());
			map.put("ID_Faculty", new ArrayList<String>());
			map.put("Create_date", new ArrayList<String>());
			map.put("Class_code", new ArrayList<String>());
			map.put("Cert_number_required", new ArrayList<String>());
			map.put("Cert_number_accumulated", new ArrayList<String>());

			Student student = studentDAO.getByKey(key);

			map.get("ID_Student").add(student.getUser().getiD_User());
			map.get("Student_Name").add(student.getStudent_Name() + "");
			map.get("ID_Faculty").add(student.getFaculty().getiD_Faculty() + "");
			for (Faculty faculty : facultyDAO.getAll()) {
				if (!student.getFaculty().getiD_Faculty().equals(faculty.getiD_Faculty())) {
					map.get("ID_Faculty").add(faculty.getiD_Faculty() + "");
				}
			}
			map.get("Create_date").add(student.getCreate_date() + "");
			map.get("Class_code").add(student.getClass1().getClass_Code());
			for (Class class1 : classDAO.getAll()) {
				if (!student.getClass1().getClass_Code().equals(class1.getClass_Code())) {
					map.get("Class_code").add(class1.getClass_Code());
				}
			}
			map.get("Cert_number_required").add(student.getCert_number_required() + "");
			map.get("Cert_number_accumulated").add(student.getCert_number_accumulated() + "");
			break;
		case "professor":
			map.put("ID_Professor", new ArrayList<>());
			map.put("Professor_Name", new ArrayList<>());
			map.put("ID_Faculty", new ArrayList<>());
			map.put("Create_date", new ArrayList<>());
			map.put("Degree", new ArrayList<>());

			Professor professor = professorDAO.getByKey(key);
			map.get("ID_Professor").add(professor.getUser().getiD_User());
			map.get("Professor_Name").add(professor.getProfessor_Name() + "");
			map.get("ID_Faculty").add(professor.getFaculty().getiD_Faculty() + "");
			for (Faculty faculty : facultyDAO.getAll()) {
				if (!professor.getFaculty().getiD_Faculty().equals(faculty.getiD_Faculty())) {
					map.get("ID_Faculty").add(faculty.getiD_Faculty() + "");
				}
			}
			map.get("Create_date").add(professor.getCreate_date() + "");
			map.get("Degree").add(professor.getDegree());
			break;
		default:
			break;

		}

		return map;
	}

	public static void main(String[] args) throws InterruptedException {
		SemesterDAO semesterDAO = new SemesterDAO();
		HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>) semesterDAO
				.getMapForPDT("schedule", "5");
		for (String string : hashMap.keySet()) {
			System.out.println(string);
		}
	}
}
