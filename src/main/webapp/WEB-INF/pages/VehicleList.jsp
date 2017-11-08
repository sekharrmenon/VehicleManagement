<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page="./Navigation.jsp" />
<div class="container">
		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
<h1>All Vehicle</h1>
<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Vehicle Name</th>
					<th>Brand</th>
					<th>Model</th>
					<th>Type</th>
				</tr>
			</thead>

			<c:forEach var="vehicle" items="${vehicle}">
			    <tr>
				<td>
					${vehicle.id}
				</td>
				<td>${vehicle.vehiclename}</td>
				<td>${vehicle.brand}</td>
				<td>${vehicle.model}</td>
				<td>${vehicle.type}</td>
				<td>
				  <spring:url value="/vehicle/${vehicle.id}" var="viewUrl" />
				  <spring:url value="/vehicle/${vehicle.id}/delete" var="deleteUrl" />
				  <spring:url value="/vehicle/${vehicle.id}/update" var="updateUrl" />

				  <button class="btn btn-info"
                                          onclick="location.href='${viewUrl}'">View</button>
				  <button class="btn btn-primary"
                                          onclick="location.href=('${updateUrl}');this.disabled=true">Update</button>
				  <button class="btn btn-danger"
                                           onclick="location.href=('${deleteUrl}');this.disabled=true">Delete</button>
                                </td>
			    </tr>
			</c:forEach>
		</table>
</div>
</body>
</html>