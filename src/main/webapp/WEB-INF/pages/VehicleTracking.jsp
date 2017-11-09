<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
var VehicleList=${allVehicles};
</script>
<style>
.full-width-div {
    position: absolute;
    width: 100%;
    left: 0;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/leaflet/leaflet.css">
</head>
<body>
<jsp:include page="./Navigation.jsp" />
<div class="container">
    <div class="row">
        <div class="col-md-12">
            ...
            <div class="full-width-div">
            <section id="geomap"  style="width:100%; height:660px"></section>
            </div>
        </div>
    </div>
</div>
</body>
<script src="resources/leaflet/leaflet.js"></script>
  <script src="resources/js/vehicletracking.js"></script>
</html>