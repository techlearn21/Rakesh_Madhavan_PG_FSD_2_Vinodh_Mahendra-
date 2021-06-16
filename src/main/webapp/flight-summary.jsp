<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.booking.model.Flight"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">

<title>Flight Summary</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #fff;
	background: rgb(255, 255, 255);
	font-family: 'Roboto', sans-serif;
}
.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}
.form-control:focus {
	border-color: #5cb85c;
}
.form-control, .btn {        
	border-radius: 3px;
}
.signup-form {
	width: 450px;
	margin: 0 auto;
	padding: 30px 0;
  	font-size: 15px;
}
.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}
.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 30%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}	
.signup-form h2:before {
	left: 0;
}
.signup-form h2:after {
	right: 0;
}
.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}
.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}
.signup-form .form-group {
	margin-bottom: 20px;
}
.signup-form input[type="checkbox"] {
	margin-top: 3px;
}
.signup-form .btn {        
	font-size: 16px;
	font-weight: bold;		
	min-width: 140px;
	outline: none !important;
}
.signup-form .row div:first-child {
	padding-right: 10px;
}
.signup-form .row div:last-child {
	padding-left: 10px;
}    	
.signup-form a {
	color: #fff;
	text-decoration: underline;
}
.signup-form a:hover {
	text-decoration: none;
}
.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}	
.signup-form form a:hover {
	text-decoration: underline;
}  
</style>

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="home.html">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          User
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="profile.html">Profile</a>
	          <a class="dropdown-item" href="logout.html">Logout</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Guest
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="register.html">Register</a>
	          <a class="dropdown-item" href="login.html">Login</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Admin
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="addflight.html">Add Flight</a>
	          <a class="dropdown-item" href="admin-profile.html">Reset Admin Password</a>
	        </div>
	      </li>
	    </ul>
	  </div>
	</nav>


				<%
					System.out.println("In flight-summary.jsp");
					Flight flight = (Flight) request.getAttribute("selectedFlight");
					System.out.println("code: " + flight.getCode());
					System.out.println("flight record: " + flight);
				%>
				

		<div class="signup-form">
			<form action="/booking-app/flight-payment" method="post">
				<h2>Summary</h2>
				<p class="hint-text">Summary of selected flight</p>
		        
    		    <div class="form-group">
					<div class="row">
						<div class="col"><h4><span class="label label-default">
							<%= flight.getAirline() + " - " + flight.getCode() %>
						</span></h4></div>
					</div>
		        </div>
		        
		        <div class="form-group">
					<div class="row">
						<div class="col"><h4><span class="label label-default">
							From <%= flight.getSource() + " to " + flight.getDestination() %>
						</span></h4></div>
					</div>        	
		        </div>
		        
		        <div class="form-group">
					<div class="row">
						<div class="col"><h4><span class="label label-default">
							Departs at <%= flight.getStarttime() + ". Lands at " + flight.getEndtime() %>
						</span></h4></div>
					</div>        	
		        </div>
		        
		        <div class="form-group">
					<div class="row">
						<div class="col"><h4><span class="label label-default">
							Total: $<%= flight.getPrice() %>
						</span></h4></div>
						<input type="hidden" name="flightCode" value="<%= flight.getCode() %>" />
					</div>        	
		        </div>
		        
		        <div class="form-group">
					<div class="row">
						<div class="col"></div>
						<div class="col"><button type="submit" class="btn btn-primary btn-block">Pay Now</button></div>
						<div class="col"></div>
					</div>        	
		        </div>
				
		</form>
	</div>

</body>
</html>