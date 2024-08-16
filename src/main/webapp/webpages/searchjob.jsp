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

.accordion-item{border-bottom:0px solid #ccc}
	.accordion-header{background-color:transparent;padding:10px;cursor:pointer;box-shadow: none;}
	.accordion-content{padding:10px;display:none}
	.accordion-content.open{display:block}	
	.accordion-header h4{color: #fff;font-weight: 600;margin: 0;}
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
						<li><a href="searchjob?fromsrch=false" class="current">Search Jobs</a></li>
						<li><a href="likedjobs" class="current">Liked Jobs</a></li>
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
						<i class="fa fa-user" aria-hidden="true"></i>
						 ${empName}
			        </a> 
			        <input type="hidden" id="firmname" name="firmname" value="${empId}" />
			    </div>
			    <div>
			        <a href="${pageContext.request.contextPath}/logout">
			             Logout
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
						<form action="${pageContext.request.contextPath}/searchjobbyval" method ="post">
							<div class="col-md-12 p-5 pb-0 pt-4">
																
									<div class="row">
										<div class="col-xl-4">
											<div class="submit-field mb-3">
												<h5>Job Title</h5>
												<input type="text" id ="jobId" name ="jobId"  class="with-border">
											</div>
										</div>
			
										<div class="col-xl-4">
											<div class="submit-field mb-3">
												<h5>Job Description</h5>
												<input type="text" id = "jobDesc"  name = "jobDesc" class="with-border">
											</div>
										</div>
										
										<div class="col-xl-3">
											<!-- <a href="#" class="button ripple-effect big margin-top-30"><i class="icon-feather-plus"></i> Search Jobs</a> -->
											<button type="submit" class="button ripple-effect big margin-top-30">Search</button>
										</div>
									</div>
								
							</div>
						</form>
						</div>
						

						<div class="content p-5">
							<table>
								<tr>
								  <th width="20%">Job Title</th>
								  <th width="40%">Job Detail</th>
								  <th width="11%">Apply By Date</th>
								  <th width="9%">Exp Year</th>
								  <th width="20%">Action</th>										  
								</tr>
							
								<c:forEach items="${jobPost}" var="jp">
								

									
										<tr>
										  <td><c:out value= "${jp.jobtitle}" /></td>
										  <td><c:out value= "${jp.jobdesc}" /></td>
										  <td><c:out value= "${jp.applybydate}" /></td>
										  <td><c:out value= "${jp.yearsofexp}" /></td>
										  <td>
											
												<a href="savelikejob?jobPostId=${jp.jobpostingid} " class="button red ripple-effect ico"><i class="fa fa-heart" aria-hidden="true"></i>
												</a>
												<a href="applyjobid?jobpostingid=${jp.jobpostingid}&skillname=${jp.skillname}&jobtitle=${jp.jobtitle}" class="list-apply-button ripple-effect">Apply Now</a>
											
										  </td>
										</tr>
										<tr>
										  <td colspan="5">

											<div class="faqs-section">
												<div class="accordion-item">
													<div class="accordion-header">
														<h4>FAQs:</h4>
													</div>
													<div class="accordion-content">
														<c:forEach items="${jp.faqs}" var="faq">
															<p><strong>Q:</strong> <c:out value="${faq.question}"/></p>
															<p><strong>A:</strong> <c:out value="${faq.answer}"/> </p>
														</c:forEach>
													</div>
												</div>
											</div>
										  </td>
										 
										</tr>
										
										<!-- <tr>
											<td>Alfreds Futterkiste</td>
											<td><c:out value= "${jp.jobdesc}" /></td>
											<td>25 May</td>
											<td>12 Year</td>
											<td>
											  
												  <a href="savelikejob?jobPostId=${jp.jobpostingid} " class="button red ripple-effect ico"><i class="fa fa-heart" aria-hidden="true"></i>
												  </a>
												  <a href="applyjobid?jobpostingid=${jp.jobpostingid}&skillname=${jp.skillname}" class="list-apply-button ripple-effect">Apply Now</a>
											  
											</td>
										  </tr>
										  <tr>
											<td colspan="5">
  
											  <div class="faqs-section">
												  <div class="accordion-item">
													  <div class="accordion-header">
														  <h4>FAQs:</h4>
													  </div>
													  <div class="accordion-content">
														  <c:forEach items="${jp.faqs}" var="faq">
															  <p><strong>Q:</strong> Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
															  <p><strong>A:</strong> If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden </p>
														  </c:forEach>
													  </div>
												  </div>
											  </div>
											</td>
										   
										  </tr> -->
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
	
    /*<![CDATA[*/
    // JavaScript function to show success message in an alert box
    function showAlert(message) {
    	 if (message.trim() !== '') {
             alert(message);
         }
    }
    /*]]>*/	
	// For Faq Accordion Script
	document.addEventListener("DOMContentLoaded", function() {
		const accordionHeaders = document.querySelectorAll('.accordion-header');
		accordionHeaders.forEach(header => {
			header.addEventListener('click', function() {
				const accordionItem = this.parentElement;
				const accordionContent = accordionItem.querySelector('.accordion-content');
				const openAccordionContent = document.querySelector('.accordion-content.open');
				if (openAccordionContent && openAccordionContent !== accordionContent) {
					openAccordionContent.classList.remove('open');
				}
				accordionContent.classList.toggle('open');
			});
		});
	});
 </script>
</body>
</html>