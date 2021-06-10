package com.booking.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booking.model.LoginUser;
import com.booking.model.User;
import com.booking.service.UserService;
import com.booking.utils.HibernateUtils;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/login")
public class AuthenticationFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginUser newUser = new LoginUser();
		newUser.setUserName(username);	
		newUser.setPassword(password);
		newUser.setUserType("normal");
		
		PrintWriter out = response.getWriter();
		
		UserService userService = new UserService();
		
		User retrievedUser = retrieveUser(newUser.getUserName());
		System.out.println("retrievedUser: " + retrievedUser);
		boolean check = userService.authenticateUser(newUser, retrievedUser);
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String url = servletRequest.getServletPath();
		System.out.println("url is: " + url);
		
		HttpSession session = servletRequest.getSession(false);
		String loggedInUser = "";
		String loggedInFlag = "";
		
		if(session != null) {
			loggedInUser = (String) session.getAttribute("loggedInUser");
			loggedInFlag = (String) session.getAttribute("userAuth");
		}
		
		System.out.println("loggedInUser: " + loggedInUser);
		System.out.println("loggedInUser: " + loggedInFlag);
		System.out.println("check: " + check);
		
		if(check || (!loggedInUser.equals("guest") && loggedInFlag.equals("true"))) {
			chain.doFilter(request, response);
		} else {
			out.println("<h1>You are not authorized to view this page</h1>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	private User retrieveUser(String username) {
		User retrievedUser = new User();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", username));
		List<User> users = criteria.list();
		if(users.isEmpty()) {
			return retrievedUser;
		}
		session.close();
		
		return users.get(0);
	}

}
