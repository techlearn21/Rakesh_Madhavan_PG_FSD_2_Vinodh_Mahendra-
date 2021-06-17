package com.booking.home;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booking.model.Airline;
import com.booking.model.Airport;
import com.booking.service.FlightService;
import com.booking.service.UserService;


@WebServlet("/home")
public class HomeServletFromMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		System.out.println("url is: " + url);
		HttpSession session = request.getSession();
		
		UserService.initializeSessionVariables(session, request, response);
		
		UserService.setMenu(session, request, response);
		request.getRequestDispatcher("").include(request, response);

	}
}
