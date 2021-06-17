<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="/booking-app">Home <span class="sr-only"></span></a>
				</li>
				
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <%=session.getAttribute("loggedInUser") %> </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="/booking-app/doairport">Add Airport</a>
						<a class="dropdown-item" href="/booking-app/doairline">Add Airline</a>
						<a class="dropdown-item" href="/booking-app/doaddflight">Add Flight</a>
						<a class="dropdown-item" href="/booking-app/doadminpass">Reset Admin Password</a>
						<a class="dropdown-item" href="/booking-app/dologout">Logout</a> 
					</div>
				</li>
			</ul>
		</div>
	</nav>

</body>
</html>