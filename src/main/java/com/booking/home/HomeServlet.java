package com.booking.home;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		System.out.println("url is: " + url);
		HttpSession session = request.getSession();
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		String userAuth = (String) session.getAttribute("userAuth");
		
		System.out.println("HomeServlet: Redirecting..... loggedInUser: " + loggedInUser + ", userAuth: " + userAuth );
		
		try {
			if(loggedInUser == null || userAuth == null ) {
				System.out.println("home.html");
				request.getRequestDispatcher("home.html").forward(request, response);
			} else if(loggedInUser.equals("guest") || userAuth.equals("false")) {
				System.out.println("home.html");
				request.getRequestDispatcher("home.html").forward(request, response);
			} else {
				System.out.println("home-logged-in.html");
				request.getRequestDispatcher("home-logged-in.html").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("home-logged-in.html");
			request.getRequestDispatcher("home.html").forward(request, response);;
		}
	}
}
