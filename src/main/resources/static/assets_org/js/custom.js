/* ----------------- Start Document ----------------- */
(function($){
"use strict";


$('.logSign button').on('click', function()
{
  $('.logSign button').removeClass('active');
  $(this).addClass('active');
  if ($('#showlogin').hasClass('active'))
  {
      $('main .signup-form').css('display', 'none');
      $('main .login-form').css('display', 'block');

  }
  else
  {
      $('main .signup-form').css('display', 'block');
      $('main .login-form').css('display', 'none');
  }
})

$(document).ready(function()
{
  setTimeout(function()
  {
    $("form .input-field").each(function()
    {
      $(this).addClass('reveal');
    })
  }, 1000)

})








// disable on enter
$('form').on('keyup keypress', function(e) {
    var keyCode = e.keyCode || e.which;
    if (keyCode === 13) { 
      e.preventDefault();
      return false;
    }
  });




  // form validiation
  var inputschecked = false;


  function formvalidate(stepnumber)
  {
    // check if the required fields are empty
    inputvalue = $("#step"+stepnumber+" :input").not("button").map(function()
    {
      if(this.value.length > 0)
      {
        $(this).removeClass('invalid');
        return true;
  
      }
      else
      {
        
        if($(this).prop('required'))
        {
          $(this).addClass('invalid');
          return false
        }
        else
        {
          return true;
        }
        
      }
    }).get();
    
  
    // console.log(inputvalue);
  
    inputschecked = inputvalue.every(Boolean);
  
    // console.log(inputschecked);
  }


$(document).ready(function()
  {

    //email validiation

    var email = $('#mail-email').val();
    var re = /^\w+([-+.'][^\s]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    var emailFormat = re.test(email);

    $('.login').on('click', function()
    {

      formvalidate(1);
                
        
      if(inputschecked == false)
      {
          formvalidate(1);
      }
    })
    $('.signup').on('click', function()
    {

      formvalidate(2);
                
        
      if(inputschecked == false)
      {
          formvalidate(2);
      }
    })
   }
   );




$(document).ready(function(){
	
	/*--------------------------------------------------*/
	/*  Mobile Menu - mmenu.js
	/*--------------------------------------------------*/
	$(function() {
		function mmenuInit() {
			var wi = $(window).width();
			if(wi <= '1099') {

				$(".mmenu-init" ).remove();
				$("#navigation").clone().addClass("mmenu-init").insertBefore("#navigation").removeAttr('id').removeClass('style-1 style-2')
								.find('ul, div').removeClass('style-1 style-2 mega-menu mega-menu-content mega-menu-section').removeAttr('id');
				$(".mmenu-init").find("ul").addClass("mm-listview");
				$(".mmenu-init").find(".mobile-styles .mm-listview").unwrap();


				$(".mmenu-init").mmenu({
				 	"counters": true
				}, {
				 // configuration
				 offCanvas: {
				    pageNodetype: "#wrapper"
				 }
				});

				var mmenuAPI = $(".mmenu-init").data( "mmenu" );
				var $icon = $(".mmenu-trigger .hamburger");

				$(".mmenu-trigger").on('click', function() {
					mmenuAPI.open();
				});

			}
			$(".mm-next").addClass("mm-fullsubopen");
		}
		mmenuInit();
		$(window).resize(function() { mmenuInit(); });
	});


	/*--------------------------------------------------*/
	/*  Sticky Header
	/*--------------------------------------------------*/
	function stickyHeader() {

		$(window).on('scroll load', function() {

			if($(window).width() < '1099') { 
				$("#header-container").removeClass("cloned");
			}
			
			if($(window).width() > '1099') {

				// CSS adjustment
				$("#header-container").css({
					position: 'fixed',
				});
		
				var headerOffset = $("#header-container").height();

				if($(window).scrollTop() >= headerOffset){
					$("#header-container").addClass('cloned');
					$(".wrapper-with-transparent-header #header-container").addClass('cloned').removeClass("transparent-header unsticky");
				} else {
					$("#header-container").removeClass("cloned");
					$(".wrapper-with-transparent-header #header-container").addClass('transparent-header unsticky').removeClass("cloned");
				}

				// Sticky Logo
				var transparentLogo = $('#header-container #logo img').attr('data-transparent-logo');
				var stickyLogo = $('#header-container #logo img').attr('data-sticky-logo');

				if( $('.wrapper-with-transparent-header #header-container').hasClass('cloned')) {
					$("#header-container.cloned #logo img").attr("src", stickyLogo);
				} 

				if( $('.wrapper-with-transparent-header #header-container').hasClass('transparent-header')) {
					$("#header-container #logo img").attr("src", transparentLogo);
				} 

				$(window).on('load resize', function() {
				    var headerOffset = $("#header-container").height();
				    $("#wrapper").css({'padding-top': headerOffset});
				});
			}
		});
	}

	// Sticky Header Init
	stickyHeader();


	/*--------------------------------------------------*/
	/*  Transparent Header Spacer Adjustment
	/*--------------------------------------------------*/
	$(window).on('load resize', function() {
		var transparentHeaderHeight = $('.transparent-header').outerHeight();
		$('.transparent-header-spacer').css({
			height: transparentHeaderHeight,
		});
	});


	/*----------------------------------------------------*/
	/*  Back to Top
	/*----------------------------------------------------*/

	// Button
	function backToTop() {
		$('body').append('<div id="backtotop"><a href="#"></a></div>');
	}
	backToTop();

	// Showing Button
	var pxShow = 600; // height on which the button will show
	var scrollSpeed = 500; // how slow / fast you want the button to scroll to top.

	$(window).scroll(function(){
	 if($(window).scrollTop() >= pxShow){
		$("#backtotop").addClass('visible');
	 } else {
		$("#backtotop").removeClass('visible');
	 }
	});

	$('#backtotop a').on('click', function(){
	 $('html, body').animate({scrollTop:0}, scrollSpeed);
	 return false;
	});
	

	/*--------------------------------------------------*/
	/*  Ripple Effect
	/*--------------------------------------------------*/
	$('.ripple-effect, .ripple-effect-dark').on('click', function(e) {
		var rippleDiv = $('<span class="ripple-overlay">'),
			rippleOffset = $(this).offset(),
			rippleY = e.pageY - rippleOffset.top,
			rippleX = e.pageX - rippleOffset.left;

		rippleDiv.css({
			top: rippleY - (rippleDiv.height() / 2),
			left: rippleX - (rippleDiv.width() / 2),
			// background: $(this).data("ripple-color");
		}).appendTo($(this));

		window.setTimeout(function() {
			rippleDiv.remove();
		}, 800);
	});


	/*--------------------------------------------------*/
	/*  Interactive Effects
	/*--------------------------------------------------*/
	$(".switch, .radio").each(function() {
		var intElem = $(this);
		intElem.on('click', function() {
			intElem.addClass('interactive-effect');
		   setTimeout(function() {
					intElem.removeClass('interactive-effect');
		   }, 400);
		});
	});


	/*--------------------------------------------------*/
	/*  Sliding Button Icon
	/*--------------------------------------------------*/
	$(window).on('load', function() {
		$(".button.button-sliding-icon").not(".task-listing .button.button-sliding-icon").each(function() {
			var buttonWidth = $(this).outerWidth()+30;
			$(this).css('width',buttonWidth);
		});
	});


	/*--------------------------------------------------*/
	/*  Sliding Button Icon
	/*--------------------------------------------------*/
    $('.bookmark-icon').on('click', function(e){
    	e.preventDefault();
		$(this).toggleClass('bookmarked');
	});

    $('.bookmark-button').on('click', function(e){
    	e.preventDefault();
		$(this).toggleClass('bookmarked');
	});


	/*----------------------------------------------------*/
	/*  Notifications Boxes
	/*----------------------------------------------------*/
	$("a.close").removeAttr("href").on('click', function(){
		function slideFade(elem) {
			var fadeOut = { opacity: 0, transition: 'opacity 0.5s' };
			elem.css(fadeOut).slideUp();
		}
		slideFade($(this).parent());
	});

	/*--------------------------------------------------*/
	/*  Notification Dropdowns
	/*--------------------------------------------------*/
	$(".header-notifications").each(function() {
		var userMenu = $(this);
		var userMenuTrigger = $(this).find('.header-notifications-trigger a');

		$(userMenuTrigger).on('click', function(event) {
			event.preventDefault();

			if ( $(this).closest(".header-notifications").is(".active") ) {
	            close_user_dropdown();
	        } else {
	            close_user_dropdown();
	            userMenu.addClass('active');
	        }
		});
	});

	// Closing function
    function close_user_dropdown() {
		$('.header-notifications').removeClass("active");
    }

    // Closes notification dropdown on click outside the conatainer
	var mouse_is_inside = false;

	$( ".header-notifications" ).on( "mouseenter", function() {
	  mouse_is_inside=true;
	});
	$( ".header-notifications" ).on( "mouseleave", function() {
	  mouse_is_inside=false;
	});

	$("body").mouseup(function(){
	    if(! mouse_is_inside) close_user_dropdown();
	});

	// Close with ESC
	$(document).keyup(function(e) { 
		if (e.keyCode == 27) {
			close_user_dropdown();
		}
	});


	/*--------------------------------------------------*/
	/*  User Status Switch
	/*--------------------------------------------------*/
	if ($('.status-switch label.user-invisible').hasClass('current-status')) {
		$('.status-indicator').addClass('right');
	}

	$('.status-switch label.user-invisible').on('click', function(){
		$('.status-indicator').addClass('right');
		$('.status-switch label').removeClass('current-status');
		$('.user-invisible').addClass('current-status');
	});

	$('.status-switch label.user-online').on('click', function(){
		$('.status-indicator').removeClass('right');
		$('.status-switch label').removeClass('current-status');
		$('.user-online').addClass('current-status');
	});


	/*--------------------------------------------------*/
	/*  Full Screen Page Scripts
	/*--------------------------------------------------*/

	// Wrapper Height (window height - header height)
	function wrapperHeight() {
		var headerHeight = $("#header-container").outerHeight();
		var windowHeight = $(window).outerHeight() - headerHeight;
		$('.full-page-content-container, .dashboard-content-container, .dashboard-sidebar-inner, .dashboard-container, .full-page-container').css({ height: windowHeight });
		$('.dashboard-content-inner').css({ 'min-height': windowHeight });
	}

	// Enabling Scrollbar
	function fullPageScrollbar() {
		$(".full-page-sidebar-inner, .dashboard-sidebar-inner").each(function() {

			var headerHeight = $("#header-container").outerHeight();
			var windowHeight = $(window).outerHeight() - headerHeight;
			var sidebarContainerHeight = $(this).find(".sidebar-container, .dashboard-nav-container").outerHeight();

			// Enables scrollbar if sidebar is higher than wrapper
			if (sidebarContainerHeight > windowHeight) {
				$(this).css({ height: windowHeight });
		
			} else {
				$(this).find('.simplebar-track').hide();
			}
		});
	}

	// Init
	$(window).on('load resize', function() {
		wrapperHeight();
		fullPageScrollbar();
	});
	wrapperHeight();
	fullPageScrollbar();

	// Sliding Sidebar 
	$('.enable-filters-button').on('click', function(){
		$('.full-page-sidebar').toggleClass("enabled-sidebar");
		$(this).toggleClass("active");
		$('.filter-button-tooltip').removeClass('tooltip-visible');
	});

	/*  Enable Filters Button Tooltip */
	$(window).on('load', function() {
		$('.filter-button-tooltip').css({
			left: $('.enable-filters-button').outerWidth() + 48
		})
		.addClass('tooltip-visible');
	});

	// Avatar Switcher
	function avatarSwitcher() {
	    var readURL = function(input) {
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();

	            reader.onload = function (e) {
	                $('.profile-pic').attr('src', e.target.result);
	            };
	    
	            reader.readAsDataURL(input.files[0]);
	        }
	    };
	   
	    $(".file-upload").on('change', function(){
	        readURL(this);
	    });
	    
	    $(".upload-button").on('click', function() {
	       $(".file-upload").click();
	    });
	} avatarSwitcher();


	/*----------------------------------------------------*/
	/* Dashboard Scripts
	/*----------------------------------------------------*/

	// Dashboard Nav Submenus
    $('.dashboard-nav ul li a').on('click', function(e){
		if($(this).closest("li").children("ul").length) {
			if ( $(this).closest("li").is(".active-submenu") ) {
	           $('.dashboard-nav ul li').removeClass('active-submenu');
	        } else {
	            $('.dashboard-nav ul li').removeClass('active-submenu');
	            $(this).parent('li').addClass('active-submenu');
	        }
	        e.preventDefault();
		}
	});


	// Responsive Dashbaord Nav Trigger
    $('.dashboard-responsive-nav-trigger').on('click', function(e){
    	e.preventDefault();
		$(this).toggleClass('active');

		var dashboardNavContainer = $('body').find(".dashboard-nav");

		if( $(this).hasClass('active') ){
			$(dashboardNavContainer).addClass('active');
		} else {
			$(dashboardNavContainer).removeClass('active');
		}

		$('.dashboard-responsive-nav-trigger .hamburger').toggleClass('is-active');

	});

	// Fun Facts
	function funFacts() {
		/*jslint bitwise: true */
		function hexToRgbA(hex){
		    var c;
		    if(/^#([A-Fa-f0-9]{3}){1,2}$/.test(hex)){
		        c= hex.substring(1).split('');
		        if(c.length== 3){
		            c= [c[0], c[0], c[1], c[1], c[2], c[2]];
		        }
		        c= '0x'+c.join('');
		        return 'rgba('+[(c>>16)&255, (c>>8)&255, c&255].join(',')+',0.07)';
		    }
		}

		$(".fun-fact").each(function() {
			var factColor = $(this).attr('data-fun-fact-color');

	        if(factColor !== undefined) {
	        	$(this).find(".fun-fact-icon").css('background-color', hexToRgbA(factColor));
	            $(this).find("i").css('color', factColor);
	        }
		});

	} funFacts();


	// Notes & Messages Scrollbar
	$(window).on('load resize', function() {
		var winwidth = $(window).width();
		if ( winwidth > 1199) {

			// Notes
			$('.row').each(function() {
				var mbh = $(this).find('.main-box-in-row').outerHeight();
				var cbh = $(this).find('.child-box-in-row').outerHeight();
				if ( mbh < cbh ) {
					var headerBoxHeight = $(this).find('.child-box-in-row .headline').outerHeight();
					var mainBoxHeight = $(this).find('.main-box-in-row').outerHeight() - headerBoxHeight + 39;

					$(this).find('.child-box-in-row .content')
							.wrap('<div class="dashboard-box-scrollbar" style="max-height: '+mainBoxHeight+'px" data-simplebar></div>');
				}
			});

			// Messages Sidebar
			// var messagesList = $(".messages-inbox").outerHeight();
			// var messageWrap = $(".message-content").outerHeight();
			// if ( messagesList > messagesWrap) {
			// 	$(messagesList).css({
			// 		'max-height': messageWrap,
			// 	});
			// }
		}
	});

	// Mobile Adjustment for Single Button Icon in Dashboard Box
	$('.buttons-to-right').each(function() {
		var btr = $(this).width();
		if (btr < 36) {
			$(this).addClass('single-right-button');
		}
	});

	// Small Footer Adjustment
	$(window).on('load resize', function() {
		var smallFooterHeight = $('.small-footer').outerHeight();
		$('.dashboard-footer-spacer').css({
			'padding-top': smallFooterHeight + 45
		});
	});


	// Auto Resizing Message Input Field
    /* global jQuery */
	jQuery.each(jQuery('textarea[data-autoresize]'), function() {
		var offset = this.offsetHeight - this.clientHeight;

		var resizeTextarea = function(el) {
		    jQuery(el).css('height', 'auto').css('height', el.scrollHeight + offset);
		};
		jQuery(this).on('keyup input', function() { resizeTextarea(this); }).removeAttr('data-autoresize');
	});



	


	/*----------------------------------------------------*/
	/*  Inline CSS replacement for backgrounds
	/*----------------------------------------------------*/
	function inlineBG() {

		// Common Inline CSS
		$(".single-page-header, .intro-banner").each(function() {
			var attrImageBG = $(this).attr('data-background-image');

	        if(attrImageBG !== undefined) {
	        	$(this).append('<div class="background-image-container"></div>');
	            $('.background-image-container').css('background-image', 'url('+attrImageBG+')');
	        }
		});

	} inlineBG();

	// Fix for intro banner with label
	$(".intro-search-field").each(function() {
		var bannerLabel = $(this).children("label").length;
		if ( bannerLabel > 0 ){
		    $(this).addClass("with-label");
		}
	});





	// Link to Register Tab
	$('.register-tab').on('click', function(event) {
		event.preventDefault();
		$(".popup-tab-content").hide();
		$("#register.popup-tab-content").show();
		$("body").find('.popup-tabs-nav a[href="#register"]').parent("li").click();
	});

	// Disable tabs if there's only one tab
	$('.popup-tabs-nav').each(function() {
		var listCount = $(this).find("li").length;
		if ( listCount < 2 ) {
			$(this).css({
				'pointer-events': 'none'
			});
		}
	});


  


// ------------------ End Document ------------------ //
});

})(this.jQuery);

