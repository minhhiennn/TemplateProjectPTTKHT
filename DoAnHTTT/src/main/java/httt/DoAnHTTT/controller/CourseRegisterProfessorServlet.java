package httt.DoAnHTTT.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import httt.DoAnHTTT.database.ProfessorDAO;
import httt.DoAnHTTT.database.Professor_ScheduleDAO;
import httt.DoAnHTTT.database.ScheduleDAO;
import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.model.Professor_Schedule;
import httt.DoAnHTTT.model.User;

/**
 * Servlet implementation class CourseRegisterProfessorServlet
 */
@WebServlet("/CourseRegisterProfessorServlet")
public class CourseRegisterProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseRegisterProfessorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		String ID_Professor = currentUser.getiD_User();
		String action = request.getParameter("action");
		Professor_ScheduleDAO professor_ScheduleDao = new Professor_ScheduleDAO();
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		SemesterDAO semesterDAO = new SemesterDAO();
		ProfessorDAO professorDAO = new ProfessorDAO();
		if (action.equals("Add")) {
			String list_ID_Schedule = request.getParameter("list_ID_Schedule");
			System.out.println(list_ID_Schedule);
			String[] stringSplit = list_ID_Schedule.split("-");
			String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
			if (stringSplit.length == 1) {
				if (professor_ScheduleDao.getCount(ID_Professor, ID_Semester) < 4) {
					if (professor_ScheduleDao.checkDayPr(stringSplit[0], ID_Professor) == true) {
						scheduleDAO.updateProfessorForSchedule(stringSplit[0], ID_Professor);
						professor_ScheduleDao.insert(new Professor_Schedule(semesterDAO.getByKey(ID_Semester),
								scheduleDAO.getByKey(stringSplit[0]), professorDAO.getByKey(ID_Professor)));
						response.sendRedirect("/DoAnHTTT/admin/TKBProfessor");
					} else {
						request.setAttribute("err", "môn học bị trùng thời khóa biểu");
						request.getRequestDispatcher("/admin/TKBProfessor").forward(request, response);
					}
				} else {
					request.setAttribute("err", "không thể đăng ký dạy quá 4 môn");
					request.getRequestDispatcher("/admin/TKBProfessor").forward(request, response);
				}
			} else if(stringSplit.length == 2){
				if (professor_ScheduleDao.getCount(ID_Professor, ID_Semester) < 4) {
					ArrayList<String> listIdSchedule = new ArrayList<String>();
					for (int i = 0; i < stringSplit.length; i++) {
						if (professor_ScheduleDao.checkDayPr(stringSplit[i], ID_Professor)) {
							listIdSchedule.add(stringSplit[i]);
						} else {
							request.setAttribute("err", "môn học bị trùng thời khóa biểu");
							request.getRequestDispatcher("/admin/TKBProfessor").forward(request, response);
							return;
						}
					}
					for (String id_Schedule : listIdSchedule) {
						scheduleDAO.updateProfessorForSchedule(id_Schedule, ID_Professor);
						professor_ScheduleDao.insert(new Professor_Schedule(semesterDAO.getByKey(ID_Semester),
								scheduleDAO.getByKey(id_Schedule), professorDAO.getByKey(ID_Professor)));
					}
					response.sendRedirect("/DoAnHTTT/admin/TKBProfessor");
				} else {
					request.setAttribute("err", "không thể đăng ký dạy quá 4 môn");
					request.getRequestDispatcher("/admin/TKBProfessor").forward(request, response);
				}
			}
		}else {
			String list_ID_Schedule = request.getParameter("list_ID_Schedule");
			System.out.println(list_ID_Schedule);
			String[] stringSplit = list_ID_Schedule.split("-");
			String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
			if (stringSplit.length == 1) {
				scheduleDAO.updateProfessorForScheduleDelete(stringSplit[0]);
				professor_ScheduleDao.delete(new Professor_Schedule(semesterDAO.getByKey(ID_Semester),
						scheduleDAO.getByKey(stringSplit[0]), professorDAO.getByKey(ID_Professor)));
				response.sendRedirect("/DoAnHTTT/admin/TKBProfessor");
			}else {
				for(int i = 0;i<stringSplit.length;i++) {
					scheduleDAO.updateProfessorForScheduleDelete(stringSplit[i]);
					professor_ScheduleDao.delete(new Professor_Schedule(semesterDAO.getByKey(ID_Semester),
							scheduleDAO.getByKey(stringSplit[i]), professorDAO.getByKey(ID_Professor)));
				}
				response.sendRedirect("/DoAnHTTT/admin/TKBProfessor");
			}
		}
	}
}
