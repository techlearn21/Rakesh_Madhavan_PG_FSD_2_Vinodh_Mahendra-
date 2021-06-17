package com.booking.utils;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieUtil {
	private CookieUtil() {}
	
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie ck : request.getCookies()) {
				if(ck.getName().equals(name)) {
					return ck;
				}
			}
		}
		
		return null;
	}
	
	public static void setValue(HttpServletResponse response, Cookie cookie, String newValue) {
		if(cookie != null) {
			cookie.setValue(newValue);
			response.addCookie(cookie);
		}
	}
	
	public static HttpServletResponse setValue(HttpServletRequest request, HttpServletResponse response, String cookieName, String newValue) {
		Cookie cookie = getCookie(request, cookieName);	
		if( cookie != null) {
			cookie.setValue(newValue);
			response.addCookie(cookie);
		} else {
			cookie = new Cookie(cookieName, newValue);
			response.addCookie(cookie);
		}
		
		return response;
	}
	
	public static void printAllCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie ck : request.getCookies()) {
				System.out.println("cookie - name: " + ck.getName() + ", value: " + ck.getValue()); 
			}
		}
	}
	
	public static void printAllSessionVars(HttpSession session) {
		System.out.println("session id: " + session.getId());
		Enumeration<?> sessionAttributes = session.getAttributeNames();
		while(sessionAttributes.hasMoreElements()) {
			String attr = (String) sessionAttributes.nextElement();
			System.out.println("session Attribute name: " + attr + ": " + session.getAttribute(attr));
		}
	}
}
