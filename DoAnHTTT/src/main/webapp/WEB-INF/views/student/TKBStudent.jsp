<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="semesterDao" scope="request"
	class="httt.DoAnHTTT.database.SemesterDAO" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
<c:set var="idSemester" value="${requestScope['idSemester']}"></c:set>
<c:set var="timeTable" value="${requestScope['listTimeTable']}"></c:set>
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
			<c:choose>
				<c:when test="${currentUser != null}">
					<form action="/DoAnHTTT/TimeTableServlet"
						method="post">
						<span>Chọn học kỳ xem thời khóa biểu</span> 
						<select name="select"
							onchange="this.form.submit()">
							<c:forEach var="item" items="${semesterDao.getSemesterByTop3(idU)}">
								<option value="${item.getiD_Semester()}"
									<c:if test="${item.getiD_Semester().equals(idSemester)}"> selected </c:if>>Học
									kỳ ${item.getNumberS()} - Năm học ${item.getYears()}</option>
							</c:forEach>
						</select>
					</form>
					<table id="tableahihi" class="" style="width: 100%;">
						<thead>
							<tr style="border: none">
								<th class="th-sm">Mã MH</th>
								<th class="th-sm">Tên MH</th>
								<th class="th-sm">STC</th>
								<th class="th-sm">Mã lớp</th>
								<th class="th-sm">Theoretical</th>
								<th class="th-sm">Thứ</th>
								<th class="th-sm">Tiết BD</th>
								<th class="th-sm">ST</th>
								<th class="th-sm">Phòng</th>
								<th class="th-sm">CBGD</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item"
								items="${timeTable}">
								<tr>
									<td>${item.getCourse_Offering().getCourse().getiD_Course()}</td>
									<td>${item.getCourse_Offering().getCourse().getName_Course()}</td>
									<td>${item.getCourse_Offering().getCourse().getCourse_certificate()}</td>
									<td>${item.getCourse_Offering().getClass1().getClass_Code()}</td>
									<td>${item.getTheoretical()}</td>
									<td>${item.getTeaching_Day()}</td>
									<td>${item.getStart_Slot()}</td>
									<td>${item.getEnd_Slot() - item.getStart_Slot()}</td>
									<td>${item.getStudy_place()}</td>
									<td>${item.getProfessor().getUser().getiD_User()}"</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
						</tfoot>
					</table>
				</c:when>
				<c:otherwise>
					<h3 style="color: red; text-align: center;">Vui Lòng Đăng Nhập
						Để Xem Được TKB</h3>
				</c:otherwise>
			</c:choose>
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
	<script type="text/javascript">
		
	</script>
</body>
</html>