package com.booking.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.booking.model.Flight;
import com.booking.model.LoginUser;
import com.booking.model.User;
import com.booking.service.UserService;
import com.booking.utils.FlightConstants;
import com.booking.utils.HibernateUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register-after-flight-summary")
public class RegisterAfterFlightSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("password-confirm");
		
		UserService userService = new UserService();
		boolean passwordCheck = userService.comparePasswords(password1, password2);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(!passwordCheck) {
			//Response for incorrect password
			out.println("<h1>Password check failed</h1>");
		}
		
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password1);
		user.setUserType("normal");
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
		HttpSession httpSession = request.getSession();
		UserService.setMenu(httpSession, request, response);
		
		LoginUser loginUser = new LoginUser();
		loginUser.setUserName(user.getUserName());
		loginUser.setUserType(user.getUserType());
		loginUser.setStatus(FlightConstants.STATUS_VERIFIED);
		loginUser.setPassword(user.getPassword());
		
		UserService.setSessionVariables(httpSession, request, response, loginUser);
		
		Flight flight = (Flight) httpSession.getAttribute("selectedFlight");
		request.setAttribute("flightCode", flight.getCode());	
		request.setAttribute("selectedFlight", flight);
		httpSession.setAttribute("flightCode", flight.getCode());
		httpSession.setAttribute("selectedFlight", flight);
		request.getRequestDispatcher("flight-payment.jsp").include(request, response);
	}
	
	public void destroy() {
		System.out.println("destroy(): closing HibernateUtils.getSessionFactory().close()");
		HibernateUtils.getSessionFactory().close();
	}

}
