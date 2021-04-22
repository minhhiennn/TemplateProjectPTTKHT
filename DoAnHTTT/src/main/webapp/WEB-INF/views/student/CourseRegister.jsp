<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="scheduleItems" scope="request"
	class="httt.DoAnHTTT.database.Student_ScheduleDAO" />
<jsp:useBean id="TimeRegister" scope="request"
	class="httt.DoAnHTTT.database.TimeForCourseRegisterDao" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
<c:set var="err" value='${requestScope["err"]}' />


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
				<c:when test="${currentUser == null}">
					<h3 style="color: red; text-align: center;">Vui Lòng Đăng Nhập
						Để Xem Được Đăng Ký Môn Học</h3>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${TimeRegister.checkTime() == false }">
							<h3 style="color: red; text-align: center;">Thông Báo: Ngoài
								Thời Gian Đăng Ký</h3>
						</c:when>
						<c:otherwise>
							<div>
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
										<c:set var="count" value="0" scope="page" />
										<c:forEach var="item"
											items="${scheduleItems.getSubAvailableST(idU)}">
											<c:set var="disable" value="" scope="page" />
												<c:if
												test="${item.getCourse_Offering().getMax_Size() == item.getCourse_Offering().getCurrent_Size()}">
												<c:set var="disable" value="disabled" scope="page" />
											</c:if>
											<tr>
												<td><input type="checkbox" id="myCheck${count}"
													onclick="myFunction()" value="${item.getiD_Schedule()}" ${disable}></td>
												<td>${item.getCourse_Offering().getCourse().getiD_Course()}</td>
												<td>${item.getCourse_Offering().getCourse().getName_Course()}</td>
												<td>${item.getCourse_Offering().getCourse().getCourse_certificate()}</td>
												<td>${item.getCourse_Offering().getClass1().getClass_Code()}</td>
												<td>${item.getCourse_Offering().getMax_Size()}</td>
												<td>${item.getCourse_Offering().getCurrent_Size()}</td>
												<td>${item.getTheoretical()}</td>
												<td>${item.getTeaching_Day()}</td>
												<td>${item.getStart_Slot()}</td>
												<td>${item.getEnd_Slot() - item.getStart_Slot()}</td>
												<td>${item.getStudy_place()}</td>
												<td>${item.getProfessor().getProfessor_Name()}</td>
											</tr>
											<c:set var="count" value="${count + 1}" scope="page" />

										</c:forEach>
									</tbody>
									<tfoot>
									</tfoot>
								</table>
								<c:if test="${err != null }">
									<h3 style="color: red">
										<c:out value="${err}" />
									</h3>
								</c:if>
							</div>

							<div>
								<h3 style="padding-top: 30px">Danh Sách môn học đã chọn</h3>
								<table id="tableahihi2" class="" style="width: 100%;">
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
											<th class="th-sm">Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="count2" value="0" scope="page" />
										<c:forEach var="item"
											items="${scheduleItems.getTimeTableItem(idU)}">
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
												<td><input type="checkbox" id="myDelete${count2}"
													onclick="myFunction2()" value="${item.getiD_Schedule()}"></td>
											</tr>
											<c:set var="count2" value="${count2 + 1}" scope="page" />
										</c:forEach>
									</tbody>
									<tfoot>
									</tfoot>
								</table>
							</div>
						</c:otherwise>
					</c:choose>
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
		function myFunction() {
			for(var i=0; i<${count}; i++){
				var checkBox = document.getElementById("myCheck"+i);
				var ID_Student = ${idU};
				var ID_Schedule = document.getElementById("myCheck"+i).value;
				if (checkBox.checked == true) {
					window.location.href = ("${pageContext.request.contextPath}/CourseRegisterServlet?ID_Schedule="+ID_Schedule+"&ID_Student="+ID_Student+"&action=Add");
				} 
			}			
		}
	</script>
	<script type="text/javascript">
          function myFunction2(){
        	  for(var i=0; i<${count2}; i++){
  				var checkBox = document.getElementById("myDelete"+i);
  				var ID_Student = ${idU};
  				var ID_Schedule = document.getElementById("myDelete"+i).value;
  				if (checkBox.checked == true) {
  					window.location.href = ("${pageContext.request.contextPath}/CourseRegisterServlet?ID_Schedule="+ID_Schedule+"&ID_Student="+ID_Student+"&action=Delete");
  				 } 
  			 }			
          }
    </script>
</body>

</html>