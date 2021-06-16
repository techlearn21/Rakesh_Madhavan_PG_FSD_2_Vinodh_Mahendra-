package com.booking.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booking.model.LoginUser;
import com.booking.service.UserService;
import com.booking.utils.CookieUtil;
import com.booking.utils.FlightConstants;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("LoginServlet: start");
		
		HttpSession session = request.getSession();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginUser user = new LoginUser();
		user.setUserName(userName);
		user.setPassword(password);
		
		UserService userService = new UserService();
		LoginUser validatedUser = userService.validateUser(user);
		UserService.setSessionVariables(session, request, response, validatedUser);
		
		UserService.setMenu(session, request, response);
		
		PrintWriter out = response.getWriter();
		if (validatedUser.getStatus().equals(FlightConstants.STATUS_VERIFIED)) {
			out.println("<h6 align='center'> Welcome, " + validatedUser.getUserName() + " </h6>");
		} else {
			out.println("<h6 align='center'> Login failed </h6>");
		}
		
		request.getRequestDispatcher("login.jsp").include(request, response);

	}

}
