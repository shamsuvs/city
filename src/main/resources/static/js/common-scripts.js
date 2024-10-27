var Script = function () {


//    tool tips

    $('.tooltips').tooltip();

//    popovers

    $('.popovers').popover();

//    bxslider

    // $('.bxslider').show();
    // $('.bxslider').bxSlider({
    //     minSlides: 4,
    //     maxSlides: 4,
    //     slideWidth: 276,
    //     slideMargin: 20
    // });

}();

	(function() {

   			$('<i id="back-to-top"></i>').appendTo($('body'));

			$(window).scroll(function() {

				if($(this).scrollTop() != 0) {
					$('#back-to-top').fadeIn();	
				} else {
					$('#back-to-top').fadeOut();
				}

			});
			
			$('#back-to-top').click(function() {
				$('body,html').animate({scrollTop:0},600);
			});	

	})();


function processAjaxForm(_url, element, _data) {
    $.ajax({
        type: "POST",
        data: _data,
        url: _url,
        //  processData: false,
        // dataType: 'json',
        //contentType: false,
        success: function (data) {
            $("#"+element).text(data);
        },
        error: function (data) {
            $("#"+element).innerHTML=data.message;
        }
    });
}