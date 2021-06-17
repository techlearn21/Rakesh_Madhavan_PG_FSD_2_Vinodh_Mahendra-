package com.booking.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booking.model.Flight;
import com.booking.service.FlightService;
import com.booking.service.UserService;
import com.booking.utils.HibernateUtils;


@WebServlet("/flight-confirmation")
public class FlightConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String code = (String) session.getAttribute("flightCode");
		Flight flight = (Flight) session.getAttribute("selectedFlight");
		
		FlightService flightService = new FlightService();
		Flight retrievedFlight = new Flight();
		if(code != null ) {
			retrievedFlight = flightService.getFlight(code);
		} else {
			retrievedFlight = (Flight) session.getAttribute("retrievedFlight");
		}
		
		session.setAttribute("selectedFlight", retrievedFlight);
		request.setAttribute("selectedFlight", retrievedFlight);	
		UserService.setMenu(session, request, response);
		request.getRequestDispatcher("flight-confirmation.jsp").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
