<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>

<title>Company</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/style-home.css">
<link rel="stylesheet" href="assets/css/blue.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	#accordionContainer{display:none;padding:10px 0;margin-top:10px}
   .job-listing h3.job-listing-title{color:#fff}
   ul.dashboard-box-list>li:hover{background-color:transparent}
   ul.dashboard-box-list>li:hover .list-apply-button{box-shadow:none;background-color:#2a41e8;color:#000}
   .buttons-to-right,.dashboard-box-list .button.to-right{opacity:1;box-shadow:none;background-color:transparent}
   table{font-family:arial,sans-serif;border-collapse:collapse;width:100%}
   th{    background: #fff;
	   color: #000;
	   border: 1px solid #000 !important;}
   td{color:#fff}
   td,th{border:1px solid #fff;text-align:left;padding:8px}
   ul.dashboard-box-list > li{border: 0;}
   .dashboard-box .button.ico i{    color: #dc3139;}
   .dashboard-box .button.red {
	   background-color: #fff;
	   box-shadow: none;
   }
   </style>
</head>
<body onload="showAlert('${info}')">

<!-- Wrapper -->
<div id="wrapper">

<!-- Header Container
================================================== -->
<header id="header-container" class="fullwidth">

	<!-- Header -->
	<div id="header">
		<div class="container">
			
			<!-- Left Side Content -->
			<div class="left-side">
				
				<!-- Logo -->
				<div id="logo">
					<a href="home.html"><img src="assets/img/logo.png" alt=""></a>
				</div>

				<!-- Main Navigation -->
				<nav id="navigation">
					<ul id="responsive">
						<li><a href="postjob" class="current">Post Jobs</a></li>
						<li><a href="searchalljobsfirm" class="current">Posted Job</a></li>
					</ul>
				</nav>
				<div class="clearfix"></div>				
			</div>
			<!-- Left Side Content / End -->
			<!-- Right Side Content / End -->
			<div class="right-side">					
				<div class="header-widget" style="display: flex; flex-direction: column; ">
				    <div>
				        <a>
				            <i class="fa fa-user" aria-hidden="true"></i>
								${firmname}
				        </a> 
				        <input type="hidden" id="firmname" name="firmname" value="${firmid}" />
				    </div>
				    <div>
				        <a href="/logout">
				            Logout
				        </a>
				    </div>				
				<!-- Mobile Navigation Button -->
				<span class="mmenu-trigger">
					<button class="hamburger hamburger--collapse" type="button">
						<span class="hamburger-box">
							<span class="hamburger-inner"></span>
						</span>
					</button>
				</span>

			</div>
			<!-- Right Side Content / End -->
		</div>
	</div>
	<!-- Header / End -->

</header>
<div class="clearfix"></div>
<!-- Header Container / End -->



<!-- Intro Banner
================================================== -->
<!-- add class "disable-gradient" to enable consistent background overlay -->
<div class="intro-banner" data-background-image="assets/img/home-background.jpg">
	<div class="container">
		
		<!-- Intro Headline -->
	</div>
</div>

<!-- Features Jobs -->
<div class="section margin-top-45" id="search-jobs">
	<div class="container">
		<div class="row">
			<div class="col-xl-12">
				
				<!-- Section Headline -->
				<div class="section-headline margin-top-0 margin-bottom-35">
					<h3>Posted Jobs</h3>					
				</div>
				<div class="col-xl-12">
					<div class="dashboard-box margin-top-0 jb-head">
						<div class="headline">
							<h3> Posted Jobs Table</h3>
						</div>
						<div class="content p-5">
							<table>
								<tr>
								  <th width="20%">Job Post</th>
								  <th width="40%">Job Detail</th>
								  <th width="15%">Job Date</th>
								  <th width="35%">Status</th>										  
								</tr>



							
								<c:forEach items="${firmJobPosted}" var="jp">

								<tr>
									<td><c:out value= "${jp.jobtitle}" /></td>
									<td><c:out value= "${jp.jobdesc}" /></td>
									<td><c:out value= "${jp.applybydate}" /></td>
									<td style="display: flex;">
									  
										<a href="clacweightscore?jobpostingid=${jp.jobpostingid}" class="list-apply-button ripple-effect">Calculate Weightage</a>
										<a href="firmappliedjob?jobpostingid=${jp.jobpostingid}" class="list-apply-button ripple-effect">View Applications</a>
									  
									</td>
								  </tr>
								
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
				
				

			</div>
		</div>
	</div>
</div>
<!-- Featured Jobs / End -->




<!-- Featured Jobs / End -->
<div class="section margin-top-45 gray padding-top-65 padding-bottom-75">
	
</div>
<!-- Category Boxes / End -->





<!-- Footer
================================================== -->
<div id="footer">
	

	
	<!-- Footer Copyrights -->
	<div class="footer-bottom-section">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					� 2024 <strong>Logo</strong>. All Rights Reserved.
				</div>
			</div>
		</div>
	</div>
	<!-- Footer Copyrights / End -->

</div>
<!-- Footer / End -->

</div>


<script src="assets/js/jquery-3.6.1.min.js"></script>
<script src="assets/js/mmenu.min.js"></script>
<script src="assets/js/simplebar.min.js"></script>
<script src="assets/js/magnific-popup.min.js"></script>
<script src="assets/js/custom.js"></script>

<script>
	$(document).ready(function() {
	   $('#responsive  li a[href^="#"]').on('click', function(event) {
		  var target = $($(this).attr('href'));
		  if (target.length) {
			 event.preventDefault();
			 var scrollPosition = $(window).scrollTop();
			 var scrollDistance = target.offset().top - scrollPosition;
			 $('html, body').animate({
				scrollTop: scrollDistance
			 }, 800);
		  }
	   });
	});
	
    function showAlert(message) {
   	 if (message.trim() !== '') {
            alert(message);
        }
   }	
 </script>
</body>
</html>