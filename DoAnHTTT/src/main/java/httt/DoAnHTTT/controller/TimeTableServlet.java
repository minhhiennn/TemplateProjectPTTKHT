package httt.DoAnHTTT.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.database.Student_ScheduleDAO;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.User;

/**
 * Servlet implementation class TimeTableServlet
 */
@WebServlet("/TimeTableServlet")
public class TimeTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimeTableServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser != null) {
			Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
			SemesterDAO semesterDAO = new SemesterDAO();
			request.setAttribute("idSemester", semesterDAO.getID_SemesterByGetTop1(currentUser.getiD_User()));
			//
			ArrayList<Schedule> listTimeTable = student_ScheduleDAO.getTimeTableBySemesterAndUser(semesterDAO.getID_SemesterByGetTop1(currentUser.getiD_User()),currentUser.getiD_User());
			request.setAttribute("listTimeTable", listTimeTable);
			//
			request.getRequestDispatcher("/student/TKBStudent").forward(request, response);
		}else {
			response.sendRedirect("/DoAnHTTT/student/TKBStudent");	
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_Semester = request.getParameter("select");
		System.out.println(id_Semester);
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		ArrayList<Schedule> listTimeTable = student_ScheduleDAO.getTimeTableBySemesterAndUser(id_Semester,currentUser.getiD_User());
		request.setAttribute("listTimeTable", listTimeTable);
		//
		request.setAttribute("idSemester", id_Semester);
		//
		request.getRequestDispatcher("/student/TKBStudent").forward(request, response);
	}

}
