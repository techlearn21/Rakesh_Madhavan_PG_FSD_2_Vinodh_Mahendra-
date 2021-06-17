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


@WebServlet("/flight-payment")
public class FlightPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("flightCode");
		FlightService flightService = new FlightService();
		Flight retrievedFlight = flightService.getFlight(code);
		
		HttpSession session = request.getSession();
		session.setAttribute("selectedFlight", retrievedFlight);
		session.setAttribute("flightCode", retrievedFlight.getCode());
		request.setAttribute("selectedFlight", retrievedFlight);
		request.setAttribute("flightCode", retrievedFlight.getCode());
		
		UserService.setMenu(session, request, response);
		request.getRequestDispatcher("flight-payment.jsp").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
