$(window).load(function(){
console.log(message);
});

$(document).ready(function() {
	$('.Searchbox_square').click( function() {		
		$(".Searchbox_square").removeClass("selected");
		$(this).addClass("selected");
		$("#vehicleType").val($(this).attr("id"));
	    
	} );
	
});
