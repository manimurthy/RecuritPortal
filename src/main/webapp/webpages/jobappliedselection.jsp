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
<style>
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
						<li><a href="firmsearchjob" class="current">Posted Job</a></li>
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
				        <a href="${pageContext.request.contextPath}/logout">
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
		
	</div>
</div>

<!-- Features Jobs -->
<div class="section margin-top-45" id="search-jobs">
	<div class="container">
		<div class="row">
			<div class="col-xl-12">
				
				<!-- Section Headline -->
				<div class="section-headline margin-top-0 margin-bottom-35">
					<h3>Job Application Selection</h3>					
				</div>
				<div class="col-xl-12">
					<div class="dashboard-box margin-top-0 jb-head">
						<div class="headline">
							<h3> Job Application Table</h3>
						</div>
						<div class="content p-4">
						     <table>
						        <thead>
						            <tr>
						                <th width="30%">Employee Name</th>
						                <th width="15%">Applied Date</th>
						                <th width="15%">Cumulative Weightage</th>
						                <th width="15%">Status</th>
						                <th width="25%">Action</th>
						            </tr>
						        </thead>
						        <tbody>
						            <c:forEach items="${jobApplications}" var="jobApplication">
						                <tr>
						                    <td>${jobApplication.employee.firstname} ${jobApplication.employee.lastname}</td>
						                    <td>${jobApplication.applieddate}</td>
						                    <td>${jobApplication.calcTotalWeight}</td>
						                    <td>${jobApplication.status}</td>
						                    <td>
						                        <form action="${pageContext.request.contextPath}/updateStatus" method="post" style="    display: flex;
												flex-wrap: wrap;
												align-items: flex-start;
												justify-content: center;">
						                            <input type="hidden" name="jobapplyid" value="${jobApplication.jobapplyid}">
						                            <input type="hidden" name="jobpostid" value="${jobApplication.jobPost.jobpostingid}">
						                            <select name="status" class="mb-3">
						                                <option value="Accept" ${jobApplication.status eq 'Accept' ? 'selected' : ''}>Accept</option>
						                                <option value="Reject" ${jobApplication.status eq 'Reject' ? 'selected' : ''}>Reject</option>
						                            </select>
						                            <input type="submit" value="Update">
													<a href="/viewjobapplicationdetails?jobapplyid=${jobApplication.jobapplyid}" class="list-apply-button ripple-effect">View Details</a>
						                        </form>
												
						                    </td>
						                    
						                </tr>
						            </c:forEach>
						        </tbody>
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