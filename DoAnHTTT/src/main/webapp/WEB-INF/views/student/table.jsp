<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="scheduleItems" scope="session"
	class="httt.DoAnHTTT.database.Student_ScheduleDAO" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Home Page</title>
</head>
<body>
	<!-- Preloader -->
	<div id="preloader">
		<div class="spinner"></div>
	</div>

	<!-- ##### Header Area Start ##### -->
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
			<table id="tableahihi" class="" style="width: 100%;">
				<thead>
					<tr style="border: none">
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
						<c:forEach var="item"
							items="${scheduleItems.getTimeTableItem(idU)}">
							<td>"${item.getId_Professor()}"</td>
						</c:forEach>
					</tr>
				</tbody>
				<tfoot>
				</tfoot>
			</table>

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
</body>
</html>