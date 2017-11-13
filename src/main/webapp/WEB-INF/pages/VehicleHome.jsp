<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

    <body style="background: #f1f1f1;">
<jsp:include page="./Navigation.jsp" />

		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
        <!-- Top content -->
        <div class="top-content">
            <div class="container">
            	<spring:url value="/search" var="searchUrl" />
                <div class="row">              
                <div class="Searchbox_container">
                	<div class="Searchbox_top">
                		<div id="all" class="Searchbox_square">
                		<div class="Searchbox_category_icon">
                    	<img src="resources/img/search_icon.png" height="35" width="35" alt="Motors">
                		</div>
                		All
                		</div>
                		<div class="Searchbox_square" id="car">
                		<div class="Searchbox_category_icon">
                    	<img src="resources/img/car-icon.png" height="35" width="35" alt="Motors">
                		</div>
                			Car
           			    </div>
           			    <div class="Searchbox_square" id="bike">
           			     <div class="Searchbox_category_icon">
                    	<img src="resources/img/bike-icon.png" height="35" width="35" alt="Motors">
                		</div>
                			Bike
           			    </div>
           			    <div class="Searchbox_square" id="truck">
           			    <div class="Searchbox_category_icon">
                    	<img src="resources/img/truck-icon.png" height="35" width="35" alt="Motors">
                		</div>
                			Truck
           			    </div>
           			    <div class="Searchbox_square" id="other">
           			     <div class="Searchbox_category__icon">
                    	<img src="resources/img/other-icon.png" height="35" width="35" alt="Motors">
                		</div>
                			Other
           			    </div>
                	</div>
   				<div class="col-sm-12 text wow fadeInLeft">
           		<h1>The <strong>Best Place</strong> to search Vehicles</h1>
              <form:form class="form-horizontal" method="post"
                modelAttribute="searchForm" action="${searchUrl}">
                <div class="form-group main-control">
                <form:hidden path="vehicleType" id="vehicleType" value="all"/>
                <form:input path="search" type="text" class="search form-control main-search"
                                id="search" placeholder="Search car, bike or truck" />
				<form:errors path="search" class="control-label" />
       			 <button type="submit" class="search-btn btn-lg btn-primary pull-right">Search
			                             </button>
			         </div>
			        </form:form>
             			
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
      

        <!-- Javascript -->
        <script src="resources/js/jquery-1.11.1.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.backstretch.min.js"></script>
        <script src="resources/js/wow.min.js"></script>
        <script src="resources/js/scripts.js"></script>
         <script src="resources/js/vehiclehome.js"></script>
    </body>

</html>