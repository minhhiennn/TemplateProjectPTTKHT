package httt.DoAnHTTT.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import httt.DoAnHTTT.database.ClassDAO;
import httt.DoAnHTTT.database.CourseDAO;
import httt.DoAnHTTT.database.Course_OfferingDAO;
import httt.DoAnHTTT.database.FacultyDAO;
import httt.DoAnHTTT.database.ProfessorDAO;
import httt.DoAnHTTT.database.ScheduleDAO;
import httt.DoAnHTTT.database.StudentDAO;
import httt.DoAnHTTT.database.UserDAO;
import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Professor;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.Student;
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
		String table = request.getParameter("table");
		String typeSubmit = request.getParameter("submit");
		switch (table) {
		case "schedule":
			try {
				String ID_Schedule = request.getParameter("ID_Schedule");
				String ID_Course_Offering = request.getParameter("ID_Course_Offering");
				String Id_Profeesor = request.getParameter("Id_Profeesor");
				String Theoretical = request.getParameter("Theoretical");
				int Teaching_Day = Integer.parseInt(request.getParameter("Teaching_Day"));
				String Start_Day = request.getParameter("Start_Day");
				String End_Day = request.getParameter("End_Day");
				String Study_place = request.getParameter("Study_place");
				int Start_Slot = Integer.parseInt(request.getParameter("Start_Slot"));
				int End_Slot = Integer.parseInt(request.getParameter("End_Slot"));
				ScheduleDAO scheduleDAO = new ScheduleDAO();
				ProfessorDAO professorDAO = new ProfessorDAO();
				Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Schedule schedule = new Schedule(ID_Schedule, course_OfferingDAO.getByKey(ID_Course_Offering),
						professorDAO.getByKey(Id_Profeesor), Theoretical, Teaching_Day, formatter.parse(Start_Day),
						formatter.parse(End_Day), Study_place, Start_Slot, End_Slot);
				if (typeSubmit.equals("insert")) {
					// insert nay chua co
					System.out.println(schedule);
					boolean bool = scheduleDAO.insert(schedule);
					System.out.println(bool);
					// insert nay la boolean neu ra false thi set err la trung khoa chinh
				} else {
					scheduleDAO.update(schedule);
				}
			} catch (Exception e) {
				System.out.println("Loi sai kieu du lieu");
			}

			break;
		case "course":
			try {
				String ID_Course = request.getParameter("ID_Course");
				String ID_Faculty = request.getParameter("ID_Faculty");
				String Name_Course = request.getParameter("Name_Course");
				int Course_certificate = Integer.parseInt(request.getParameter("Course_certificate"));
				int years = Integer.parseInt(request.getParameter("years"));
				int numberS = Integer.parseInt(request.getParameter("numberS"));
				CourseDAO courseDAO = new CourseDAO();
				FacultyDAO facultyDAO = new FacultyDAO();
				Course course = new Course(ID_Course, Name_Course, facultyDAO.getByKey(ID_Faculty), Course_certificate,
						years, numberS);
				if (typeSubmit.equals("insert")) {
					courseDAO.insert(course);
				} else {
					courseDAO.update(course);
				}
			} catch (Exception e) {
				System.out.println("Loi sai kieu du lieu");
			}

			break;
		case "course_offering":
			try {
				String ID_Course_Offering1 = request.getParameter("ID_Course_Offering");
				String ID_Course1 = request.getParameter("ID_Course");
				String Class_code = request.getParameter("Class_code");
				int Max_Size = Integer.parseInt(request.getParameter("Max_Size"));
				int Current_Size = Integer.parseInt(request.getParameter("Current_Size"));
				Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
				CourseDAO courseDAO = new CourseDAO();
				ClassDAO classDAO = new ClassDAO();
				Course_Offering course_Offering = new Course_Offering(ID_Course_Offering1,
						courseDAO.getByKey(ID_Course1), classDAO.getByKey(Class_code), Max_Size, Current_Size);
				if (typeSubmit.equals("insert")) {
					course_OfferingDAO.insert(course_Offering);
				} else {
					course_OfferingDAO.update(course_Offering);
				}
			} catch (Exception e) {
				System.out.println("Loi sai kieu du lieu");
			}

			break;
		case "student":
			try {
				String ID_Student = request.getParameter("ID_Student");
				String Student_Name = request.getParameter("Student_Name");
				String ID_Faculty1 = request.getParameter("ID_Faculty");
				String Class_code1 = request.getParameter("Class_code");
				String Create_date = request.getParameter("Create_date");
				int Cert_number_required = Integer.parseInt(request.getParameter("Cert_number_required"));
				int Cert_number_accumulated = Integer.parseInt(request.getParameter("Cert_number_accumulated"));
				StudentDAO studentDAO = new StudentDAO();
				UserDAO userDAO = new UserDAO();
				FacultyDAO facultyDAO = new FacultyDAO();
				ClassDAO classDAO = new ClassDAO();
				Student student = new Student(userDAO.getByKey(ID_Student), Student_Name,
						facultyDAO.getByKey(ID_Faculty1), new SimpleDateFormat("yyyy-MM-dd").parse(Create_date), classDAO.getByKey(Class_code1),
						Cert_number_required, Cert_number_accumulated);
				if (typeSubmit.equals("insert")) {
					studentDAO.insert(student);
				} else {
					studentDAO.update(student);
				}
			} catch (Exception e) {
				System.out.println("Loi sai kieu du lieu");
			}

			break;
		case "professor":
			try {
				String ID_Professor = request.getParameter("ID_Professor");
				String Professor_Name = request.getParameter("Professor_Name");
				String ID_Faculty2 = request.getParameter("ID_Faculty");
				String Degree = request.getParameter("Degree");
				String Create_date1 = request.getParameter("Create_date");
				ProfessorDAO professorDAO = new ProfessorDAO();
				UserDAO userDAO = new UserDAO();
				FacultyDAO facultyDAO = new FacultyDAO();
				Professor professor = new Professor(userDAO.getByKey(ID_Professor), Professor_Name,
						facultyDAO.getByKey(ID_Faculty2), new SimpleDateFormat("yyyy-MM-dd").parse(Create_date1), Degree);
				if (typeSubmit.equals("insert")) {
					professorDAO.insert(professor);
				} else {
					professorDAO.update(professor);
				}
			} catch (Exception e) {
				System.out.println("Loi sai kieu du lieu");
			}
			break;
		default:
			break;

		}
		response.sendRedirect("/DoAnHTTT/pdt/table");
	}

}
