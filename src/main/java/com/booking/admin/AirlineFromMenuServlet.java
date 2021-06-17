package com.booking.admin;

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

import com.booking.service.UserService;


@WebServlet("/doairline")
public class AirlineFromMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getServletPath();
		HttpSession session = request.getSession();
		System.out.println("PlacesFromMenuServlet - url is: " + url);
		if (UserService.isAdmin(session, request, response)) {
			UserService.setMenu(session, request, response);
			request.getRequestDispatcher("airline.html").include(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}
}
