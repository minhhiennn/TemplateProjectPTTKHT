<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="header-area">

	<!-- Top Header Area -->
	<div
		class="top-header-area d-flex justify-content-between align-items-center">
		<!-- Contact Info -->
		<div class="contact-info">
			<a href="#"><span>Phone:</span> +44 300 303 0266</a> <a href="#"><span>Email:</span>
				info@clever.com</a>
		</div>
		<!-- Follow Us -->
		<div class="follow-us">
			<span>Follow us</span> <a href="#"><i class="fa fa-facebook"
				aria-hidden="true"></i></a> <a href="#"><i class="fa fa-instagram"
				aria-hidden="true"></i></a> <a href="#"><i class="fa fa-twitter"
				aria-hidden="true"></i></a>
		</div>
	</div>

	<!-- Navbar Area -->
	<div class="clever-main-menu">
		<div class="classy-nav-container breakpoint-off">
			<!-- Menu -->
			<nav class="classy-navbar justify-content-between" id="cleverNav">

				<!-- Logo -->
				<a class="nav-brand" href="index.jsp"><img
					src="img/core-img/logo.png" alt=""></a>

				<!-- Navbar Toggler -->
				<div class="classy-navbar-toggler">
					<span class="navbarToggler"><span></span><span></span><span></span></span>
				</div>

				<!-- Menu -->
				<div class="classy-menu">

					<!-- Close Button -->
					<div class="classycloseIcon">
						<div class="cross-wrap">
							<span class="top"></span><span class="bottom"></span>
						</div>
					</div>

					<!-- Nav Start -->
					<div class="classynav">
						<ul>
							<li><a href="index.jsp">Home</a></li>
							<!--          <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="index.jsp">Home</a></li>
                                        <li><a href="courses.jsp">Courses</a></li>
                                        <li><a href="single-course.jsp">Single Courses</a></li>
                                        <li><a href="instructors.jsp">Instructors</a></li>
                                        <li><a href="blog.jsp">Blog</a></li>
                                        <li><a href="blog-details.jsp">Single Blog</a></li>
                                        <li><a href="regular-page.jsp">Regular Page</a></li>
                                        <li><a href="contact.jsp">Contact</a></li>
                                    </ul>
                                </li> -->
							<li><a href="courses.jsp">Courses register</a></li>
							<li><a href="table.jsp">TimeTable</a></li>
							<li><a href="instructors.jsp">Examination Schedule</a></li>
							<li><a href="instructors.jsp">View School Fee</a></li>
							<li><a href="blog.jsp">Student Mark</a></li>
							<li><a href="contact.jsp">Course Program</a></li>
						</ul>

						<!-- Search Button -->
						<!-- <div class="search-area">
								<form action="#" method="post">
									<input type="search" name="search" id="search"
										placeholder="Search">
									<button type="submit">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
								</form>
							</div> -->

						<!-- Register / Login -->
						<div class="register-login-area">
							<a href="#" class="btn">Register</a>
							<button id="myBtn" class="btn active">Open Modal</button>
						</div>

						<div class="modal" id="myModal">
							<div id="formContent">
								<!-- Tabs Titles -->
								<h2 class="active" id="SignInB">Sign In</h2>
								<h2 class="active" id="SignUpB">Sign Up</h2>

								<!-- Icon -->
								<div class="fadeIn first"></div>

								<!-- Login Form -->
								<div class="form-container sign-in-container" id="SignIn">
									<form>
										<input type="text" id="login" class="fadeIn second"
											name="login" placeholder="login"> <input type="text"
											id="password" class="fadeIn third" name="login"
											placeholder="password"> <input type="submit"
											class="fadeIn fourth" value="Log In">
									</form>
								</div>
								<div class="form-container sign-up-container" id="SignUp"
									style="display: none">
									<form>
										<input type="text" id="login" class="fadeIn second"
											name="login" placeholder="login"> <input type="text"
											id="password" class="fadeIn third" name="login"
											placeholder="password"> <input type="text"
											id="password" class="fadeIn third" name="login"
											placeholder="password"> <input type="submit"
											class="fadeIn fourth" value="Log In">
									</form>
								</div>

								<!-- Remind Passowrd -->
								<div id="formFooter">
									<a class="underlineHover" href="#">Forgot Password?</a>
								</div>

							</div>
						</div>
					</div>
					<!-- Nav End -->
				</div>
			</nav>
		</div>
	</div>
</header>
<script>
	// Get the modal

	var modal = document.getElementById("myModal");
	var modalSignIn = document.getElementById("SignIn");
	var modalSignUp = document.getElementById("SignUp");
	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");
	var btnI = document.getElementById("SignInB");
	var btnU = document.getElementById("SignUpB");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	// When the user clicks the button, open the modal 
	btn.onclick = function() {
		modal.style.display = "block";
	}
	btnI.onclick = function() {
		modalSignIn.style.display = "block";
		modalSignUp.style.display = "none";
	}
	btnU.onclick = function() {
		modalSignUp.style.display = "block";
		modalSignIn.style.display = "none";

	}
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}
	function openNav(e) {
		e.stopPropagation();
		modal.style.display = "block";
	}
	// When the user clicks anywhere outside of the modal, close it
</script>