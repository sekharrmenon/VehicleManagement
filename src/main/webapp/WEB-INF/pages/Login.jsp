<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
<div id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<spring:url value="/login" var="authenticateUrl" />
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Login to Your Account</h1><br>
				  <form:form class="form-horizontal" action="${authenticateUrl}" method="POST" modelAttribute="loginForm">				  	
				<spring:bind path="username">
			      <div class="form-group ${status.error ? 'has-error' : ''}">
			      <div class="controls">
			        <form:input  type="text" id="username" path="username" name="username" placeholder="Username" class="input-xlarge"/>
			        <form:errors path="username" class="control-label" />
			      </div>
			      </div>
			      </spring:bind>
			<spring:bind path="password">
			      <div class="form-group ${status.error ? 'has-error' : ''}">
			      <div class="controls">
			       <form:password id="password" path="password" name="password" placeholder="Password" class="input-xlarge"/>
			        <form:errors path="password" class="control-label" />
			      </div>
			      </div>
			   </spring:bind>
					<input type="submit" name="login" class="login loginmodal-submit">
				  </form:form>
				</div>
			</div>
	</div>
<!-- <div class="container"> -->
<%-- <spring:url value="/login" var="authenticateUrl" /> --%>
<!--     <div class="row"> -->
<!-- 		<div class="span12"> -->
<%-- 			<form:form class="form-horizontal" action="${authenticateUrl}" method="POST" modelAttribute="loginForm">			 --%>
<!-- 			  <fieldset> -->
<!-- 			    <div id="legend"> -->
<!-- 			      <legend class="">Login</legend> -->
<!-- 			    </div> -->
<!-- 			    <div class="control-group"> -->
<!-- 			      Username -->
<%-- 			      <spring:bind path="username"> --%>
<%-- 			      <div class="form-group ${status.error ? 'has-error' : ''}"> --%>
<!-- 			      <label class="control-label"  for="username">Username</label> -->
<!-- 			      <div class="controls"> -->
<%-- 			        <form:input  type="text" id="username" path="username" name="username" placeholder="" class="input-xlarge"/> --%>
<%-- 			        <form:errors path="username" class="control-label" /> --%>
<!-- 			      </div> -->
<!-- 			      </div> -->
<%-- 			      </spring:bind> --%>
<!-- 			    </div> -->
<!-- 			    <div class="control-group"> -->
<%-- 			    <spring:bind path="password"> --%>
<!-- 			      Password -->
<!-- 			      <label class="control-label" for="password">Password</label> -->
<%-- 			      <div class="form-group ${status.error ? 'has-error' : ''}"> --%>
<!-- 			      <div class="controls"> -->
<%-- 			       <form:password id="password" path="password" name="password" placeholder="" class="input-xlarge"/> --%>
<%-- 			        <form:errors path="password" class="control-label" /> --%>
<!-- 			      </div> -->
<!-- 			      </div> -->
<%-- 			   </spring:bind> --%>
<!-- 			    </div> -->
<!-- 			    <div class="control-group"> -->
<!-- 			      Button -->
<!-- 			      <div class="controls"> -->
<!-- 			        <button class="btn btn-success" type="submit">Login</button> -->
<!-- 			      </div> -->
<!-- 			    </div> -->
<!-- 			  </fieldset> -->
<%-- 			</form:form> --%>
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->
</body>
		<script src="resources/js/jquery-1.11.1.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</html>