package httt.DoAnHTTT.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import httt.DoAnHTTT.database.CourseDAO;
import httt.DoAnHTTT.database.Course_OfferingDAO;
import httt.DoAnHTTT.database.ScheduleDAO;
import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.database.StudentDAO;
import httt.DoAnHTTT.database.Student_ScheduleDAO;
import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Student_Schedule;

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
		String action = req.getParameter("action");
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		SemesterDAO semesterDAO = new SemesterDAO();
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		StudentDAO studentDAO = new StudentDAO();
		if (action.equals("Add")) {
			String ID_Schedule = req.getParameter("ID_Schedule");
			String ID_Student = req.getParameter("ID_Student");
			String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
			if (student_ScheduleDAO.checkDayST(ID_Schedule, ID_Student)) {
				student_ScheduleDAO.insert(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
						scheduleDAO.getByKey(ID_Schedule), studentDAO.getByKey(ID_Student)));
				Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
				Course_Offering course_Offering = course_OfferingDAO
						.getByKey(scheduleDAO.getByKey(ID_Schedule).getCourse_Offering().getiD_Course_Offering());
				course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() + 1);
				boolean bool = course_OfferingDAO.update(course_Offering);
				if (bool == false) {
					req.setAttribute("err", "Môn này đã full chỗ");
					req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
				} else {
					System.out.println("nhu dau buoi");
					resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
				}
			} else {
				req.setAttribute("err", "Đã bị trùng ngày hoặc trùng giờ");
				req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
				System.out.println("nhu cc");
			}
		} else if (action.equals("Delete")) {
			String ID_Schedule = req.getParameter("ID_Schedule");
			String ID_Student = req.getParameter("ID_Student");
			String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
			student_ScheduleDAO.delete(new Student_Schedule(semesterDAO.getByKey(ID_Semester),
					scheduleDAO.getByKey(ID_Schedule), studentDAO.getByKey(ID_Student)));
			Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
			Course_Offering course_Offering = course_OfferingDAO
					.getByKey(scheduleDAO.getByKey(ID_Schedule).getCourse_Offering().getiD_Course_Offering());
			course_Offering.setCurrent_Size(course_Offering.getCurrent_Size() - 1);
			boolean bool = course_OfferingDAO.update(course_Offering);
			if (bool == true) {
				resp.sendRedirect("/DoAnHTTT/student/CourseRegister");
			} else {
				req.setAttribute("err", "Lỗi hệ thống");
				req.getRequestDispatcher("/student/CourseRegister").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
