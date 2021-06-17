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

import com.booking.utils.CookieUtil;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("loggedInUser");
		
		session.setAttribute("loggedInUser", "guest");
		session.setAttribute("userAuth", "false");
		
		Cookie cookie = CookieUtil.getCookie(request, "loggedInUser");
		System.out.println("Retrieving name of cookie for loggedInUser: " + cookie.getName() + ", value: " + cookie.getValue());
		CookieUtil.setValue(response, cookie, "guest");
		System.out.println("Retrieving name of cookie for loggedInUser2: " + cookie.getName() + ", value: " + cookie.getValue());
		
		
		session.invalidate();

		if (cookie.getValue().equals("guest")) {
			System.out.println("User logged out");
		} else {
			System.out.println("User log out not successful. cookie name: " + cookie.getName() + ", " + cookie.getValue());
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h3> Logged out " + userName + "</h3>");
		
		System.out.println("Navigating to servlet context: " + request.getServletContext().getContextPath());
		
		response.sendRedirect(request.getContextPath());
	}

}
