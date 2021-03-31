<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *Must* come first in the head; any other head content must come *after* these tags -->
<!-- Title -->
<title>Clever - Education &amp; Courses Template | Courses</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Stylesheet -->
<link rel="stylesheet" href="style.css">

<!-- ?o?n CSS cho table -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/select/1.3.1/css/select.dataTables.min.css">
</head>
<body>
	<!-- Preloader -->
	<div id="preloader">
		<div class="spinner"></div>
	</div>

	<!-- ##### Header Area Start ##### -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- ##### Header Area End ##### -->

	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb-area">
		<!-- Breadcumb -->
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Courses</a></li>
				<li class="breadcrumb-item active" aria-current="page">Art
					&amp; Design</li>
			</ol>
		</nav>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!-- ##### Catagory ##### -->
	<div
		class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3"
		style="background-image: url(img/bg-img/bg2.jpg);">
		<h3>Art &amp; Design</h3>
	</div>

	<!-- ##### Popular Course Area Start ##### -->

	<section class="popular-courses-area section-padding-100">
		<div class="container">
			<div class="row">
				<table id="tableahihi" class="">
					<thead>
						<tr>
							<th class="th-sm">Check</th>
							<th class="th-sm">Name</th>
							<th class="th-sm">Position</th>
							<th class="th-sm">Office</th>
							<th class="th-sm">Age</th>
							<th class="th-sm">Start date</th>
							<th class="th-sm">Salary</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox"></td>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Garrett Winters</td>
							<td>Accountant</td>
							<td>Tokyo</td>
							<td>63</td>
							<td>2011/07/25</td>
							<td>$170,750</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Ashton Cox</td>
							<td>Junior Technical Author</td>
							<td>San Francisco</td>
							<td>66</td>
							<td>2009/01/12</td>
							<td>$86,000</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Cedric Kelly</td>
							<td>Senior Javascript Developer</td>
							<td>Edinburgh</td>
							<td>22</td>
							<td>2012/03/29</td>
							<td>$433,060</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Airi Satou</td>
							<td>Accountant</td>
							<td>Tokyo</td>
							<td>33</td>
							<td>2008/11/28</td>
							<td>$162,700</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Brielle Williamson</td>
							<td>Integration Specialist</td>
							<td>New York</td>
							<td>61</td>
							<td>2012/12/02</td>
							<td>$372,000</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Brielle Williamson</td>
							<td>Integration Specialist</td>
							<td>New York</td>
							<td>61</td>
							<td>2012/12/02</td>
							<td>$372,000</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Brielle Williamson</td>
							<td>Integration Specialist</td>
							<td>New York</td>
							<td>61</td>
							<td>2012/12/02</td>
							<td>$372,000</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Brielle Williamson</td>
							<td>Integration Specialist</td>
							<td>New York</td>
							<td>61</td>
							<td>2012/12/02</td>
							<td>$372,000</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Brielle Williamson</td>
							<td>Integration Specialist</td>
							<td>New York</td>
							<td>61</td>
							<td>2012/12/02</td>
							<td>$372,000</td>
						</tr>
					</tbody>
					<tfoot>
					</tfoot>
				</table>
			</div>

			<!-- <div class="row">
				<div class="col-12">
					<div class="load-more text-center wow fadeInUp"
						data-wow-delay="1000ms">
						<a href="#" class="btn clever-btn btn-2">Load More</a>
					</div>
				</div>
			</div> -->
		</div>
	</section>


	<!-- ##### Popular Course Area End ##### -->

	<!-- ##### Footer Area Start ##### -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- ##### Footer Area End ##### -->
	<!-- ##### All Javascript Script ##### -->
	<!-- jQuery-2.2.4 js -->
	<script src="js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<!-- ph?n n�y l� ph?n animation -->
	<!-- <script src="js/plugins/plugins.js"></script> -->
	<!-- Active js -->
	<script src="js/active.js"></script>
	<!-- JS cho table -->
	<!-- ?o?n js n�y cho table, ??ng x�a nha -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tableahihi').DataTable({
				"scrollY" : "300px",
				"scrollCollapse" : false,
				"paging" : false
			});
		});
	</script>
</body>

</html>