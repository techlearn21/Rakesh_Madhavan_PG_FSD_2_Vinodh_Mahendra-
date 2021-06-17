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

import com.booking.model.Airline;
import com.booking.model.Airport;
import com.booking.model.LoginUser;
import com.booking.service.UserService;
import com.booking.utils.CookieUtil;
import com.booking.utils.FlightConstants;
import com.booking.utils.HibernateUtils;


@WebServlet("/airline")
public class AirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("AirlineServlet: start");
		
		HttpSession session = request.getSession();
		String airlineCode = request.getParameter("airlinecode");
		String airlineName = request.getParameter("airlinename");
		
		Airline airline = new Airline();
		airline.setCode(airlineCode);
		airline.setName(airlineName);
		
		
		Session dbSession = HibernateUtils.getSessionFactory().openSession();
		dbSession.beginTransaction();
		dbSession.save(airline);
		dbSession.getTransaction().commit();
		dbSession.close();
		
		
		PrintWriter out = response.getWriter();
		UserService.setMenu(session, request, response);
		out.println("<h6 align='center'>Airline added</h6>");
		request.getRequestDispatcher("airline.html").include(request, response);

	}

}
