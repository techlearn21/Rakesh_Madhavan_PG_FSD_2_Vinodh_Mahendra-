package com.booking.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booking.model.Flight;
import com.booking.model.SearchFlightRequest;
import com.booking.model.User;
import com.booking.service.FlightService;
import com.booking.service.UserService;
import com.booking.utils.HibernateUtils;

/**
 * Servlet implementation class FlightServlet
 */
@WebServlet("/search")
public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("SearchFlightServlet: doPost");
		
		String startPlace = request.getParameter("source");
		String destination = request.getParameter("destination");
		int numAdults = Integer.parseInt(request.getParameter("adults"));
		int numChildren = Integer.parseInt(request.getParameter("children"));
		
		Locale locale = request.getLocale();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", locale);
		Date startDate = new Date();
		Date returnDate = new Date();

		try {
			startDate = format.parse(request.getParameter("startdate"));
			returnDate = format.parse(request.getParameter("returndate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SearchFlightRequest searchRequest = new SearchFlightRequest();
		searchRequest.setStartFrom(startPlace);
		searchRequest.setDestination(destination);
		searchRequest.setAdults(numAdults);
		searchRequest.setChildren(numChildren);
		searchRequest.setStartDate(startDate);
		searchRequest.setReturnDate(returnDate);
		
		FlightService flightService = new FlightService();
		List<Flight> results = flightService.getFlights(searchRequest);
		
		request.setAttribute("searchResults", results);
		
		HttpSession session = request.getSession();
		session.setAttribute("searchResults", results);
		UserService.setMenu(session, request, response);
	    request.getRequestDispatcher("flight-search-result.jsp").include(request, response);
	    
	}
	
}
