package com.booking.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.model.LoginUser;
import com.booking.service.UserService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin-password")
public class AdminPwdChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO add session valid check
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordNew = request.getParameter("password-new");
		String passwordRepeat = request.getParameter("password-repeat");
		
		LoginUser adminUser = new LoginUser();
		adminUser.setUserName(username);
		adminUser.setPassword(password);
		adminUser.setUserType("admin");
		
		UserService auth = new UserService();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(auth.updateAdminPassword(adminUser, passwordNew, passwordRepeat)) {
			out.println("<h3>Password updated for " + username + "</h3>");
		} else {
			out.println("<h3>Password not updated</h3>");
		}
		
	}

}
