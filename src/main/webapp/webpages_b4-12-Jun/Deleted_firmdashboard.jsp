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
						<li><a href="#search-jobs" class="current">Search Jobs</a></li>
						<li><a href="#post-jobs" class="current">Post Jobs</a></li>
					</ul>
				</nav>
				<div class="clearfix"></div>				
			</div>
			<!-- Left Side Content / End -->
			<!-- Right Side Content / End -->
			<div class="right-side">					

				<div class="header-widget">
					<a href="/logout"><i class="icon-material-outline-power-settings-new"></i> Logout</a>
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
<div class="section margin-top-45" id="search-jobs">

	<div class="container">
		<div class="row">
			<div class="col-xl-12">
				
				<!-- Section Headline -->
				<div class="section-headline margin-top-0 margin-bottom-35">
					<h3>Search Jobs</h3>					
				</div>
				<div class="col-xl-12">
					<div class="dashboard-box margin-top-0 jb-head">
						<div class="row">
						<!-- <form action="/searchjob" method="post"> -->
							<div class="col-md-12 p-5 pb-0 pt-4">
									<div class="row">
										<div class="col-xl-4">
											<div class="submit-field mb-3">
												<h5>Job ID</h5>
												<input type="text" id ="jobId" name ="jobId" class="with-border">
											</div>
										</div>
			
										<div class="col-xl-4">
											<div class="submit-field mb-3">
												<h5>Job Status</h5>
												<input type="text" id = "jobDesc"  name = "jobDesc" class="with-border">
											</div>
										</div>
										
										<div class="col-xl-3">
											<!-- <a href="#" class="button ripple-effect big margin-top-30"><i class="icon-feather-plus"></i> Search Jobs</a> -->
											<button type="submit" class="button ripple-effect big margin-top-30">Search</button>
											
										</div>
									</div>
							</div>
							<!-- </form> -->
						</div>
						

						<div class="content">
							<span> This is the JobPost Return value ${jobPost} </span>
							<ul class="dashboard-box-list">
								<li>
						    <c:forEach var="i" begin="1" end="5">
						        <p>Hello</p>
						    </c:forEach>								
								    <c:forEach items="${jobPost}" var="jp">
								    <p>INSDIE CLOOP</p>
								        <!-- Job Listing -->
								        <div class="job-listing">
								            <!-- Job Listing Details -->
								            <div class="job-listing-details">
								                <!-- Logo -->
								                <!-- Details -->
								                <div class="job-listing-description">
								                    <h3 class="job-listing-title">
								                        <!-- Correct the query string syntax and close the 'a' tag properly -->
								                        <a href="/applyjob">WHAT THE HELL!!!<c:out value= "${jp.jobtitle}" /></a>
								                    </h3>
								                    <p>${jp.jobdesc}</p> <!-- Displaying job description -->
								                </div>
								            </div>
								        </div>
								        <!-- Buttons -->
								        <div class="buttons-to-right single-right-button">
								            <!-- Use dynamic jobpostingId in the link to apply to make it functional -->
								            <a href="/applyjob" class="list-apply-button ripple-effect">Apply Now</a>
								        </div>
								    </c:forEach>
								</li> 							
								<li>
									<!-- Job Listing -->
									<div class="job-listing">

										<!-- Job Listing Details -->
										<div class="job-listing-details">

											<!-- Logo -->
											<a href="#" class="job-listing-company-logo">
												<img src="assets/img/company-logo-02.png" alt="">
											</a>


											<!-- Details -->
											<div class="job-listing-description">
												<h3 class="job-listing-title"><a href="#">Administrative Assistant</a></h3>

												<!-- Job Listing Footer -->
												
											</div>

										</div>
									</div>

									<!-- Buttons -->
									<div class="buttons-to-right single-right-button">
										
										<a href="#" class="list-apply-button ripple-effect">Apply Now</a>
									</div>
								</li>

								<li>
									<!-- Job Listing -->
									<div class="job-listing">

										<!-- Job Listing Details -->
										<div class="job-listing-details">

											<!-- Logo -->
											<a href="#" class="job-listing-company-logo">
												<img src="assets/img/company-logo-03.png" alt="">
											</a>

											<!-- Details -->
											<div class="job-listing-description">
												<h3 class="job-listing-title"><a href="#">Construction Labourers</a></h3>

												<!-- Job Listing Footer -->
												
											</div>
										</div>
									</div>

									<!-- Buttons -->
									<div class="buttons-to-right single-right-button">
										
										<a href="#" class="list-apply-button ripple-effect">Apply Now</a>
									</div>
								</li>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Featured Jobs / End -->


<div id="post-jobs" class="section margin-top-65 gray padding-top-65 padding-bottom-75">
<form action="/savejobdetails" method="post">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Section Headline -->
				<div class="section-headline margin-top-0 margin-bottom-35">
					<h3>Post Jobs</h3>					
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Dashboard Box -->
			<div class="col-xl-12">
				<div class="dashboard-box margin-top-0">
					<!-- Headline -->
					<div class="headline">
						<h3><i class="icon-feather-folder-plus"></i> Job Submission Form</h3>
					</div>

					<div class="content with-padding padding-bottom-10">
						<div class="row">
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Unique Handle</h5>
									<input type="text" id = "firmunqid" name = "firmunqid" class="with-border" />
								</div>
							</div>

							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Job Title</h5>
									<input type="text" id = "jobtitle" name = "jobtitle" class="with-border" />
								</div>
							</div>

							<!-- <div class="col-xl-4">
								<div class="submit-field">
									<h5>Job Desc</h5>
									<!-- <input type="text" name = "jobdesc" class="with-border" /> 
 									<textarea cols="30" rows="5" class="with-border"></textarea>
								</div>
							</div>-->

							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Department</h5>
									<input type="text" id = "dept" name = "dept" class="with-border" />
								</div>
							</div>

							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Admin in charge </h5>
									<input type="text" id = "admin_in_charge" name = "admin_in_charge" class="with-border" />
								</div>
							</div>

							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Apply by date </h5>
									<input type="date" id = "applybydate" name ="applybydate" class="with-border" />
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Years of Experience required </h5>
									<input type="text" id = "yearsofexp" name ="yearsofexp" class="with-border" />
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Exp. Weightage</h5>
									<input type="text" id ="expweightpercent"  name ="expweightpercent" class="with-border" />
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Edu. Weightage</h5>
									<input type="text" id = "eduweightpercent" name ="eduweightpercent" class="with-border" />
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Exp. Skills Weightage</h5>
									<input type="text" id = "expskills" name ="expskills" class="with-border" />
								</div>
							</div>
														
							<div class="col-xl-12">
								<div class="submit-field">
									<h5>Job Description</h5>
									<textarea id = "jobdesc" name="jobdesc" cols="30" rows="5" class="with-border"></textarea>
									<div class="uploadButton margin-top-30">
										<input class="uploadButton-input" type="file" accept="image/*, application/pdf" id="upload" multiple="" />
										<label class="uploadButton-button ripple-effect" for="upload">Upload Files</label>
										<span class="uploadButton-file-name">Images or documents that might be helpful in describing your job</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xl-12">
				<!-- <a href="#" class="button ripple-effect big margin-top-30"><i class="icon-feather-plus"></i> Post a Job</a> -->
				<button type="submit" class="button ripple-effect big margin-top-30">Submit</button>
			</div>
		</div>
	</div>
	</form>
</div>
<!-- Category Boxes -->

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
												<h3 class="job-listing-title"><a href="#">Barista and Cashier</a></h3>

												
											</div>
										</div>
									</div>
									<!-- Buttons -->
									<div class="buttons-to-right single-right-button">
										<a href="#" class="button red ripple-effect ico"><i class="icon-feather-heart"></i></a>
										
									</div>
								</li>

								<li>
									<!-- Job Listing -->
									<div class="job-listing">

										<!-- Job Listing Details -->
										<div class="job-listing-details">

											<!-- Logo -->
											<a href="#" class="job-listing-company-logo">
												<img src="assets/img/company-logo-02.png" alt="">
											</a>


											<!-- Details -->
											<div class="job-listing-description">
												<h3 class="job-listing-title"><a href="#">Administrative Assistant</a></h3>

												<!-- Job Listing Footer -->
												
											</div>

										</div>
									</div>

									<!-- Buttons -->
									<div class="buttons-to-right single-right-button">
										<a href="#" class="button red ripple-effect ico"><i class="icon-feather-heart"></i></a>
										
									</div>
								</li>

								<li>
									<!-- Job Listing -->
									<div class="job-listing">

										<!-- Job Listing Details -->
										<div class="job-listing-details">

											<!-- Logo -->
											<a href="#" class="job-listing-company-logo">
												<img src="assets/img/company-logo-03.png" alt="">
											</a>

											<!-- Details -->
											<div class="job-listing-description">
												<h3 class="job-listing-title"><a href="#">Construction Labourers</a></h3>

												<!-- Job Listing Footer -->
												
											</div>
										</div>
									</div>

									<!-- Buttons -->
									<div class="buttons-to-right single-right-button">
										<a href="#" class="button red ripple-effect ico"><i class="icon-feather-heart"></i></a>
										
									</div>
								</li>
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
							<h3>Lorem Ipsum is simply dummy </h3>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
						</div>
					</a>

					<!-- Category Box -->
					<a href="jobs-list-layout-2.html" class="category-box">
						<div class="category-box-icon">
							<i class="icon-line-awesome-pie-chart"></i>
						</div>
											
						<div class="category-box-content">
							<h3>Lorem Ipsum is simply dummy </h3>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
						</div>
					</a>

					<!-- Category Box -->
					<a href="jobs-list-layout-1.html" class="category-box">
						<div class="category-box-icon">
							<i class="icon-line-awesome-image"></i>
						</div>
						
						<div class="category-box-content">
							<h3>Lorem Ipsum is simply dummy </h3>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
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