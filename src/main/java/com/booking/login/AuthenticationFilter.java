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
import com.booking.utils.FlightConstants;
import com.booking.utils.HibernateUtils;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
//@WebFilter("/login")
public class AuthenticationFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
//		HttpServletRequest servletRequest = (HttpServletRequest) request;
//		HttpServletResponse servletResponse = (HttpServletResponse) response;
//		String url = servletRequest.getServletPath();
//		System.out.println("url is: " + url);
//		
//		HttpSession session = servletRequest.getSession(false);
//		String loggedInUser = "intialized";
//		String loggedInFlag = "intialized";
//		String loggedInType = "intialized";
//		
//		try {
//		
//		if(session != null) {
//			loggedInUser = (String) session.getAttribute("loggedInUser");
//			loggedInFlag = (String) session.getAttribute("userAuth");
//			loggedInType = (String) session.getAttribute("userType");
//			
//			if(loggedInFlag.equals("normal") && loggedInType.equals(FlightConstants.STATUS_VERIFIED)) {
//				System.out.println("AuthenticationFilter: loading normal menu");
//				request.getRequestDispatcher("nav-logged-normal.jsp").include(request, response);
//			} else if(loggedInFlag.equals("admin") && loggedInType.equals(FlightConstants.STATUS_VERIFIED)) {
//				System.out.println("AuthenticationFilter: loading admin menu");
//				request.getRequestDispatcher("nav-logged-admin.jsp").include(request, response);
//			} else {
//				System.out.println("AuthenticationFilter: loading guest menu");
//				request.getRequestDispatcher("nav-not-logged.jsp").include(request, response);
//			}
//		} else {
//			System.out.println("AuthenticationFilter: loading guest menu");
//			request.getRequestDispatcher("nav-not-logged.jsp").include(request, response);
//		}
//		} catch (Exception ex) {
//			System.out.println("AuthenticationFilter: Exception : " + ex.getMessage());
//			System.out.println("AuthenticationFilter: loading guest menu");
//			
//			UserService.initializeSessionVariables(session, servletRequest, servletResponse);
//			request.getRequestDispatcher("nav-not-logged.jsp").include(request, response);
//			
//		}
//		
//		request.getRequestDispatcher("login.jsp").include(request, response);
//
//		
//		System.out.println("AuthenticationFilter: loggedInUser: " + loggedInUser);
//		System.out.println("AuthenticationFilter: loggedInFlag: " + loggedInFlag);
//		System.out.println("AuthenticationFilter: loggedInType: " + loggedInType);
		
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
