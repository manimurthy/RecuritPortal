<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Company</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/style-home.css">
<link rel="stylesheet" href="assets/css/blue.css">

</head>
<body>

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
						<li><a href="searchjob?fromsrch=false" class="current">Search Jobs</a></li>
						<li><a href="likedjobs" class="current">Liked Jobs</a></li>
						<!-- <li><a href="applyjobs" class="current">Apply jobs</a></li> -->
						<li><a href="empappliedjob" class="current">Applied jobs</a></li>						
					</ul>
				</nav>
				<div class="clearfix"></div>				
			</div>
			<!-- Left Side Content / End -->
			<!-- Right Side Content / End -->
			<div class="right-side">					

				<div class="header-widget" style="display: flex; flex-direction: column; ">
				    <div>
				        <a href="editEmployee?empid=${empId}">
				            <i class="icon-material-outline-power-settings-new"></i>${empName}
				        </a> 
				        <input type="hidden" id="firmname" name="firmname" value="${empId}" />
				    </div>
				    <div>
				        <a href="/logout">
				            <i class="icon-material-outline-power-settings-new"></i> Logout
				        </a>
				    </div>
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
		<div class="row">
			<div class="col-md-12">
				<div class="banner-headline">
					<h3>
						<strong>Lorem Ipsum is simply dummy text of the printing..</strong>
						<br>
						<span>Lorem Ipsum has been the industry's standard <strong class="color">Dummy</strong> text ever since the 1500s, when an unknown printer.</span>
					</h3>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Features Jobs -->
<div class="section margin-top-45" id="liked-jobs">
	<div class="container">
		<div class="row">
			<div class="col-xl-12">
				
				<!-- Section Headline -->
				<div class="section-headline margin-top-0 margin-bottom-35">
					<h3>Liked Jobs</h3>					
				</div>
				<div class="col-xl-12">
					<div class="dashboard-box margin-top-0">

						<!-- Headline -->
						<div class="headline">
							<h3><i class="icon-material-outline-business-center"></i> Jobs</h3>
						</div>

						<div class="content">
							<ul class="dashboard-box-list">
							<c:forEach items="${likedJobs}" var="jp">
								<li>
									<!-- Job Listing -->
									<div class="job-listing">

										<!-- Job Listing Details -->
										<div class="job-listing-details">

											<!-- Logo -->
											<a href="#" class="job-listing-company-logo">
												<img src="assets/img/company-logo-01.png" alt=""> 
											</a>

											<!-- Details -->
											<div class="job-listing-description">
												<h3 class="job-listing-title"><a href="#">${jp.jobdesc}</a></h3>
											</div>
										</div>
									</div>
									<!-- Buttons -->
									<div class="buttons-to-right single-right-button">
										<a href="applyjobid?jobpostingid=${jp.jobpostingid}&skillname=${jp.skillname}" class="list-apply-button ripple-effect">Apply Now</a>										
									</div>
								</li>
							</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Featured Jobs / End -->
<div class="section margin-top-45 gray padding-top-65 padding-bottom-75">
	<div class="container">
		<div class="row">
			<div class="col-xl-12">

				<div class="section-headline centered margin-bottom-50">
					<h3>Popular Job</h3>
				</div>

				<!-- Category Boxes Container -->
				<div class="categories-container d-flex align-items-center justify-content-center">
				<!-- Category Box -->
					<a href="jobs-list-layout-1.html" class="category-box">
						<div class="category-box-icon">
							<i class="icon-line-awesome-pencil"></i>
						</div>
						
						<div class="category-box-content">
							<h3>Data Scientist </h3>
							<p>Inviting highly skilled and qualified people for an exciting  opportunity in our company. /p>
						</div>
					</a>

					<!-- Category Box -->
					<a href="jobs-list-layout-2.html" class="category-box">
						<div class="category-box-icon">
							<i class="icon-line-awesome-pie-chart"></i>
						</div>
											
						<div class="category-box-content">
							<h3>Data Engineer</h3>
							<p>Like challenges!  Love to solve complex problems! This is a right place for you. Apply now!</p>
						</div>
					</a>

					<!-- Category Box -->
					<a href="jobs-list-layout-1.html" class="category-box">
						<div class="category-box-icon">
							<i class="icon-line-awesome-image"></i>
						</div>
						
						<div class="category-box-content">
							<h3>Security Analysts </h3>
							<p>We are looking out for candidates having interests in IT security to join our red team.</p>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
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
					© 2024 <strong>Logo</strong>. All Rights Reserved.
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
 </script>
</body>
</html>