package com.booking.service; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booking.model.Flight;
import com.booking.model.LoginUser;
import com.booking.model.User;
import com.booking.utils.CookieUtil;
import com.booking.utils.FlightConstants;
import com.booking.utils.HibernateUtils;

public class UserService {
	
	private String normalUser = "user";
	private String normalPassword = "simpli";
	
	private String adminUser = "admin";
	private String adminPassword = "simplilearn";
	
	boolean valid = false;
	
	
	public boolean authenticateAdmin(LoginUser user) {
		boolean result = user.getUserName().equals(adminUser) && 
				user.getPassword().equals(adminPassword) &&
				user.getUserType().equals("admin");
		
		System.out.println("authenticateAdmin() - user: " + user.getUserName() 
		+ ", password: " + user.getPassword()
		+ ", userType: " + user.getUserType()
		+ ", result: " + result
		);
		
		return result;
	}
	
	public boolean authenticateUser(LoginUser user) {
		boolean result = user.getUserName().equals(normalUser) && 
				user.getPassword().equals(normalPassword) &&
				user.getUserType().equals("normal");
		
		System.out.println("authenticateUser() - user: " + user.getUserName() 
		+ ", password: " + user.getPassword()
		+ ", userType: " + user.getUserType()
		+ ", result: " + result
		);
		
		return result;
	}
	
	public boolean authenticateUser(LoginUser user, User retrievedUser) {
		boolean result = user.getUserName().equals(retrievedUser.getUserName()) && 
				user.getPassword().equals(retrievedUser.getPassword());
		
		System.out.println("authenticateUser() - user: " + user.getUserName() 
		+ ", password: " + user.getPassword()
		+ ", userType: " + user.getUserType()
		+ ", result: " + result
		);
		
		return result;
	}
	
	public boolean comparePasswords(String pwd1, String pwd2) {
		boolean result = pwd1.equals(pwd2);
		
		System.out.println("checkNewAdminPassword() - pwd1: " + pwd1 
		+ ", pwd2: " + pwd2
		+ ", result: " + result
		);
		
		return result;
	}
	
	public boolean updateAdminPassword(LoginUser adminUser, String pwd1, String pwd2) {
		boolean updated = false;
		
		if(authenticateAdmin(adminUser) && comparePasswords(pwd1, pwd2)) {
			adminPassword = pwd1;
			updated = true;
		}
		return updated;
	}
	
	public User getUser(String userName) {
		User retrievedUser = new User();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<User> users = criteria.list();
		if(users.isEmpty() || users.size() > 1) {
			return retrievedUser;
		}
		session.close();
		
		return users.get(0);
	}
	
	public LoginUser validateUser(LoginUser user) {
		User retrievedUser = getUser(user.getUserName());
		boolean check = comparePasswords(user.getPassword(), retrievedUser.getPassword());
		if(check) {
			user.setUserType(retrievedUser.getUserType());
			user.setStatus(FlightConstants.STATUS_VERIFIED);
		} else {
			user.setUserType(FlightConstants.USER_UNAUTHORIZED);
			user.setStatus(FlightConstants.STATUS_REJECTED);
		}
		return user;
	}
	
	public static void setSessionVariables(HttpSession session, HttpServletRequest request, HttpServletResponse response, LoginUser validatedUser) {
		
		session.setAttribute("loggedInUser", validatedUser.getUserName());
		session.setAttribute("userAuth", validatedUser.getStatus());
		session.setAttribute("userType", validatedUser.getUserType());
		
		CookieUtil.setValue(request, response, "loggedInUser", validatedUser.getUserName());
		CookieUtil.setValue(request, response, "userAuth", validatedUser.getStatus());
		CookieUtil.setValue(request, response, "userType", validatedUser.getUserType());
	}
	
	public static void initializeSessionVariables(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		if(session.getAttribute("loggedInUser") == null) {
			session.setAttribute("loggedInUser", "guest");
			CookieUtil.setValue(request, response, "loggedInUser", "guest");
		}
		
		if(session.getAttribute("userAuth") == null) {
			session.setAttribute("userAuth", FlightConstants.STATUS_UNVERIFIED);
			CookieUtil.setValue(request, response, "userAuth", FlightConstants.STATUS_UNVERIFIED);
		}
		
		if(session.getAttribute("userType") == null) {
			session.setAttribute("userType", FlightConstants.USER_UNAUTHORIZED);
			CookieUtil.setValue(request, response, "userType", FlightConstants.USER_UNAUTHORIZED);
		}
				
	}
	
	public static void clearSessionVariables(HttpSession session, HttpServletRequest request, HttpServletResponse response, LoginUser validatedUser) {
		
		session.setMaxInactiveInterval(0);
		session.invalidate();
	
		session.setAttribute("loggedInUser", "guest");
		session.setAttribute("userAuth", validatedUser.getStatus());
		session.setAttribute("userType", validatedUser.getUserType());
		
		CookieUtil.setValue(request, response, "loggedInUser", "guest");
		CookieUtil.setValue(request, response, "userAuth", validatedUser.getStatus());
		CookieUtil.setValue(request, response, "userType", validatedUser.getUserType());
	}
	
	public static void setMenu(HttpSession session, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String loggedInUser = "";
		String loggedInFlag = "";
		String loggedInType = "";
		
		if(session != null) {
			loggedInUser = (String) session.getAttribute("loggedInUser");
			loggedInFlag = (String) session.getAttribute("userAuth");
			loggedInType = (String) session.getAttribute("userType");
						
			if(loggedInFlag.equals(FlightConstants.STATUS_VERIFIED) && loggedInType.equals(FlightConstants.USER_NORMAL)) {
				System.out.println("LoginServlet: loggedInUser: " + loggedInUser);
				System.out.println("LoginServlet: loading normal menu");
				request.getRequestDispatcher("nav-logged-normal.jsp").include(request, response);
			} else if(loggedInFlag.equals(FlightConstants.STATUS_VERIFIED) && loggedInType.equals(FlightConstants.USER_ADMIN)) {
				System.out.println("LoginServlet: loading adminl menu");
				request.getRequestDispatcher("nav-logged-admin.jsp").include(request, response);
			} else {
				System.out.println("LoginServlet: loading guest menu");
				request.getRequestDispatcher("nav-not-logged.jsp").include(request, response);
			}
		} else {
			System.out.println("Session is null");
			request.getRequestDispatcher("nav-not-logged.jsp").include(request, response);
		}
	}
	
	
	public static boolean isAdmin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		String userAuth = (String) session.getAttribute("userAuth");
		String userType = (String) session.getAttribute("userType");
		
		if ((loggedInUser != null) && (loggedInUser != null) && (loggedInUser != null)) {
			boolean userCheck = loggedInUser.equals("admin");
			boolean userAuthCheck = userAuth.equals(FlightConstants.STATUS_VERIFIED);
			boolean userTypeCheck = userType.equals(FlightConstants.USER_ADMIN);
			
			if (userCheck && userAuthCheck && userTypeCheck) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
