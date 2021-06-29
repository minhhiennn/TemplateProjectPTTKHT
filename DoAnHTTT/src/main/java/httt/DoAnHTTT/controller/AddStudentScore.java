package httt.DoAnHTTT.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import httt.DoAnHTTT.database.CourseDAO;
import httt.DoAnHTTT.database.SemesterDAO;
import httt.DoAnHTTT.database.Semester_ResultDAO;
import httt.DoAnHTTT.database.StudentDAO;
import httt.DoAnHTTT.database.Student_ScheduleDAO;
import httt.DoAnHTTT.database.Sub_PassDAO;
import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Semester;
import httt.DoAnHTTT.model.Semester_Result;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.StudentMapDTO;
import httt.DoAnHTTT.model.Sub_Pass;

/**
 * Servlet implementation class AddStudentScore
 */
@WebServlet("/AddStudentScore")
public class AddStudentScore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentScore() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_Course = request.getParameter("id_Course");
		String id_Semester = new SemesterDAO().getID_SemesterByGetDate();
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		ArrayList<StudentMapDTO> list = student_ScheduleDAO.getListStudentBySubject(id_Course, id_Semester);
		request.setAttribute("id_Semester", id_Semester);
		request.setAttribute("id_Course", id_Course);
		request.setAttribute("listStudent", list);
		request.getRequestDispatcher("/admin/DSHocSinh").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_Course = request.getParameter("id_Course");
		String id_Semester = new SemesterDAO().getID_SemesterByGetDate();
		Student_ScheduleDAO student_ScheduleDAO = new Student_ScheduleDAO();
		Sub_PassDAO sub_PassDAO = new Sub_PassDAO();
		Semester_ResultDAO resultDAO=new Semester_ResultDAO();
		ArrayList<StudentMapDTO> list = student_ScheduleDAO.getListStudentBySubject(id_Course, id_Semester);
		for (StudentMapDTO studentMapDTO : list) {
			String scoreS = request.getParameter(studentMapDTO.getId_Student());
			if (!scoreS.equals("")) {
				String id_Student = studentMapDTO.getId_Student();
				double score = Double.parseDouble(scoreS);
				double scoreHe4 = (score * 40) / 100;
				String Rate = "";
				if (scoreHe4 >= 3.6) {
					Rate = "A";
				} else if (scoreHe4 >= 2.4 && scoreHe4 < 3.6) {
					Rate = "B";
				} else if (scoreHe4 >= 1.6 && scoreHe4 < 2.4) {
					Rate = "C";
				} else if (scoreHe4 >= 1.0 && scoreHe4 < 1.6) {
					Rate = "D";
				} else {
					Rate = "F";
				}
				boolean exits = sub_PassDAO.checkExist(id_Student, id_Course, id_Semester);
				boolean exitsemeterDao=resultDAO.checkExistResult(id_Student, id_Semester);
				if(exits == false ) {
					Semester semester = new SemesterDAO().getByKey(id_Semester);
					Course course = new CourseDAO().getByKey(id_Course);
					Student student = new StudentDAO().getByKey(id_Student);
					sub_PassDAO.insert(new Sub_Pass(semester, course, student, score, scoreHe4, Rate));
					if(exitsemeterDao==false) {
					Semester_Result semester_Result=new Semester_Result(semester, student, resultDAO.getDiemTB(id_Student, id_Semester), resultDAO.getDiemTBHe4(id_Student, id_Semester), resultDAO.getSoTinChiDaDat(id_Student, id_Semester));
					resultDAO.insert(semester_Result);
					}else {
						Semester_Result semester_Result=new Semester_Result(semester, student, resultDAO.getDiemTB(id_Student, id_Semester), resultDAO.getDiemTBHe4(id_Student, id_Semester), resultDAO.getSoTinChiDaDat(id_Student, id_Semester));
						resultDAO.update(semester_Result);
					}
				}else {
					Semester semester = new SemesterDAO().getByKey(id_Semester);
					Course course = new CourseDAO().getByKey(id_Course);
					Student student = new StudentDAO().getByKey(id_Student);
					sub_PassDAO.update(new Sub_Pass(semester, course, student, score, scoreHe4, Rate));
					
					if(exitsemeterDao==false) {
						Semester_Result semester_Result=new Semester_Result(semester, student, resultDAO.getDiemTB(id_Student, id_Semester), resultDAO.getDiemTBHe4(id_Student, id_Semester), resultDAO.getSoTinChiDaDat(id_Student, id_Semester));
						resultDAO.insert(semester_Result);
						}else {
							Semester_Result semester_Result=new Semester_Result(semester, student, resultDAO.getDiemTB(id_Student, id_Semester), resultDAO.getDiemTBHe4(id_Student, id_Semester), resultDAO.getSoTinChiDaDat(id_Student, id_Semester));
							resultDAO.update(semester_Result);
						}
				}
			}
		}
		doGet(request, response);
	}
}
