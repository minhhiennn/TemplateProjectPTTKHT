<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="semesterDao" scope="request"
	class="httt.DoAnHTTT.database.SemesterDAO" />
<jsp:useBean id="studen_schedule" scope="page"
	class="httt.DoAnHTTT.database.Student_ScheduleDAO" />
<jsp:useBean id="Sub_pass" scope="page"
	class="httt.DoAnHTTT.database.Sub_PassDAO" />
<jsp:useBean id="semester_resultdao" scope="page"
	class="httt.DoAnHTTT.database.Semester_ResultDAO" />
<jsp:useBean id="final_resultdao" scope="page"
	class="httt.DoAnHTTT.database.Final_ResultDAO" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
<c:set var="timeTable" value="${requestScope['listTimeTable']}"></c:set>
<c:set var="idses" value="${semesterDao.getID_SemesterByGetTop1(idU)}"></c:set>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
.my-custom-scrollbar {
	position: relative;
	height: 300px;
	overflow: auto;
	background: red;
}

.table-wrapper-scroll-y {
	display: block;
}
</style>
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

					<button id="demo" style="color: blue; margin-left: 500px;">xem
						điểm tất cả các kỳ</button>

					<table border="2" id="table"
						class="table table-bordered table-striped mb-0"
						style="border-collapse: separate; empty-cells: show;">
						<thead>
							<tr style="color: blue;">
								<th scope="col">STT</th>
								<th scope="col">Mã môn</th>
								<th scope="col">Tên Môn</th>
								<th scope="col">Tc</th>
								<th scope="col">% KT</th>
								<th scope="col">%thi</th>
								<th scope="col">thi L1</th>
								<th scope="col">thi l2</th>
								<th scope="col">Tk (10)</th>
								<th scope="col">Tk (ck)</th>
							</tr>
							<tr>
								<td colspan="10" style="background: #ffe69c"><span>
										<c:out value="${idses }" />
								</span></td>
							</tr>
						</thead>
						<tbody>
							<c:set var="count" value="1" scope="page" />
							<c:forEach var="item"
								items="${studen_schedule.getTimeTableBySemesterAndUser(idses,idU)}">
								<tr>
									<td><c:out value="${count }" /></td>
									<td>${item.getCourse_Offering().getCourse().getiD_Course()}</td>
									<td>${item.getCourse_Offering().getCourse().getName_Course()}</td>
									<td>${item.getCourse_Offering().getCourse().getCourse_certificate()}</td>
									<td></td>
									<td></td>
									<c:forEach var="itemss"
										items="${Sub_pass.getDataScore(idU,item.getCourse_Offering().getCourse().getiD_Course(),idses)}">
										<td>${itemss.getScore()}</td>
										<td></td>
										<td>${itemss.getScore()}</td>
										<td>${itemss.getRated()}</td>
									</c:forEach>
								</tr>
								<c:set var="count" value="${count + 1}" scope="page" />
							</c:forEach>
						</tbody>
					</table>
					<button id="demo2"
						style="color: blue; margin-left: 500px; display: none;">xem
						điểm kỳ hiện tại</button>
					<div class="table-wrapper-scroll-y my-custom-scrollbar"
						style="position: relative; height: 900px; overflow: auto; display: block;">

						<table id="table2" class="table table-bordered table-striped mb-0"
							style="display: none;">
							<thead>
								<tr style="color: blue;">
									<th scope="col">STT</th>
									<th scope="col">Mã môn</th>
									<th scope="col">Tên Môn</th>
									<th scope="col">Tc</th>
									<th scope="col">% KT</th>
									<th scope="col">%thi</th>
									<th scope="col">thi L1</th>
									<th scope="col">thi l2</th>
									<th scope="col">Tk (10)</th>
									<th scope="col">Tk (ck)</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="count" value="1" scope="page" />
								<c:forEach var="itemssss"
									items="${semester_resultdao.getIDsemester(idU)}">
									<tr>
										<td colspan="10" style="background: #ffe69c"><span>hoc
												kì:${itemssss.getNumberS()} - Năm học:
												${itemssss.getYears()} </span></td>
									</tr>

									<c:forEach var="itemtable2"
										items="${studen_schedule.getTimeTableBySemesterAndUser(itemssss.getiD_Semester(),idU)}">
										<tr>
											<td><c:out value="${count }" /></td>
											<td>${itemtable2.getCourse_Offering().getCourse().getiD_Course()}</td>
											<td>${itemtable2.getCourse_Offering().getCourse().getName_Course()}</td>
											<td>${itemtable2.getCourse_Offering().getCourse().getCourse_certificate()}</td>
											<td></td>
											<td></td>
											<c:forEach var="itemtable3"
												items="${Sub_pass.getDataScore(idU,itemtable2.getCourse_Offering().getCourse().getiD_Course(),itemssss.getiD_Semester())}">

												<td><span>${itemtable3.getScore()}</span></td>
												<td></td>
												<td>${itemtable3.getScore()}</td>
												<td>${itemtable3.getRated()}</td>
											</c:forEach>
										</tr>
										<c:set var="count" value="${count + 1}" scope="page" />
									</c:forEach>
									<c:if
										test="${semester_resultdao.getDiemTB(idU,itemssss.getiD_Semester())!=0.0 }">
										<tr>
											<td colspan="10"><span style="width: 500px">Điểm
													trung bình học kỳ hệ 10/100:</span><span style="margin-left: 70px"><c:out
														value="${semester_resultdao.getDiemTB(idU,itemssss.getiD_Semester()) }" /></span></td>
										</tr>
										<tr>
											<td colspan="10"><span style="width: 500px"> Điểm
													trung bình học kỳ hệ 4:</span><span style="margin-left: 108px"><c:out
														value="${semester_resultdao.getDiemTBHe4(idU,itemssss.getiD_Semester()) }" /></span></td>
										</tr>
										<tr>
											<td colspan="10"><span style="width: 500px">Điểm
													trung bình tích lũy:</span><span style="margin-left: 135px"><c:out
														value="${final_resultdao.sumScore(idU,itemssss.getiD_Semester()) }" /></span></td>
										</tr>
										<tr>
											<td colspan="10"><span style="width: 500px">Điểm
													trung bình tích lũy (hệ 4):</span><span style="margin-left: 95px"><c:out
														value="${final_resultdao.sumScoreav4(idU,itemssss.getiD_Semester()) }" /></span></td>
										</tr>
										<tr>
											<td colspan="10"><span style="width: 500px">Số
													tín chỉ đạt:</span><span style="margin-left: 205px"><c:out
														value="${semester_resultdao.getSoTinChiDaDat(idU,itemssss.getiD_Semester())}" /></span></td>
										</tr>
										<tr>
											<td colspan="10"><span style="width: 500px">Số
													tín chỉ tích lũy:</span><span style="margin-left: 180px"><c:out
														value="${final_resultdao.SumcreditGet(idU,itemssss.getiD_Semester())}" /></span></td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<h3 style="color: red; text-align: center;">Vui Lòng Đăng Nhập
						Để Xem Được điểm</h3>
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