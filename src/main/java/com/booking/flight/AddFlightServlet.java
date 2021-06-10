package com.booking.flight;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.booking.model.Flight;
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
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Flight flight = new Flight();
		flight.setCode(code);
		flight.setSource(source);
		flight.setDestination(destination);
		flight.setAirline(airline);
		flight.setStarttime(startTime);
		flight.setEndtime(endTime);
		flight.setPrice(price);
		
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(flight);
		session.getTransaction().commit();
		session.close();
		
		out.println("<h3>Flight save successful</h3>");
	}
	
	public void destroy() {
		System.out.println("destroy(): closing HibernateUtils.getSessionFactory().close()");
		HibernateUtils.getSessionFactory().close();
	}

}
