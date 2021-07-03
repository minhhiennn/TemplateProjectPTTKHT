package httt.DoAnHTTT.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import httt.DoAnHTTT.database.BillingSystemDAO;
import httt.DoAnHTTT.database.Course_OfferingDAO;
import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.database.Student_ScheduleDAO;
import httt.DoAnHTTT.database.TimeForCourseRegisterDao;
import httt.DoAnHTTT.model.BillingSystem;
import httt.DoAnHTTT.model.Course_Offering;

/**
 * Servlet implementation class closeRegistration
 */
@WebServlet("/CloseRegistration")
public class CloseRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
		ArrayList<Course_Offering> list = (ArrayList<Course_Offering>) course_OfferingDAO.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/pdt/closeRegistration").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		TimeForCourseRegisterDao timeForCourseRegisterDao = new TimeForCourseRegisterDao();
		ArrayList<String> listIDCourseOffering = course_OfferingDAO.getListIDCourseOfferingToDelete();
		for (String string : listIDCourseOffering) {
			course_OfferingDAO.delete2(string);
		}
		student_ScheduleDAO.deleteAllSchedule();
		timeForCourseRegisterDao.closeRegistration();
		ArrayList<String> listIDStudent = student_ScheduleDAO.getDSHocSinhDKTheoKy();
		BillingSystemDAO billingSystemDAO = new BillingSystemDAO();
		String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
		for (String ID_Student : listIDStudent) {
			int creadit = billingSystemDAO.sumCreadit(ID_Student);
			double payment = billingSystemDAO.getPaymoney(ID_Student);
			billingSystemDAO.insert(new BillingSystem(ID_Semester, ID_Student, payment, creadit));
		}
	}

}
