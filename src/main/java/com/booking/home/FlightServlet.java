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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booking.model.Flight;
import com.booking.model.User;
import com.booking.utils.HibernateUtils;

/**
 * Servlet implementation class FlightServlet
 */
@WebServlet("/flight")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("FlightServlet: doPost");
		
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
		
		System.out.println("FlightServlet: going to call getFlights. " + searchRequest.toString());
		List<Flight> results = getFlights(searchRequest);
		request.setAttribute("searchResults", results);
		
		System.out.println("Going to redirect to flight-search-result.jsp");
		
	    request.getRequestDispatcher("flight-search-result.jsp").include(request, response);
	    
		System.out.println("redirect to flight-search-result.jsp COMPLETED");

	        
	}
	
	private List<Flight> getFlights(SearchFlightRequest request) {
		List<Flight> results = new ArrayList<Flight>();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		System.out.println("Opensession done");
		session.beginTransaction();
		System.out.println("beginTransaction done");
		System.out.println("Going to retrieve results based on object: " + request.toString());
		Criteria criteria = session.createCriteria(Flight.class)
				.add(Restrictions.eq("source", request.getStartFrom()))
				.add(Restrictions.eq("destination", request.getDestination()));
		results = criteria.list();
		System.out.println("Results Retrieved");
		session.close();
		
		if(results.isEmpty()) {
			System.out.println("No results retrieved");;
		}
		
		System.out.println("Search result: " + results);
		
		return results;
	}

}
