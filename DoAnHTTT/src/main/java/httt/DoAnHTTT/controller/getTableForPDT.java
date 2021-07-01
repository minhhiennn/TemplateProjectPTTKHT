package httt.DoAnHTTT.controller;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;

=======

import javax.mail.Session;
>>>>>>> a7365d24b3b656fba836cddbe0282d1bdb5dd3c8
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession httpSession = request.getSession();
		String table = request.getParameter("table");
		String action = request.getParameter("action");
		if(action.equals("delete")) {
			
		}else {
			httpSession.setAttribute("table", table);
			String referer = request.getHeader("Referer");
			response.sendRedirect(referer);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
