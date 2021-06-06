package com.booking.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FlightServlet
 */
@WebServlet("/flight")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startPlace = request.getParameter("source");
		String destination = request.getParameter("destination");
		int numAdults = Integer.parseInt(request.getParameter("adults"));
		
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
		
		PrintWriter out = response.getWriter();
		out.println("<p>Start: " + startPlace + "</p>");
		out.println("<p>Destination: " + destination + " </p>");
		out.println("<p># of Adults: " + numAdults + "</p>");
		out.println("<p>Start Date: " + startDate + "</p>");
		out.println("<p>Return Date: " + returnDate + "</p>");
		out.println("<p>Locale: " + locale + "</p>");
		
	}

}
