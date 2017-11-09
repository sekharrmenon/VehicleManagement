<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
    <script type="text/javascript">
    var msg ='${msg}';
    </script>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Vehicle Management</title>

        <!-- CSS -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,500,500i">
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="resources/css/animate.css">
        <link rel="stylesheet" href="resources/css/style.css">


        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
	
    </head>

    <body>
		<!-- Top menu -->
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header wow fadeIn">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">Vehicle Management   ${userDetails.username} </a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right navbar-search-button">
						<li><a class="search-button" href="#"><i class="fa fa-search"></i></a></li>
					</ul>
					<form class="navbar-form navbar-search-form disabled wow fadeInLeft" role="form" action="" method="post">
						<div class="form-group">
							<input type="text" name="search" placeholder="Search..." class="search form-control">
						</div>
					</form>
					<ul class="nav navbar-nav navbar-right navbar-menu-items wow fadeIn">
<%-- 						<c:if test="${user.access.view==true}"><li><a href="/vehiclemanagement/login">Login</a></li></c:if>	 --%>
						<c:choose>
    						<c:when test="${empty user.name}">
        						<li><a href="/vehiclemanagement/login">Login</a></li>
    						</c:when>
    					<c:otherwise>
        				<li><a href="/vehiclemanagement/logout">Logout</a></li>
    						</c:otherwise>
					</c:choose>
						<li><a href="/vehiclemanagement/">Home</a></li>		
						<li><a href="/vehiclemanagement/newVehicle">Add vehicle</a></li>
						<li><a href="#">Highligths</a></li>
						<li><a href="/vehiclemanagement/view">View</a></li>
						
					</ul>
				</div>
			</div>
		</nav>

        <!-- Top content -->
        <div class="top-content">
            <div class="container">
            	
                <div class="row">
                    <div class="col-sm-12 text wow fadeInLeft">
                        <h1>Vehicle <strong>Management</strong> System</h1>
                        <div class="description">
                        	<p class="medium-paragraph">
                         	This application is used to manage vehicles
                        	</p>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
       

        <!-- Footer -->
        <footer>
	        <div class="container">
	        	<div class="row">
	        		<div class="col-sm-12 footer-copyright">
                    	&copy; Vehicle Management  by <a href="https://github.com/sekharrmenon/VehicleManagement">Sekhar R Menon</a>
                    </div>
                </div>
	        </div>
        </footer>
        
       	<div class="alert alert-success" id="message">
  		<strong>${msg}</strong> 
		</div>


        <!-- Javascript -->
        <script src="resources/js/jquery-1.11.1.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.backstretch.min.js"></script>
        <script src="resources/js/wow.min.js"></script>
        <script src="resources/js/scripts.js"></script>
         <script src="resources/js/vehiclehome.js"></script>
    </body>

</html>