<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Employee Profile Edit</title>

        <!-- font-awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />

        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />

        <link rel="stylesheet" href="assets/css/style.css" />
        <link rel="stylesheet" href="assets/css/responsive.css" />
        <link rel="stylesheet" href="assets/css/animation.css" />
        
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
        <div class="ls-bg">
            <img class="ls-bg-inner" src="assets/img/bg.png" alt="" />
        </div>

        <main class="overflow-hidden">
            <div class="wrapper">
                <div class="main-inner">
                    <div class="row h-100 align-content-center">
                        <div class="col-md-6 tab-100 order_2">
                            <!-- side text -->
                            <div class="side-text">
                                <article>
                                    <span>Join Our Marketplace</span>
                                    <h1 class="main-heading">Company</h1>
                                    <p>
                                        The next generation social network & community! Connect with your friends and play with our quests and badges gamification system!
                                    </p>
                                </article>                               
                            </div>
                        </div>
                        <div class="col-md-6 tab-100">
                            <!-- form -->
                            <div class="form">
                                <h2 class="login-form form-title">
                                    Account Login
                                </h2>
                                <h2 class="signup-form form-title">
                                    Register your Account!
                                </h2>

                                <!-- login form -->
                              <!-- <form action="/login" method="post">
                                    <div class="service-area mb-4">
                                        <div class="justify-content-center d-flex align-items-center me-4">
                                            <input checked="" type="radio" name="emptype" value="Employee " />
                                            <label>Employee </label>
                                        </div>
                                        <div class="justify-content-center d-flex align-items-center">
                                            <input type="radio" name="emptype" value="Firm" />
                                            <label>Firm</label>
                                        </div>
                                    </div>

                                    <div class="input-field">
                                        <input type="text" id="empemail"  name="empemail" required value="yy@y.com" />
                                        <label>
                                            Username or Email
                                        </label>
                                    </div>
                                    <div class="input-field delay-100ms mb-2">
                                        <input type="password" id="password" name="password" value="asdf" required />
                                        <label>
                                            Password
                                        </label>
                                    </div>
                                    <div class="d-flex justify-content-between flex-wrap mb-3 ps-2 pe-2">

                                    </div>
                                    <div class="login-btn">
                                        <button type="submit" class="login">Submit</button>
                                    </div>
                                </form>-->
                                    <div class="logSign">
                                        <button id="showregister" type="button">register</button>
                                    </div>

                                <!-- sign up form -->
                                <form id="step2" action = "/updatedetails" class="signup-form" method="post">
                                    <div class="signup-frm-inner">
                                    <input type="hidden" id="empid" name="empid" value="${employee.empid}" />
                                        <div class="input-field delay-100ms">
                                            <input type="email" id="unique-handle"  name="empemail" required value="${employee.empemail}" readonly  />
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            <label>
                                                Email
                                            </label>
                                        </div>
                                        <div class="input-field delay-100ms">
                                            <input type="text" id="fname" name= "firstname" required value="${employee.firstname}" />
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            <label>
                                                First Name
                                            </label>
                                        </div>
                                        <div class="input-field delay-100ms">
                                            <input type="text" id="lname" name = "lastname" required value="${employee.lastname}"/>
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            <label>
                                                Last Name
                                            </label>
                                        </div>
                                        <div class="input-field delay-100ms">
                                            <input type="text" id="pincode" name = "pincode" required value="${employee.pincode}"/>
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            <label>
                                                Pin Code
                                            </label>
                                        </div>
                                        <div class="input-field delay-100ms">
                                            <input type="text" id="add1" name="address1" required value="${employee.address1}"/>
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            <label>
                                                Address 1
                                            </label>
                                        </div>
                                        <div class="input-field delay-100ms">
                                            <input type="text" id="add2" name="address2"  required value="${employee.address2}"/>
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            <label>
                                                Address 2
                                            </label>
                                        </div>
                                        <div class="input-field delay-200ms">
                                            <input type="contact" id="contact" name ="contact"   required value="${employee.contact}" />
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            <label>
                                                Phone Number
                                            </label>
                                        
                                        <div class="input-field delay-200ms">
                                            <input type="password" id="password" name ="password"   required value="${employee.password}" />
                                            <span class="error-message" style="color: red; display: none;"></span>
                                            <label>
                                                Password
                                            </label>
                                        </div>
                                        <div class="input-field delay-300ms">
		                                    <input type="password" id="confirm"  required value="${employee.password}">
		                                    <span class="error-message" style="color: red; display: none;"></span>
		                                    <label>
		                                        Confirm Password
		                                    </label>
		                                </div> 
                                    </div>

                                    <div class="login-btn">
                                        <button type="submit" class="signup">Update</button>
                                    </div>
                                   <!--  --> <div class="logSign">
                                        <button id="showlogin" type="button" class="active">Login</button>
                                    </div>-->
                                </form>
                                <!-- <div class="signup-form register-text">
                                You'll receive a confirmation email in your inbox with a link to activate your account. If you have any problems, <a href="#">contact us!</a> 
                            </div> -->
                                <span class="error-message" style="color: red">${error}</span> <!-- Display error message if login fails -->
                                 <span class="error-message" style="color: blue">${info}</span> <!-- Display error message if login fails -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <div id="error"></div>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery-3.6.1.min.js"></script>
        <script src="assets/js/custom.js"></script>
    </body>
</html>