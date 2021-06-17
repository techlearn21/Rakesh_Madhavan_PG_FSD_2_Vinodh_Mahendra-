package com.booking.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.booking.model.Airline;
import com.booking.model.Airport;
import com.booking.model.Flight;
import com.booking.service.FlightService;
import com.booking.service.UserService;
import com.booking.utils.HibernateUtils;


@WebServlet("/add-flight")
public class AddFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String airline = request.getParameter("airline");
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");
		String price = request.getParameter("price");
		
		
		response.setContentType("text/html");
		
		Flight flight = new Flight();
		flight.setCode(code);
		flight.setSource(source);
		flight.setDestination(destination);
		flight.setAirline(airline);
		flight.setStarttime(startTime);
		flight.setEndtime(endTime);
		flight.setPrice(price);
		
		
		Session dbSession = HibernateUtils.getSessionFactory().openSession();
		dbSession.beginTransaction();
		dbSession.save(flight);
		dbSession.getTransaction().commit();
		dbSession.close();
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		FlightService flightService = new FlightService();
		
		if (UserService.isAdmin(session, request, response)) {
			List<Airline> airlines = flightService.getAllAirlines();
			request.setAttribute("allAirlines", airlines);
			
			List<Airport> airports = flightService.getAllAirports();
			request.setAttribute("allAirports", airports);
			UserService.setMenu(session, request, response);
			out.println("<h6 align='center' style='color:black;'>Flight added</h6>");
			request.getRequestDispatcher("addflight.jsp").include(request, response);
		} else {
			out.println("<h6 align='center' style='color:black;'>Flight added</h6>");
			response.sendRedirect(request.getContextPath());
		}
		
	}
	
	public void destroy() {
		System.out.println("destroy(): closing HibernateUtils.getSessionFactory().close()");
		HibernateUtils.getSessionFactory().close();
	}

}
