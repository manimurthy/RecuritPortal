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
						<li><a href="searchjob" class="current">Search Jobs</a></li>
						<li><a href="postjob" class="current">Post Jobs</a></li>
						<li><a href="jobfirmdashboard" class="current">PostedJob</a></li>	
						</ul>
					</nav>
					<div class="clearfix"></div>				
				</div>
				<!-- Left Side Content / End -->
				<!-- Right Side Content / End -->
				<div class="right-side">
					<div class="header-widget">
						<a href="index-logged-out.html"><i class="icon-material-outline-power-settings-new"></i> Logout</a>
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


	<form action="/saveFAQJob" method="post">
	<div id="post-jobs" class="section margin-top-45 padding-bottom-75">

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Section Headline -->
				<div class="section-headline margin-top-0 margin-bottom-35">
					<h3>Post Jobs</h3>					
					<span id ="infomsg">${info}</span>
					<span id ="errmsg">${info}</span>
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
									<h5>Job Title</h5>
									<input type="text" id = "jobtitle" name = "jobtitle" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>

							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Department</h5>
									<input type="text" id = "dept" name = "dept" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>

							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Admin in charge </h5>
									<input type="text" id = "admin_in_charge" name = "admin_in_charge" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>

							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Apply by date </h5>
									<input type="date" id = "applybydate" name ="applybydate" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Years of Experience required </h5>
									<input type="text" id = "yearsofexp" name ="yearsofexp" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Exp. Weightage</h5>
									<input type="text" id ="expweightpercent"  name ="expweightpercent" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Edu. Weightage</h5>
									<input type="text" id = "eduweightpercent" name ="eduweightpercent" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<h5>Exp. Skills Weightage</h5>
									<input type="text" id = "expskills" name ="expskills" class="with-border" />
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
							<div class="col-xl-4">
								<div class="submit-field">
									<input type="hidden" id = "firmunqid" name = "firmunqid" class="with-border" value="${firmunqid}"/>
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
														
							<div class="col-xl-12">
								<div class="submit-field">
									<h5>Job Description</h5>
									<textarea id = "jobdesc" name="jobdesc" cols="30" rows="5" class="with-border"></textarea>
									<span class="error-message" style="color: red; display: none;"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xl-12">
				<!-- <a href="#" class="button ripple-effect big margin-top-30"><i class="icon-feather-plus"></i> Post a Job</a> -->
				<button type="submit" class="button ripple-effect big margin-top-30">Submit</button>
				<div class="col-xl-6 d-flex align-items-center justify-content-end">
					<button type="button" class="button ripple-effect big margin-top-30" data-bs-toggle="modal" data-bs-target="#exampleModalLg">Add Question & Answer</button>
				</div>				
			</div>
		</div>
	</div>
	<!--  </form>-->
	</div>
	<!-- Category Boxes -->
	<div class="section  gray padding-top-65 padding-bottom-75">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- Section Headline -->
					<div class="section-headline margin-top-0 margin-bottom-35">
						<h3>FA'Q Listing</h3>					
					</div>
				</div>
			</div>
		    <label for="question">FAQ Question:</label>
		    <input type="text" id="question" name="faqs[0].question"><br>
		
		    <label for="answer">FAQ Answer:</label>
		    <input type="text" id="answer" name="faqs[0].answer"><br>
		    <label for="question">FAQ Question:</label>
		    <input type="text" id="question" name="faqs[1].question"><br>
		
		    <label for="answer">FAQ Answer:</label>
		    <input type="text" id="answer" name="faqs[1].answer"><br>
		    <label for="question">FAQ Question:</label>
		    <input type="text" id="question" name="faqs[2].question"><br>
		
		    <label for="answer">FAQ Answer:</label>
		    <input type="text" id="answer" name="faqs[2].answer"><br>			
			<div class="row">
				<table class="table table-hover table-responsive table-bordered" id="dataTable" style="background: #fff;">
					<thead>
						<tr>
							<th width="5%">ID</th>
							<th width="31%">Question</th>
							<th width="31%">Answer</th>
							<th width="8%" class="text-center">Edit</th>
							<th width="8%" class="text-center">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!--  <tr>
							<td>1</td>
							<td>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</td>
							<td>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</td>							
							<td class="text-center">
								<button type="button" data-bs-toggle="modal" data-bs-target="#edit" data-uid="1" class="update btn btn-warning btn-sm">
									<span class="icon-line-awesome-edit"></span>
								</button>
							</td>
							<td class="text-center">
								<button type="button" data-bs-toggle="modal" data-bs-target="#delete" data-uid="1" class="delete btn btn-danger btn-sm" onclick="deleteRow(this)">
									<span class="icon-material-outline-delete"></span>
								</button>
							</td>
						</tr>-->
					</tbody>
				</table>
			</div>
		</div>
	</div>
	 </form>
	<div id="edit" class="modal fade" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
		<div class="modal-header">			
			<h2 class="modal-title fs-4">Update FA'Q</h2>
			<button type="button" class="btn-close" data-bs-dismiss="modal">×</button>
		</div>
		<div class="modal-body">
			<div class="row">
				<div class="col-xl-12">
					<div class="submit-field">
						<h5>Question</h5>
						<input type="text" class="with-border" />
					</div>
				</div>

				<div class="col-xl-12">
					<div class="submit-field">
						<h5>Answer</h5>
						<textarea cols="15" rows="5" class="with-border"></textarea>
					</div>
				</div>
				
									
				
			</div>

		</div>
		<div class="modal-footer">
			<button type="button" id="up" class="button ripple-effect big" data-bs-dismiss="modal" >Update</button>
			<button type="button" class="btn btn-default" data-bs-dismiss="modal">Close</button>
		</div>
		</div>
	</div>
	</div>
	<div id="delete" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
		<div class="modal-header">			
			<h2 class="modal-title fs-4">Update FA'Q</h2>
			<button type="button" class="btn-close" data-bs-dismiss="modal">×</button>
		</div>
		<div class="modal-body">
			<strong>Are you sure you want to delete this data?</strong>
		</div>
		<div class="modal-footer">
			<button type="button" id="del" class="btn btn-danger" data-bs-dismiss="modal">Delete</button>
			<button type="button" class="btn btn-default" data-bs-dismiss="modal">Close</button>
		</div>
		</div>
	</div>
	</div>

	<!-- Featured Jobs / End -->
	<div class="section  padding-top-65 padding-bottom-75">
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
	<div class="modal fade" id="exampleModalLg" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<h2 class="modal-title fs-4" id="exampleModalLg">Add FA'Q</h2>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-xl-12">
						<div class="submit-field">
							<h5>Question</h5>
							<input type="text" id = "question" name = "question" class="with-border" />
						</div>
					</div>

					<div class="col-xl-12">
						<div class="submit-field">
							<h5>Answer</h5>
							<textarea cols="15"  id = "answer" name = "answer" rows="5" class="with-border"></textarea>
						</div>
					</div>
					
					<div class="col-xl-12">
						<button type="button" id="up" class="button ripple-effect big" data-bs-dismiss="modal" onclick="addData()">Add FAQ</button>
					</div>
				</div>

			</div>
		</div>
		</div>
	</div>



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
	        var errorSpan = document.getElementById("errmsg");
	        var infoSpan = document.getElementById("infomsg");
	        
	        errorSpan.style.display = "none";
	        infoSpan.style.display = "none";

	        // Check if all fields are filled and display error messages next to inputs
	        inputs.each(function() {
	            const errorSpan = $(this).next();
	            if ($(this).val().trim() === '') {
	                errorSpan.text('This field is required.').css('display', 'inline');
	                isValid = false;
	            }
	        });

	        // Function to validate if a value is an integer
	        function validateInteger(input) {
	            const value = Number(input.val());
	            if (!Number.isInteger(value)) {
	                input.next().text('Must be a whole number.').css('display', 'inline');
	                isValid = false;
	            }
	        }

	        // Validate specific fields
	        validateInteger($('#eduweightpercent'));
	        validateInteger($('#expweightpercent'));
	        validateInteger($('#expskills'));
	        validateInteger($('#yearsofexp'));

	        // Specific validation for 'applybydate' to check if the date is in the future
	        const applyByDateInput = $('#applybydate');
	        const applyByDateError = applyByDateInput.next();
	        if (!isFutureDate(applyByDateInput.val())) {
	            applyByDateError.text('Date must be in the future.').css('display', 'inline');
	            isValid = false;
	        }

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
	        tomorrow.setDate(tomorrow.getDate() + 1); // Set 'tomorrow' to the next day

	        const input = new Date(inputDate);
	        return input >= tomorrow; // Check if the input date is at least tomorrow
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