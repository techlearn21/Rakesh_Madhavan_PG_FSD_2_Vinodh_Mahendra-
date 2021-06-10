package com.booking.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = request.getParameter("username");
		
		session.setAttribute("loggedInUser", userName);
		session.setAttribute("userAuth", "true");
		
		System.out.println("LoginServlet: loggedInUser: " + session.getAttribute("loggedInUser") + ", userAuth: " + session.getAttribute("userAuth"));

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h3> Welcome " + userName + "</h3>");
		
	}

}
