$(window).load(function(){
console.log(message);
if(msg!=""){
	setTimeout(function() {
	    $('#message').fadeOut('fast');
	}, 1000);
}else{
	 $('#message').hide();
}

});
