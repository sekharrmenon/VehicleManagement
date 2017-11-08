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
<title>Insert title here</title>
</head>
<body>
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

			<c:forEach var="vehicle" items="${vehicles}">
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
                                          onclick="location.href='${updateUrl}'">Update</button>
				  <button class="btn btn-danger"
                                          onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                                </td>
			    </tr>
			</c:forEach>
		</table>

</body>
</html>