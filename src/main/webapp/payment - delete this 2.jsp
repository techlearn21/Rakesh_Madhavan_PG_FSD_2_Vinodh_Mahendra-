<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.booking.model.Flight"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">

<title>Payment</title>

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
.signup-form .font {
	color: black;
	
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
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Guest
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="register.html">Register</a>
	          <a class="dropdown-item" href="login.html">Login</a>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Admin
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="addflight.html">Add Flight</a>
	          <a class="dropdown-item" href="admin-profile.html">Reset Admin Password</a>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>
	    </ul>
	  </div>
	</nav>

		<div class="payment-form">
			<form class="form-horizontal" action="/booking-app/payment" method="post">
				<h2>Payment</h2>
				<p class="hint-text">Pay using credit card</p>
		        
    		    <div class="container">
					<div class="row-fluid">
				     
				        <fieldset>
				          <div id="legend">
				            <legend class="">Payment</legend>
				          </div>
				     
				          <!-- Name -->
				          <div class="control-group">
				            <label class="control-label"  for="username">Card Holder's Name</label>
				            <div class="controls">
				              <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
				            </div>
				          </div>
				     
				          <!-- Card Number -->
				          <div class="control-group">
				            <label class="control-label" for="email">Card Number</label>
				            <div class="controls">
				              <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
				            </div>
				          </div>
				     
				          <!-- Expiry-->
				          <div class="control-group">
				            <label class="control-label" for="password">Card Expiry Date</label>
				            <div class="controls">
				              <select class="span3" name="expiry_month" id="expiry_month">
				                <option></option>
				                <option value="01">Jan (01)</option>
				                <option value="02">Feb (02)</option>
				                <option value="03">Mar (03)</option>
				                <option value="04">Apr (04)</option>
				                <option value="05">May (05)</option>
				                <option value="06">June (06)</option>
				                <option value="07">July (07)</option>
				                <option value="08">Aug (08)</option>
				                <option value="09">Sep (09)</option>
				                <option value="10">Oct (10)</option>
				                <option value="11">Nov (11)</option>
				                <option value="12">Dec (12)</option>
				              </select>
				              <select class="span2" name="expiry_year">
				                <option value="13">2013</option>
				                <option value="14">2014</option>
				                <option value="15">2015</option>
				                <option value="16">2016</option>
				                <option value="17">2017</option>
				                <option value="18">2018</option>
				                <option value="19">2019</option>
				                <option value="20">2020</option>
				                <option value="21">2021</option>
				                <option value="22">2022</option>
				                <option value="23">2023</option>
				              </select>
				            </div>
				          </div>
				     
				          <!-- CVV -->
				          <div class="control-group">
				            <label class="control-label"  for="password_confirm">Card CVV</label>
				            <div class="controls">
				              <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="span2">
				            </div>
				          </div>
				     
				          <!-- Save card -->
				          <div class="control-group">
				            <div class="controls">
				              <label class="checkbox" for="save_card">
				                <input type="checkbox" id="save_card" value="option1">
				                Save card on file?
				              </label>
				            </div>
				          </div>
				     
				          <!-- Submit -->
				          <div class="control-group">
				            <div class="controls">
				              <button class="btn btn-success">Pay Now</button>
				            </div>
				          </div>
				     
				        </fieldset>
				      
				    </div>
				</div>
				
		</form>
	</div>

</body>
</html>