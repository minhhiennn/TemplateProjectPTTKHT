<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="courseDAO" scope="request"
	class="httt.DoAnHTTT.database.CourseDAO" />
<jsp:useBean id="studentScheduleDAO" scope="request"
	class="httt.DoAnHTTT.database.Student_ScheduleDAO" />
<jsp:useBean id="billingSystemDAO" scope="request"
	class="httt.DoAnHTTT.database.BillingSystemDAO" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
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
			<li class="breadcrumb-item active" aria-current="page">Art &amp;
				Design</li>
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
<section class="popular-courses-area section-padding-100">
	<div class="container">
		<c:choose>
			<c:when test="${currentUser != null}">
				<c:choose>
					<c:when test="${billingSystemDAO.checkBilling(idU) == true}">
						<table id="tableahihi" class="table table-bordered"
							style="width: 100%;">
							<thead>
								<tr style="border: none">
									<th class="th-sm">Mã MH</th>
									<th class="th-sm">Tên MH</th>
									<th class="th-sm">STC</th>
									<th class="th-sm">STCHP</th>
									<th class="th-sm">Học Phí</th>
									<th class="th-sm">Miễn Giảm</th>
									<th class="th-sm">Phải Đóng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item"
									items="${studentScheduleDAO.getIDCourse(idU)}">
									<tr>
										<td>${item}</td>
										<td>${courseDAO.getCourseNameByIDCourse(item)}</td>
										<td>${courseDAO.getCourse_certificate(item)}</td>
										<td>${courseDAO.getCourse_certificate(item)}</td>
										<td>00</td>
										<td></td>
										<td>00</td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="2" style="text-align: center">Tổng cộng</td>
									<td>${billingSystemDAO.sumCreadit(idU)}</td>
									<td>${billingSystemDAO.sumCreadit(idU)}</td>
									<td>${billingSystemDAO.getPaymoney(idU)}</td>
									<td>00</td>
									<td>${billingSystemDAO.getPaymoney(idU)}</td>
								</tr>
							</tbody>
							<tfoot>
							</tfoot>
						</table>
					</c:when>
					<c:otherwise>
						<h3 style="color: red; text-align: center;">Chưa có học phí
							học kỳ này</h3>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<h3 style="color: red; text-align: center;">Vui Lòng Đăng Nhập
					Để Xem Được Hóa Đơn Thanh Toán</h3>
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
