
var map;
$(document).ready(function() {
	FnInitiateMap();
	console.log("VehicleList")
	console.log(VehicleList)
	var VarIcon = FnGetMarkerIcon('blue');
	if(VehicleList.length>0){
		for(var i=0;i<VehicleList.length;i++){
			var data="<b>VehicleName</b>:"+VehicleList[0].vehiclename+"<br>"+"<b>VehicleBrand</b>:"+VehicleList[0].brand+"<br>"+"<b>VehicleModel</b>:"+VehicleList[0].model;
			var VarLatitude = parseFloat(VehicleList[i].lattitude);
			var VarLongitude = parseFloat(VehicleList[i].longitude);
			var object={}
			object["latlng"]= {"lat" : VarLatitude,"lng":VarLongitude};
			var geomarker=L.marker(object.latlng,{icon: VarIcon, draggable: false}).addTo(map).bindPopup(data);
			map.setView(new L.LatLng(VarLatitude, VarLongitude),4);

		}
	}
});



function FnInitiateMap() {
	console.log('FnInitiateMap called');
	// var VarZoomLevel = parseInt($('#zoom').val());
	var osmUrl = 'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
	var osmAttrib = 'Map data © <a href="http://openstreetmap.org">OpenStreetMap</a>contributors';

	var osm = new L.TileLayer(osmUrl, {
		minZoom : 1,
		maxZoom : 12,
		attribution : osmAttrib
	});


	map = L.map('geomap', {
		zoom : 8,
		center : [ 25.20, 55.27 ],
		layers : osm,
		zoomControl : true,
		attributionControl : true
	});
	map.zoomControl.setPosition('bottomleft');

	// var baseMaps = {
	// "Satellite": hybrid,
	// "Streets": streets
	// };

	L.control.layers(osm, null, {
		position : 'topleft'
	}).addTo(map);
	
}

function FnGetMarkerIcon(VarColor) {

	var icon = new L.Icon({
		iconUrl : 'resources/leaflet/images/marker-icon.png',
		shadowUrl : 'resources/leaflet/images/marker-shadow.png',
		iconSize : [ 25, 41 ],
		iconAnchor : [ 12, 41 ],
		popupAnchor : [ 1, -34 ],
		shadowSize : [ 41, 41 ]
	});

	return icon;

}