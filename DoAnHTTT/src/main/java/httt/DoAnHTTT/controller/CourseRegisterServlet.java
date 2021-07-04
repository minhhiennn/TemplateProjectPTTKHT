package httt.DoAnHTTT.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import httt.DoAnHTTT.database.Course_OfferingDAO;
import httt.DoAnHTTT.database.ScheduleDAO;
import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.database.StudentDAO;
import httt.DoAnHTTT.database.Student_ScheduleDAO;
import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.Student_Schedule;
import httt.DoAnHTTT.model.User;

@WebServlet(urlPatterns = { "/CourseRegisterServlet" })
public class CourseRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor
	public CourseRegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		String ID_Student = currentUser.getiD_User();
		String action = req.getParameter("action");
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		SemesterDAO semesterDAO = new SemesterDAO();
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		StudentDAO studentDAO = new StudentDAO();
		if (action.equals("Add")) {
			String id_CourseOffering = req.getParameter("ID_CourseOffering");
			ArrayList<String> listIDSchedule = scheduleDAO.getListIDSchedule(id_CourseOffering);
			String ID_Semester = semesterDAO.getID_SemesterByGetDate();
			if (listIDSchedule.size() == 1) {
				if (student_ScheduleDAO.checkDayST(listIDSchedule.get(0), ID_Student)) {
					student_ScheduleDAO.insert(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
							scheduleDAO.getByKey(listIDSchedule.get(0)), studentDAO.getByKey(ID_Student)));
					resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
				} else {
					req.setAttribute("err", "Đã bị trùng ngày hoặc trùng giờ");
					req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
				}
			} else if (listIDSchedule.size() == 2) {
				ArrayList<Student_Schedule> list = new ArrayList<Student_Schedule>();
				for (int i = 0; i < listIDSchedule.size(); i++) {
					if (student_ScheduleDAO.checkDayST(listIDSchedule.get(i), ID_Student)) {
						System.out.println(listIDSchedule.get(i));
						list.add(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
								scheduleDAO.getByKey(listIDSchedule.get(i)), studentDAO.getByKey(ID_Student)));
					} else {
						req.setAttribute("err", "Đã bị trùng ngày hoặc trùng giờ");
						req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
						return;
					}
				}
				for (Student_Schedule student_Schedule : list) {
					student_ScheduleDAO.insert(student_Schedule);
				}
				resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
			}
		} else if (action.equals("Delete")) {
			String id_CourseOffering = req.getParameter("ID_CourseOffering");
			ArrayList<String> listIDSchedule = scheduleDAO.getListIDSchedule(id_CourseOffering);
			String ID_Semester = semesterDAO.getID_SemesterByGetDate();
			if (listIDSchedule.size() == 1) {
				student_ScheduleDAO.delete(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
						scheduleDAO.getByKey(listIDSchedule.get(0)), studentDAO.getByKey(ID_Student)));
				if (student_ScheduleDAO.checkExitsInRealTimeTable(ID_Semester, ID_Student, listIDSchedule.get(0))) {
					Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
					Course_Offering course_Offering = course_OfferingDAO.getByKey(id_CourseOffering);
					course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() - 1);
					course_OfferingDAO.update(course_Offering);
					student_ScheduleDAO.deleteInRealTable(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
							scheduleDAO.getByKey(listIDSchedule.get(0)), studentDAO.getByKey(ID_Student)));

					resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
				} else {
					resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
				}
			} else if (listIDSchedule.size() == 2) {
				for (int i = 0; i < listIDSchedule.size(); i++) {
					student_ScheduleDAO.delete(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
							scheduleDAO.getByKey(listIDSchedule.get(i)), studentDAO.getByKey(ID_Student)));
				}
				if (student_ScheduleDAO.checkExitsInRealTimeTable(ID_Semester, ID_Student, listIDSchedule.get(0))) {
					Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
					Course_Offering course_Offering = course_OfferingDAO.getByKey(id_CourseOffering);
					course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() - 1);
					course_OfferingDAO.update(course_Offering);
					for (int i = 0; i < listIDSchedule.size(); i++) {
						student_ScheduleDAO.deleteInRealTable(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
								scheduleDAO.getByKey(listIDSchedule.get(i)), studentDAO.getByKey(ID_Student)));
					}
					resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
				} else {
					resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
				}
			}
		} else if (action.equals("AddToReal")) {
			String ID_Semester = semesterDAO.getID_SemesterByGetDate();
			ArrayList<String> id_Schedule = student_ScheduleDAO.getId_Schedule(ID_Semester, ID_Student);
			int count = student_ScheduleDAO.countSubjectInTimeTableFake(ID_Semester, ID_Student);
			Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
			if (count >= 4) {
				for (String string : id_Schedule) {
					if (student_ScheduleDAO.checkExitsInRealTimeTable(ID_Semester, ID_Student, string) == false) {
						ArrayList<String> list = new ArrayList<>();
						list.add(ID_Semester);
						list.add(string);
						list.add(ID_Student);
						Student_Schedule student_Schedule = student_ScheduleDAO.getByKeyS(list);
						Schedule schedule = scheduleDAO.getByKey(string);
						Course_Offering course_Offering = course_OfferingDAO
								.getByKey(schedule.getCourse_Offering().getiD_Course_Offering());
						course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() + 1);
						boolean bool = true;
						if (schedule.getTheoretical().equals("LT")) {
							bool = course_OfferingDAO.update(course_Offering);
						}
						if (bool == false) {
							// chỗ này sẽ cho tất cả những môn full chỗ vào cái list rồi xử lý sao đó tui ko
							// bik
						} else {
							student_ScheduleDAO.addToReal(student_Schedule);

						}
					}
				}
				resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
			} else {
				req.setAttribute("err", "Đăng ký bắt buộc phải có ít nhất 4 môn");
				req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
