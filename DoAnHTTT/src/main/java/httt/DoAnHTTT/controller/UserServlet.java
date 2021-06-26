package httt.DoAnHTTT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import httt.DoAnHTTT.database.UserDAO;
import httt.DoAnHTTT.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String referer = request.getHeader("Referer");
		String iAction = request.getParameter("action");
		String id_UserKind = "";
		if (iAction != null && !iAction.equals("")) {
			if (iAction.equals("Login")) {
				id_UserKind = login(request, response);
			}

		}
		if (id_UserKind.equals("st")) {
			response.sendRedirect(referer);
		} else if (id_UserKind.equals("pr")) {
			response.sendRedirect("/DoAnHTTT/admin/index");
		} else {
			response.sendRedirect(referer);
		}
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id_UserKind = "";
		HttpSession session = request.getSession();
		UserDAO dao = new UserDAO();
		String ID_User = request.getParameter("ID_User");
		String password = request.getParameter("password");
		User user = dao.check(ID_User, password);
		if (user != null) {
			id_UserKind = user.getiD_UserKind();
			session.setAttribute("currentUser", user);
		}
		return id_UserKind;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
