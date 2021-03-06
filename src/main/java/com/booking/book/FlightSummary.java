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


@WebServlet("/flight-summary")
public class FlightSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] selectedValues = request.getParameterValues("flightradio");
		String code = selectedValues[0];
		FlightService flightService = new FlightService();
		Flight retrievedFlight = flightService.getFlight(code);
		
		request.setAttribute("selectedFlight", retrievedFlight);
		request.getSession().setAttribute(code, selectedValues);
		
		HttpSession session = request.getSession();
		session.setAttribute("selectedFlight", retrievedFlight);
		
		UserService.setMenu(session, request, response);
		request.getRequestDispatcher("flight-summary.jsp").include(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
