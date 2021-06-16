package com.booking.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.booking.model.User;
import com.booking.service.UserService;
import com.booking.utils.HibernateUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
		
		out.println("<h3>User registration successful</h3>");
	}
	
	public void destroy() {
		System.out.println("destroy(): closing HibernateUtils.getSessionFactory().close()");
		HibernateUtils.getSessionFactory().close();
	}

}
