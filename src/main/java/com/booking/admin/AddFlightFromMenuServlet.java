package com.booking.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booking.model.Airline;
import com.booking.model.Airport;
import com.booking.model.Flight;
import com.booking.model.SearchFlightRequest;
import com.booking.service.FlightService;
import com.booking.service.UserService;
import com.booking.utils.HibernateUtils;


@WebServlet("/doaddflight")
public class AddFlightFromMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		HttpSession session = request.getSession();
		System.out.println("AddFlightFromMenuServlet - url is: " + url);
		FlightService flightService = new FlightService();
		
		if (UserService.isAdmin(session, request, response)) {
			List<Airline> airlines = flightService.getAllAirlines();
			request.setAttribute("allAirlines", airlines);
			
			List<Airport> airports = flightService.getAllAirports();
			request.setAttribute("allAirports", airports);
			UserService.setMenu(session, request, response);
			request.getRequestDispatcher("addflight.jsp").include(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}
}
