package com.booking.service; 

import com.booking.model.LoginUser;
import com.booking.model.User;

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

}
