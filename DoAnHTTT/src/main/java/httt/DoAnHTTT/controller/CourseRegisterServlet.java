package httt.DoAnHTTT.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import httt.DoAnHTTT.database.CourseDAO;
import httt.DoAnHTTT.database.Course_OfferingDAO;
import httt.DoAnHTTT.database.ScheduleDAO;
import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.database.StudentDAO;
import httt.DoAnHTTT.database.Student_ScheduleDAO;
import httt.DoAnHTTT.model.Course_Offering;
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
		// TODO Auto-generated constructor stub
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
			String list_ID_Schedule = req.getParameter("list_ID_Schedule");
			String[] stringSplit = list_ID_Schedule.split("-");
			String id_Course = req.getParameter("id_Course");
			String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
			if (stringSplit.length == 1) {
				if (student_ScheduleDAO.checkDayST(stringSplit[0], ID_Student)) {
					Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
					String ID_CourseOffering = course_OfferingDAO.getIDCourseOfferingByIdCourse(id_Course);
					Course_Offering course_Offering = course_OfferingDAO.getByKey(ID_CourseOffering);
					course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() + 1);
					boolean bool = course_OfferingDAO.update(course_Offering);
					if (bool == false) {
						req.setAttribute("err", "Môn này đã full chỗ");
						req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
					} else {
						student_ScheduleDAO.insert(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
								scheduleDAO.getByKey(stringSplit[0]), studentDAO.getByKey(ID_Student)));
						resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
					}
				} else {
					req.setAttribute("err", "Đã bị trùng ngày hoặc trùng giờ");
					req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
				}
			} else if (stringSplit.length == 2) {
				Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
				String ID_CourseOffering = course_OfferingDAO.getIDCourseOfferingByIdCourse(id_Course);
				Course_Offering course_Offering = course_OfferingDAO.getByKey(ID_CourseOffering);
				course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() + 1);
				boolean bool = course_OfferingDAO.update(course_Offering);
				if (bool == false) {
					req.setAttribute("err", "Môn này đã full chỗ");
					req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
				} else {
					ArrayList<Student_Schedule> list = new ArrayList<Student_Schedule>();
					for (int i = 0; i < stringSplit.length; i++) {
						if (student_ScheduleDAO.checkDayST(stringSplit[i], ID_Student)) {
							list.add(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
									scheduleDAO.getByKey(stringSplit[i]), studentDAO.getByKey(ID_Student)));
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
			}
		} else if (action.equals("Delete")) {
			String list_ID_Schedule = req.getParameter("list_ID_Schedule");
			String[] stringSplit = list_ID_Schedule.split("-");
			String id_Course = req.getParameter("id_Course");
			String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
			if (stringSplit.length == 1) {
				Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
				String ID_CourseOffering = course_OfferingDAO.getIDCourseOfferingByIdCourse(id_Course);
				Course_Offering course_Offering = course_OfferingDAO.getByKey(ID_CourseOffering);
				course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() - 1);
				boolean bool = course_OfferingDAO.update(course_Offering);
				if (bool == true) {
					student_ScheduleDAO.delete(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
							scheduleDAO.getByKey(stringSplit[0]), studentDAO.getByKey(ID_Student)));
					resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
				} else {
					req.setAttribute("err", "Lỗi hệ thống");
					req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
				}
			}else if(stringSplit.length == 2) {
				Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
				String ID_CourseOffering = course_OfferingDAO.getIDCourseOfferingByIdCourse(id_Course);
				Course_Offering course_Offering = course_OfferingDAO.getByKey(ID_CourseOffering);
				course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() - 1);
				boolean bool = course_OfferingDAO.update(course_Offering);
				if (bool == true) {
					for(int i = 0;i<stringSplit.length;i++) {
						student_ScheduleDAO.delete(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
								scheduleDAO.getByKey(stringSplit[i]), studentDAO.getByKey(ID_Student)));
					}
					resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
				} else {
					req.setAttribute("err", "Lỗi hệ thống");
					req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
