<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		  <script src="resources/js/jquery-1.11.1.min.js"></script>
		<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="resources/css/animate.css">
        <link rel="stylesheet" href="resources/css/style.css">
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</head>
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
					<a class="navbar-brand" href="/vehiclemanagement/">Vehicle Management</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
<!-- 					<ul class="nav navbar-nav navbar-right navbar-search-button"> -->
<!-- 						<li><a class="search-button" href="#"><i class="fa fa-search"></i></a></li> -->
<!-- 					</ul> -->
<!-- 					<form class="navbar-form navbar-search-form disabled wow fadeInLeft" role="form" action="" method="post"> -->
<!-- 						<div class="form-group"> -->
<!-- 							<input type="text" name="search" placeholder="Search..." class="search form-control"> -->
<!-- 						</div> -->
<!-- 					</form> -->
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
    						<c:if test="${user.access.create==true}">
        						<li><a href="/vehiclemanagement/newVehicle">Add vehicle</a></li>
    						</c:if>
					<c:if test="${user.access.view==true}">
        						<li><a href="/vehiclemanagement/view">View</a></li>
    				</c:if>
					<c:choose>
    						<c:when test="${not empty user.name}">
        						<li><a href="/vehiclemanagement/trackVehicle">Highligths</a></li>	
    						</c:when>
					</c:choose>												
					</ul>
				</div>
			</div>
		</nav>
</html>