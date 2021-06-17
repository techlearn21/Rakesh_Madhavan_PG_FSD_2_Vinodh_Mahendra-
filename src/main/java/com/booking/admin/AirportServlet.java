package com.booking.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.booking.model.Airport;
import com.booking.model.LoginUser;
import com.booking.service.UserService;
import com.booking.utils.CookieUtil;
import com.booking.utils.FlightConstants;
import com.booking.utils.HibernateUtils;


@WebServlet("/airport")
public class AirportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("AirportServlet: start");
		
		HttpSession session = request.getSession();
		String airportCode = request.getParameter("airportcode");
		String airportName = request.getParameter("airportname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		Airport airport = new Airport();
		airport.setAirportCode(airportCode);
		airport.setAirportName(airportName);
		airport.setCity(city);
		airport.setState(state);
		airport.setCountry(country);
		
		Session dbSession = HibernateUtils.getSessionFactory().openSession();
		dbSession.beginTransaction();
		dbSession.save(airport);
		dbSession.getTransaction().commit();
		dbSession.close();
		
		
		PrintWriter out = response.getWriter();
		UserService.setMenu(session, request, response);
		request.getRequestDispatcher("airport.html").include(request, response);

	}

}
