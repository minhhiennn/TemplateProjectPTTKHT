package httt.DoAnHTTT.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import httt.DoAnHTTT.database.CourseDAO;
import httt.DoAnHTTT.database.Course_OfferingDAO;
import httt.DoAnHTTT.database.ProfessorDAO;
import httt.DoAnHTTT.database.ScheduleDAO;
import httt.DoAnHTTT.database.StudentDAO;
import httt.DoAnHTTT.database.UserDAO;
import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.User;

/**
 * Servlet implementation class getTableForPDT
 */
@WebServlet("/getTableForPDT")
public class getTableForPDT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getTableForPDT() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("Referer");
		HttpSession httpSession = request.getSession();
		String action = request.getParameter("action");
		if (action.equals("delete")) {
			String tableName = request.getParameter("table");
			switch (tableName) {
			case "schedule":
				ScheduleDAO scheduleDAO = new ScheduleDAO();
				String id_Schedule = request.getParameter("id");
				Schedule schedule = scheduleDAO.getByKey(id_Schedule);
				scheduleDAO.delete(schedule);
				response.sendRedirect(referer);
				break;
			case "course":
				CourseDAO courseDAO = new CourseDAO();
				String id_Course = request.getParameter("id");
				Course course = courseDAO.getByKey(id_Course);
				courseDAO.delete(course);
				response.sendRedirect(referer);
				break;
			case "course_offering":
				Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
				String id_Course_Offering = request.getParameter("id");
				Course_Offering course_Offering = course_OfferingDAO.getByKey(id_Course_Offering);
				course_OfferingDAO.delete(course_Offering);
				response.sendRedirect(referer);
				break;
			case "student":
				UserDAO userDAO = new UserDAO();
				String id_Student = request.getParameter("id");
				User user = new StudentDAO().getByKey(id_Student).getUser();
				userDAO.delete(user);
				response.sendRedirect(referer);
				break;
			case "professor":
				UserDAO userDAO2 = new UserDAO();
				String id_Professor = request.getParameter("id");
				User user2 = new ProfessorDAO().getByKey(id_Professor).getUser();
				userDAO2.delete(user2);
				response.sendRedirect(referer);
				break;
			default:
				ScheduleDAO scheduleDAO3 = new ScheduleDAO();
				String id_Schedule2 = request.getParameter("id");
				Schedule schedule2 = scheduleDAO3.getByKey(id_Schedule2);
				scheduleDAO3.delete(schedule2);
				response.sendRedirect(referer);
				break;
			}
		} else if (action.equals("update")) {
			String table = request.getParameter("table");
			String id = request.getParameter("id");
			String flag = "update";
			if (table == null || table.equals("")) {
				request.setAttribute("table", "schedule");
			} else {
				request.setAttribute("table", table);
			}
			request.setAttribute("id", id);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/pdt/updateAndInsert").forward(request, response);
		} else if (action.equals("insert")) {
			String table = request.getParameter("table");
			String id = request.getParameter("id");
			String flag = "insert";
			if (table == null || table.equals("")) {
				request.setAttribute("table", "schedule");
			} else {
				request.setAttribute("table", table);
			}
			request.setAttribute("id", id);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/pdt/updateAndInsert").forward(request, response);
		} else {
			String table = request.getParameter("table");
			httpSession.setAttribute("table", table);
			response.sendRedirect(referer);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
