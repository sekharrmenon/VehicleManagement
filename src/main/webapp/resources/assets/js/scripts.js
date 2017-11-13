jQuery(document).ready(function() {
	
   new WOW().init();
    
    /*
        Search form
    */
    $('.navbar-search-button .search-button').on('click', function(e){
    	e.preventDefault();
    	$(this).blur();
    	$('.navbar-header, .navbar-menu-items, .navbar-search-form').toggleClass('disabled');
    	$('.navbar-search-form input.search').val('').focus();
    });
	
});