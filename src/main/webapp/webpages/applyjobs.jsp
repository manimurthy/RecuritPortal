<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					        <a href="/logout">
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
		
		<!-- Intro Headline -->
		<div class="row">
			<div class="col-md-12">

			</div>
		</div>
	</div>
</div>


	<form action="/saveapplyjob" method="post">
	<div id="post-jobs" class="section margin-top-45 padding-bottom-75">

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Section Headline -->
				<div class="section-headline margin-top-0 margin-bottom-35">
					<h3>Apply Jobs</h3>					
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Dashboard Box -->
			<div class="col-xl-12">
				<div class="dashboard-box margin-top-0">
					<!-- Headline -->
					<div class="headline">
						<h3><i class="icon-feather-folder-plus"></i> Job Application Form</h3>
					</div>

					<div class="content with-padding padding-bottom-10">
						<div class="row">
							<div class="col-xl-4">
								<div class="submit-field">	
									<h5>Job Title</h5>							
									<input type="hidden" id = "empid" name = "empid"  value ="${empid}" class="with-border" readonly />
									<input type="hidden" id = "job_post_id" name = "job_post_id" value="${jobpostingid}"  class="with-border" readonly />
									<input type="text" id = "job_title" name = "job_title" value="${jobtitle}"  class="with-border" readonly />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
							
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Apply date </h5>
									<input type="text" id = "applieddate" name ="applieddate" class="with-border" readonly/>
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Years of Experience </h5>
									<input type="text" id = "noofyearsofexp" name ="noofyearsofexp" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Highest Education</h5>
									<select id="eduqualify" name="eduqualify" class="with-border">
									    <option value="Select">Select</option>
									    <option value="High School">High School</option>
									    <option value="Under Graduate">Under Graduate</option>
									    <option value="Graduate">Graduate</option>
									    <option value="Post Graduate">Post Graduate</option>
									    <option value="Doctrate">Doctorate</option>
									</select>									
									<span id="eduqualifyError" class="error-message" style="color: red; display: inline;"></span>
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Experience in : "${skillname}" </h5>
									<input type="text" id = "expinskills" name ="expinskills" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
														
							<div class="col-xl-12">
								<div class="submit-field">
									<h5>Miscellaneous Information</h5>
									<textarea id = "miscinfo" name="miscinfo" cols="30" rows="5" class="with-border"></textarea>
									<span class="error-message" style="color: red; display: none;"></span>
									<input type="hidden" id = "status" name ="status" value ="Applied" class="with-border" />
								</div>
							</div>
							<div class="col-xl-12">
								<!-- <a href="#" class="button ripple-effect big margin-top-30"><i class="icon-feather-plus"></i> Post a Job</a> -->
								<button type="submit" class="button ripple-effect big mt-3 mb-3">Submit</button>			
							</div>
						</div>
					</div>
				</div>
			</div>

			
		</div>
	</div>
	<!--  </form>-->
	</div>
	 </form>

	<!-- Featured Jobs / End -->
	<div class="section  padding-top-65 padding-bottom-75">
		
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
	</div>
	<!-- Footer / End -->
</div>


<script src="assets/js/jquery-3.6.1.min.js"></script>
<script src="assets/js/mmenu.min.js"></script>
<script src="assets/js/simplebar.min.js"></script>
<script src="assets/js/magnific-popup.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="assets/js/custom.js"></script>

<script>
	$(document).ready(function() {
	    // JavaScript code to execute when the page loads
	    var today = new Date().toISOString().split('T')[0];
	    document.getElementById("applieddate").value = today;
	    
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
	   
	    const form = $('form');

	    form.on('submit', function(event) {
	        event.preventDefault();
	        let isValid = true;

	        // Select all input elements and textarea from the form
	        const inputs = form.find('input[type="text"], input[type="date"], textarea');

	        // Clear previous errors
	        $('.error-message').css('display', 'none');
	        

	        // Check if all fields are filled and display error messages next to inputs
	        inputs.each(function() {
	            const errorSpan = $(this).next();
	            if ($(this).val().trim() === '') {
	                errorSpan.text('This field is required.').css('display', 'inline');
	                alert('failed required field');
	                isValid = false;
	            }
	        });
	        
	        var selectedValue = document.getElementById("eduqualify").value;
	        var errorSpanqfy = document.getElementById("eduqualifyError");
	        if (selectedValue === "Select") {
	        	alert('Select a proper Education qualification');
	        	errorSpanqfy.textContent('Select a proper Education qualification');//.css('display', 'inline');
	        	errorSpanqfy.text('Select a proper Education qualification').css('display', 'inline');
	        	errorSpanqfy.style.display = "inline";
	        	alert('Failed looped error')
	        	isValid =false;
	        }
	        else{
	        	errorSpanqfy.style.display = "none";
	        }
	        // Function to validate if a value is an integer
	        function validateInteger(input) {
	            const value = Number(input.val());
	            if (!Number.isInteger(value)) {
	                input.next().text('Must be a whole number.').css('display', 'inline');
	                alert('Must be a whole number.');
	                isValid = false;
	            }
	        }

	        // Validate specific fields
	        //validateInteger($('#eduweightpercent'));
	        //validateInteger($('#expweightpercent'));
	        validateInteger($('#expinskills'));
	        validateInteger($('#noofyearsofexp'));
/*
	        // Specific validation for 'applybydate' to check if the date is in the future
	        const applyByDateInput = $('#applybydate');
	        const applyByDateError = applyByDateInput.next();
	        if (!isFutureDate(applyByDateInput.val())) {
	            applyByDateError.text('Date must be in the future.').css('display', 'inline');
	            isValid = false;
	        }*/

	        // If all validations pass, submit the form
	        if (isValid) {

	            console.log('Form is valid, submitting...');
	            form[0].submit();
	        }
	    });

	    function isFutureDate(inputDate) {
	        const today = new Date();
	        today.setHours(0, 0, 0, 0); // Set today to midnight
	        const tomorrow = new Date(today);
	        //tomorrow.setDate(tomorrow.getDate() + 1); // Set 'tomorrow' to the next day

	        const input = new Date(inputDate);
	        return input == tomorrow; // Check if the input date is at least tomorrow
	    }
	});
    function addData() {
    	
        // Get the input field values
        var question = document.getElementById("question").value;
        var answer = document.getElementById("answer").value;

        // Get the table body where the new row will be added
        var tableBody = document.querySelector("#dataTable tbody");

        // Create a new row
        var newRow = document.createElement("tr");
        alert ('Called Add function');
        alert (tableBody);
        
        // Count the number of existing rows
        var rowCount = tableBody.rows.length;

        // Generate the ID for the new row
        var newRowId = rowCount + 1;
        alert (newRowId);
        // Create cells for the new row
        var idCell = document.createElement("td");
        var questionCell = document.createElement("td");
        var answerCell = document.createElement("td");
        var editCell = document.createElement("td");
        var deleteCell = document.createElement("td");

        // Set the text content of the cells
        idCell.textContent = newRowId //"New ID"; // You can generate the ID dynamically if needed
        questionCell.textContent = question;
        answerCell.textContent = answer;
        editCell.innerHTML = '<button type="button" data-bs-toggle="modal" data-bs-target="#edit" data-uid="1" class="update btn btn-warning btn-sm" onclick="populateModal(this.parentElement.parentElement)"><span class="icon-line-awesome-edit"></span></button>';
        deleteCell.innerHTML = '<button type="button" data-bs-toggle="modal" data-bs-target="#delete" data-uid="1" class="delete btn btn-danger btn-sm"><span class="icon-material-outline-delete" onclick="deleteRow(this)"></span></button>';

        // Append cells to the new row
        newRow.appendChild(idCell);
        newRow.appendChild(questionCell);
        newRow.appendChild(answerCell);
        newRow.appendChild(editCell);
        newRow.appendChild(deleteCell);

        // Append the new row to the table body
        tableBody.appendChild(newRow);

        // Set the id attributes for question and answer input fields
        questionCell.innerHTML = '<input type="text" id="faqs[' + newRowId + '].question" value="' + question + '" readonly>';
        answerCell.innerHTML = '<input type="text" id="faqs[' + newRowId + '].answer" value="' + answer + '"readonly>';

    }
    // Function to populate modal form fields with row data
    function populateModal(row) {
    	
        // Extract data from the clicked row
        var cells = row.getElementsByTagName("td");
        var question = cells[1].textContent; // Index 1 corresponds to the question column
        var answer = cells[2].textContent; // Index 2 corresponds to the answer column
		alert('Called the values....');
        // Set the values of the modal form fields
        document.getElementById("question").value = question;
        document.getElementById("answer").value = answer;
    }	

    function deleteRow(button) {
        // Get the parent row of the delete button
        var row = button.closest("tr");

        // Store a reference to the modal delete button
        var deleteButton = document.getElementById("del");

        // Show the modal
        var deleteModal = new bootstrap.Modal(document.getElementById('delete'));
        deleteModal.show();

        // Attach event listener to the delete button inside the modal
        deleteButton.addEventListener("click", function() {
            // Remove the row from the table
            row.parentNode.removeChild(row);
            
            // Close the modal
            deleteModal.hide();
        });
    }
    
 </script>
</body>
</html>