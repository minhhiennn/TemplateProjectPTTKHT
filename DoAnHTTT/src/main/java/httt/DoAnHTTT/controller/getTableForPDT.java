package httt.DoAnHTTT.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import httt.DoAnHTTT.database.ScheduleDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduleDAO scheduleDAO = new ScheduleDAO();
	    HashMap<String,ArrayList<String>> hashMap = scheduleDAO.getAllSchedule();
	    request.setAttribute("hashMap", hashMap);
	    for (String string : hashMap.keySet()) {
			 request.setAttribute("Itemlength", hashMap.get(string));
			 break;
		}
	    request.getRequestDispatcher("/pdt/table").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
