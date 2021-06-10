package com.booking.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout.html")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("loggedInUser");
		
		session.setAttribute("loggedInUser", "guest");
		session.setAttribute("userAuth", "false");
		
		session.invalidate();

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h3> Logged out " + userName + "</h3>");
		
		System.out.println("Servlet context: " + request.getServletContext().getContextPath());
		
		request.getRequestDispatcher("").forward(request, response);
	}

}
