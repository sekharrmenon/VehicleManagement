"use strict";
var ArrPolyMarkers = [];
var clickCircle;

$(document).ready(function() {
	console.log('getTagTemplate js called');

	map.on('click', function(e) {
		// if(GblEdit==1){ return false; }
		var VarIcon = FnGetMarkerIcon('blue');
		if (ArrPolyMarkers.length == 0) {
			var geomarker = L.marker(e.latlng, {
				icon : VarIcon,
				draggable : false
			}).addTo(map);
			ArrPolyMarkers.push(geomarker);
			console.log(ArrPolyMarkers);
			var c = e.latlng;
			var fc = ArrPolyMarkers[0].getLatLng();
			var dis = fc.distanceTo(c);
			// var ObjCircleOptions = FnGetStyleProperties();
			clickCircle = L.circle(fc, dis, null).addTo(map);
			$('#gllpLatitude').val(fc.lat);
			$('#lattitude').val(fc.lat);
			$('#gllpLongitude').val(fc.lng);
			$('#longitude').val(fc.lat);
		} else if (ArrPolyMarkers.length != 0) {
			for (var i = 0; i < ArrPolyMarkers.length; i++) {
				map.removeLayer(ArrPolyMarkers[i]);
			}
			ArrPolyMarkers = [];
			var geomarker = L.marker(e.latlng, {
				icon : VarIcon,
				draggable : true
			}).addTo(map);
			var c = e.latlng
			ArrPolyMarkers.push(geomarker);
			var fc = ArrPolyMarkers[0].getLatLng();
			var dis = fc.distanceTo(c);
			//var dis = $('#radius').val() * 1000;
			clickCircle = L.circle(fc, dis, null).addTo(map);
			$('#gllpLatitude').val(fc.lat);
			$('#gllpLongitude').val(fc.lng);
			if (clickCircle != undefined) {
				map.removeLayer(clickCircle);
			}
		}
	});

	map.on('zoomend', function(e) {
		// if(GblEdit==1){ return false; }
		var VarZoomVal = map.getZoom();
		$('#gllpZoom').val(VarZoomVal);
	});

});

var map = null;
var streets;
var hybrid;
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


	map = L.map('vehicleGeoMap', {
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

function FnDragEvent(e) {
	var marker = e.target;
	var position = marker.getLatLng();
	marker.setLatLng(new L.LatLng(position.lat, position.lng),{draggable:'true'});
	map.panTo(new L.LatLng(position.lat, position.lng))
		$('#gllpLatitude').val(position.lat);
		$('#lattitude').val(position.lat);
		$('#gllpLongitude').val(position.lng);
		$('#longitude').val(position.lat);
}

// Map windows toggle actions ****************

function FnShowTags() {
	$("#tag-wrapper").slideToggle();

	setTimeout(function() {
		$(".gllpLatlonPicker").each(function() {
			$(document).gMapsLatLonPicker().init($(this));
		});
	}, 1000);
}

document.addEventListener('DOMContentLoaded', function() {
	// setTimeout(function() {
	// $(".gllpLatlonPicker").each(function() {
	// $(document).gMapsLatLonPicker().init( $(this) );
	// });
	// }, 1000);

	$('#add-geo-tag').on('click', function() {
		var var_lat = $("#gllpLatitude").val();
		var var_long = $("#gllpLongitude").val();
		//var_lat = precise_round(var_lat, 4);
		//var_long = precise_round(var_long, 4);
		
		var_lat = round(var_lat,4);
		var_long = round(var_long,4);
		//alert(var_lat+' /'+ var_long);
		$('#tag-latitude').val(var_lat);
		$('#tag-longitude').val(var_long);

		// $('#tag-latitude-display-value').html(lat);
		// $('#tag-longitude-display-value').html(long);
		var VarLatLongDisplay = round(var_lat,5) + ' , ' + round(var_long,5) + ' ';
		

		$('#tag-latitude-longitude-display-value').html(VarLatLongDisplay);
	});

	$('#clear-geo-tag').on('click', function() {
		$('#tag-latitude').val('');
		$('#tag-longitude').val('');
		// $('#tag-latitude-display-value').html('n/a');
		// $('#tag-longitude-display-value').html('n/a');

		$('#tag-latitude-longitude-display-value').html('');
	});
});

function FnReDrawFields(){
	var lat=$('#lattitude').val();
	console.log("lat"+lat);
	var long=$('#longitude').val();
	console.log("long"+long);
	if(lat!="" && long!=""){
		var VarLatitude = parseFloat($('#lattitude').val());
		var VarLongitude = parseFloat($('#longitude').val());
		var object={}
		object["latlng"]= {"lat" : VarLatitude,"lng":VarLongitude};
		var VarIcon = FnGetMarkerIcon('blue');
		var geomarker=L.marker(object.latlng,{icon: VarIcon, draggable: true}).addTo(map);
		ArrPolyMarkers.push(geomarker);	
		var c = object.latlng;	
		var fc = ArrPolyMarkers[0].getLatLng();		
		var dis = fc.distanceTo(c);
		clickCircle = L.circle(fc, dis, null).addTo(map);
		map.setView(new L.LatLng(VarLatitude, VarLongitude),4);
	}
	
	$('#gllpLatitude').val(VarLatitude);
	$('#gllpLongitude').val(VarLongitude);
}

