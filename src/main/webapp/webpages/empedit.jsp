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
        
        <script type="text/javascript">
	        document.addEventListener('DOMContentLoaded', function () {
            const signupForm = document.getElementById('step2');

            
            signupForm.addEventListener('submit', function (event) {
                event.preventDefault(); // Prevent the default form submission initially

             // Clear previous errors
                document.querySelectorAll('.error-message').forEach(e => e.style.display = 'none');
                
                const password = document.getElementById('password').value;
                const confirm = document.getElementById('confirm').value;
                const errorSpan = document.getElementById('confirm').nextElementSibling;

                // Clear previous errors
                errorSpan.style.display = 'none';

                // Check if passwords match
                if (password !== confirm) {
                    errorSpan.textContent = 'Passwords do not match.';
                    errorSpan.style.display = 'inline';
                    return; // Stop the form submission
                }

                // If all checks pass, manually submit the form
                signupForm.submit();
            });
        });


        </script>
    </head>
    <body>
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
            

            <form action="/updatedetails" method="post">
                <div id="post-jobs" class="section margin-top-45 padding-bottom-75">
            
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Section Headline -->
                            <div class="section-headline margin-top-0 margin-bottom-35">
                                <h3>Update Profile</h3>					
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <!-- Dashboard Box -->
                        <div class="col-xl-12">
                            <div class="dashboard-box margin-top-0">
                                <!-- Headline -->
                                <div class="headline">
                                    <h3>Edit Profile</h3>
                                </div>
                                <input type="hidden" id="empid" name="empid" value="${employee.empid}" />
                                <div class="content with-padding padding-bottom-10">
                                    <div class="row">
                                        <div class="col-xl-4">
                                            <div class="submit-field">	
                                                <h5>Email</h5>							
                                                <input type="email" id="unique-handle"  name="empemail" required value="${employee.empemail}" readonly  />
                                                <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>
                                        
                                        <div class="col-xl-4">
                                            <div class="submit-field">
                                                <h5>First Name</h5>
                                                <input type="text" id="fname" name= "firstname" required value="${employee.firstname}" />
                                                <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>
                                        <div class="col-xl-4">
                                            <div class="submit-field">
                                                <h5>Last Name</h5>
                                                <input type="text" id="lname" name = "lastname" required value="${employee.lastname}"/>
                                                <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>


                                        
                                        <div class="col-xl-4">
                                            <div class="submit-field">
                                                <h5>Pin Code </h5>
                                                <input type="text" id="pincode" name = "pincode" required value="${employee.pincode}"/>
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>
                                        <div class="col-xl-4">
                                            <div class="submit-field">
                                                <h5>Address 1</h5>
                                                <input type="text" id="add1" name="address1" required value="${employee.address1}"/>
                                                <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>
                                        <div class="col-xl-4">
                                            <div class="submit-field">
                                                <h5>Address 2</h5>
                                                <input type="text" id="add2" name="address2"  required value="${employee.address2}"/>
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>
                                        <div class="col-xl-4">
                                            <div class="submit-field">
                                                <h5>Phone Number</h5>
                                                <input type="contact" id="contact" name ="contact"   required value="${employee.contact}" />
                                                <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>

                                        <div class="col-xl-4">
                                            <div class="submit-field">
                                                <h5>Password</h5>
                                                <input type="password" id="password" name ="password"   required value="${employee.password}" />
                                                <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>

                                        <div class="col-xl-4">
                                            <div class="submit-field">
                                                <h5>Confirm Password</h5>
                                                <input type="password" id="confirm"  required value="${employee.password}">
		                                    <span class="error-message" style="color: red; display: none;"></span>
                                            </div>
                                        </div>
                                                                    
                                        
                                        <div class="col-xl-12">
                                            <button type="submit" class="button ripple-effect big mt-3 mb-3">Update</button>			
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
                 <span class="error-message" style="color: red">${error}</span> 
                 <span class="error-message" style="color: blue">${info}</span> 

      

        <div id="error"></div>
       
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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="assets/js/custom.js"></script>
    </body>
</html>