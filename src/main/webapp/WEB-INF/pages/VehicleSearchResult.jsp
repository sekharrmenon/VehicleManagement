<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
      .list-panel {background: #f1f1f1;padding: 20px;}
      .flex {display: flex;align-items: center;}
      .flex h4 {margin-top: 0px;}
      .vehicle-container {padding-top: 20px;padding-bottom: 20px;}
      .pre-head {font-size: 16px;font-weight: 400;}
      .underline {margin-top: 10px;border: 1px #f1f1f1 solid;margin-bottom: 20px;}
    </style>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="./Navigation.jsp" />
    <div class="container vehicle-container">
  
    <h4><span class="pre-head">Showing results for </span>${searchParam}</h4>
    <hr class="underline">

      <div class="row">
        
        <!-- repeat -->
        <c:forEach var="vehicle" items="${vehicle}">
         <div class="col-md-6">
          <div class="panel panel-default list-panel">
            <div class="row flex">
              <div class="col-md-4">
              	<c:choose>
    						<c:when test="${vehicle.type=='car'}">
        						                <img src="resources/img/car-icon.png" alt="Vehicle Name">
    						</c:when>
    						<c:when test="${vehicle.type=='bike'}">
        						                <img src="resources/img/bike-icon.png" alt="Vehicle Name">
    						</c:when>
    						<c:when test="${vehicle.type=='truck'}">
        						                <img src="resources/img/truck-icon.png" alt="Vehicle Name">
    						</c:when>
    					<c:otherwise>
        				        				 <img src="resources/img/other-icon.png" alt="Vehicle Name">
    						</c:otherwise>
					</c:choose>

              </div>
              <div class="col-md-8">
                <h4>Vehicle Name : ${vehicle.vehiclename}</h4>
                <p>
                  Make : ${vehicle.brand}<br>
                  Model : ${vehicle.model}<br>
                  Type : ${vehicle.type}
                </p>
              </div> 
            </div>
          </div>
        </div>
        <!-- repeat -->
        
        </c:forEach>
    
    

      </div>



    </div>
  </body>
</html>