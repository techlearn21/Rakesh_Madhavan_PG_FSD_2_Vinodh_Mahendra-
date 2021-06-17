<%@page import="org.apache.commons.lang3.RandomStringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.booking.model.User"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Login</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<style>
	.signup-form {
	    width: 550px;
	    margin: 50px auto;
	  	font-size: 15px;
	}
	.signup-form h2 {
		color: #636363;
		margin: 0 0 15px;
		position: relative;
		text-align: center;
	}
	.signup-form .hint-text {
		color: #999;
		margin-bottom: 30px;
		text-align: center;
	}
	.signup-form form {
	    margin-bottom: 15px;
	    background: #f7f7f7;
	    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	    padding: 30px;
	}
	.signup-form h2 {
	    margin: 0 0 15px;
	}
	.form-control, .btn {
	    min-height: 38px;
	    border-radius: 2px;
	}
	.btn {        
	    font-size: 15px;
	    font-weight: bold;
	}
</style>

</head>
<body>
	
				<%
					System.out.println("In flight-confirmation.jsp");
					User user = (User) request.getAttribute("userDetails");
					System.out.println("userName: " + user.getUserName());
					System.out.println("user email: " + user.getEmail());
					String ticketNumber = RandomStringUtils.randomAlphanumeric(10);
				%>

	<div class="signup-form">
			<form action="/booking-app/register" method="get">
				<h2>Profile</h2>
				<p class="hint-text">View your profile</p>
		        <div class="form-group">
					<div class="row">
						<div class="col"><input type="text" class="form-control" name="firstname" value=<%= user.getFirstName() %> required="required"></div>
						<div class="col"><input type="text" class="form-control" name="lastname" value=<%= user.getLastName() %> required="required"></div>
					</div>        	
		        </div>
		        
		        <div class="form-group">
		        	<input type="email" class="form-control" name="email" value=<%= user.getEmail() %> required="required">
		        </div>
		        
		        <div class="form-group">
		            <input type="text" class="form-control" name="username" value=<%= user.getUserName() %> required="required">
		        </div>
		        
		        <div class="form-group">
		            <input type="password" class="form-control" name="password" placeholder="new password" required="required">
		        </div>
				<div class="form-group">
		            <input type="password" class="form-control" name="password-confirm" placeholder="confirm new password" required="required">
		        </div>
		        
		        <div class="form-group">
		        	<div class="row">
		            	<div class="col"><button type="submit" class="btn btn-primary btn-block">Register</button></div>
		            	<div class="col"><button type="reset" class="btn btn-secondary btn-block">Clear</button></div>
	            	</div>
		        </div>
				
		</form>
	</div>

</body>
</html>