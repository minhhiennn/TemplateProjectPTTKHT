package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import database.UserDAO;

@WebServlet("/LoginS")
public class LoginS extends HttpServlet {
	boolean b = false;
	UserDAO userDAO;
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String iAction = request.getParameter("action");

		if (iAction != null && !iAction.equals("")) {
			if (iAction.equals("login")) {
				login(request, response);
			}
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String idU = request.getParameter("idU");
		String password = request.getParameter("password");
		userDAO = new UserDAO();
		User user = userDAO.check(idU, password);
		if (user != null) {
			session.setAttribute("userC", user);
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}