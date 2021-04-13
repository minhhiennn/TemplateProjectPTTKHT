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
			<c:choose>
				<c:when test="${currentUser != null}">
					<table id="tableahihi" class="" style="width: 100%;">
						<thead>
							<tr style="border: none">
							    <th class="th-sm"></th>
								<th class="th-sm">Mã MH</th>
                                <th class="th-sm">Tên MH</th>
                                <th class="th-sm">STC</th>
                                <th class="th-sm">Mã lớp</th>
                                <th class="th-sm">Sĩ số</th>
                                <th class="th-sm">CL</th>
                                <th class="th-sm">Theoretical</th>
                                <th class="th-sm">Thứ</th>
                                <th class="th-sm">Tiết BD</th>
                                <th class="th-sm">ST</th>
                                <th class="th-sm">Phòng</th>
                                <th class="th-sm">Giảng Viên</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item"
								items="${scheduleItems.getSubAvailableST(idU)}">
								<tr>
								    <td> <input type="checkbox"> </td>
									<td>${item.getCourse_Offering().getCourse().getiD_Course()}</td>
									<td>${item.getCourse_Offering().getCourse().getName_Course()}</td>
									<td>${item.getCourse_Offering().getCourse().getCourse_certificate()}</td>
									<td>${item.getCourse_Offering().getClass_code()}</td>
									<td>${item.getCourse_Offering().getMax_Size()}</td>
									<td>${item.getCourse_Offering().getCurrent_Size()}</td>
									<td>${item.getCourse_Offering().getTheoretical()}</td>
									<td>${item.getCourse_Offering().getTeaching_Day()}</td>
									<td>${item.getCourse_Offering().getStart_Slot()}</td>
									<td>${item.getCourse_Offering().getEnd_Slot() - item.getCourse_Offering().getStart_Slot()}</td>
									<td>${item.getCourse_Offering().getStudy_place()}</td>
									<td>${item.getProfessor().getProfessor_Name()}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
						</tfoot>
					</table>
				</c:when>
				<c:otherwise>
					<h3 style="color: red;text-align: center;">Vui Lòng Đăng Nhập Để Xem Được Đăng Ký Môn Học</h3>
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
</body>
</html>