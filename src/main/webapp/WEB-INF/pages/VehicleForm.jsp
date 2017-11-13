<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/leaflet/leaflet.css">
</head>
<body>
<jsp:include page="./Navigation.jsp" />
<div class="container">

	<c:choose>
			  <c:when test="${vehicleForm.id==null}">
			<h1 class="pt50">Add Vehicle</h1>
		</c:when>
		<c:otherwise>
			<h1 class="pt50">Update Vehicle</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/newVehicle" var="vehicleActionUrl" />

	<form:form class="form-horizontal" method="post"
                modelAttribute="vehicleForm" action="${vehicleActionUrl}">
                
                <div class="col-md-6">
                	<form:hidden path="id" />
		<form:hidden path="lattitude" id="lattitude"/>
		<form:hidden path="longitude" id="longitude"/>

		<spring:bind path="vehiclename">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			
			<div class="col-sm-12">
				<form:input path="vehiclename" type="text" class="form-control"
                                id="vehiclename" placeholder="VehicleName" />
				<form:errors path="vehiclename" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="brand">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<div class="col-sm-12">
				<form:input path="brand" class="form-control"
                                id="brand" placeholder="Brand" />
				<form:errors path="brand" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="model">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<div class="col-sm-12">
				<form:input path="model"  class="form-control"
                                id="model" placeholder="Model" />
				<form:errors path="model" class="control-label" />
			</div>
		  </div>
		</spring:bind>


		<spring:bind path="type">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<div class="col-sm-12 left">
				<label class="radio-inline">
                                  <form:radiobutton path="type" value="car"  /> Car
				</label>
                                <label class="radio-inline">
                                  <form:radiobutton path="type" value="bike" /> Bike
				</label>
				                                <label class="radio-inline">
                                  <form:radiobutton path="type" value="truck" /> Heavy Vehicle
				</label>
				<label class="radio-inline">
                                  <form:radiobutton path="type" value="other" /> Others
				</label> <br />
				<form:errors path="type" class="control-label" />
			</div>
		  </div>
		</spring:bind>	
                </div>
                <div class="col-md-6">
                	<div class="form-group">
						<div class="col-md-12">
							<jsp:include page="./getTagTemplate.jsp" />
						</div>
					</div>
                </div>
                <div class="col-md-12">
	                <div class="form-group">
					  <div class="col-sm-offset-2 col-sm-10">
						<c:choose>
						  <c:when test="${vehicleForm.id==null}">
						     <button type="submit" class="btn-lg btn-primary pull-right">Add Vehicle
			                             </button>
						  </c:when>
						  <c:otherwise>
						     <button type="submit" class="btn-lg btn-primary pull-right">Update Vehicle
			                             </button>
						  </c:otherwise>
						</c:choose>
					  </div>
					</div>
                </div>
               
	
	</form:form>

</div>
</body>
<script src="resources/leaflet/leaflet.js"></script>
<script>
FnInitiateMap();
FnReDrawFields();
</script>
</html>