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


@WebServlet("/register-login")
public class RegisterOrLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		Flight flight = (Flight) session.getAttribute("selectedFlight");
		
		request.setAttribute("selectedFlight", flight);
		session.setAttribute("selectedFlight", flight);
		boolean userCheck = UserService.isNormalUserLoggedIn(session, request, response);
		PrintWriter out = response.getWriter();
		
		if(userCheck) {
			UserService.setMenu(session, request, response);
			request.getRequestDispatcher("flight-payment.jsp").include(request, response);
		} else {
			UserService.setMenu(session, request, response);
			out.println("<h3 align='center' style='color:black;'>Please Login or Register and then proceed</h3>");
			request.getRequestDispatcher("register-after-flight-summary.html").include(request, response);
		}
		
	}
	

}
