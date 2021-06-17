package com.booking.login;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import com.booking.service.UserService;


@WebServlet("/doregister")
public class RegisterFromMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		System.out.println("url is: " + url);
		HttpSession session = request.getSession();
		System.out.println("LogoutFromMenuServlet: /dologout");
		UserService.setMenu(session, request, response);
		request.getRequestDispatcher("register.html").include(request, response);
	}
}
