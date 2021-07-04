<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="scheduleItems" scope="request"
	class="httt.DoAnHTTT.database.Student_ScheduleDAO" />
<jsp:useBean id="TimeRegister" scope="request"
	class="httt.DoAnHTTT.database.TimeForCourseRegisterDao" />
<jsp:useBean id="semester" scope="request"
	class="httt.DoAnHTTT.database.SemesterDAO" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
<c:set var="list" value="${scheduleItems.getSubAvailableST(idU)}"></c:set>
<c:set var="list2" value="${scheduleItems.getTimeTableItem(idU)}"></c:set>
<c:set var="err" value='${requestScope["err"]}' />
<c:set var="id_Semester" value='${semester.getID_SemesterByGetDate()}'></c:set>
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
								<table id="tableahihi" class="table table-bordered"
									style="width: 100%;">
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
										<c:forEach var="i" begin="0" end="${list.size() - 1}">
											<c:set var="disable" value="" scope="page" />
											<c:set var="check" value="" scope="page"></c:set>
											<c:if
												test="${list.get(i).getCourse_Offering().getMax_Size() == list.get(i).getCourse_Offering().getCurrent_Size()}">
												<c:set var="disable" value="disabled" scope="page" />
											</c:if>
											<c:if
												test="${scheduleItems.checkSubExistInTimeTable(idU,list.get(i).getiD_Schedule()) == true }">
												<c:set var="check" value="checked" scope="page"></c:set>
												<c:set var="disable" value="disabled" scope="page" />
											</c:if>
											<tr>
												<c:choose>
													<c:when test="${i==0}">
														<c:choose>
															<c:when
																test="${list.get(i).getCourse_Offering().getiD_Course_Offering().equals(list.get(i+1).getCourse_Offering().getiD_Course_Offering())}">
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle"><input
																	type="checkbox" onclick="test(this)"
																	value="${list.get(i).getCourse_Offering().getiD_Course_Offering()}"
																	${disable} ${check}></td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getMax_Size()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getMax_Size() - list.get(i).getCourse_Offering().getCurrent_Size()}</td>
																<td>${list.get(i).getTheoretical()}</td>
																<td>${list.get(i).getTeaching_Day()}</td>
																<td>${list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getEnd_Slot() - list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getStudy_place()}</td>
																<td>${list.get(i).getProfessor().getProfessor_Name()}</td>
															</c:when>
															<c:otherwise>
																<td><input type="checkbox" onclick="test(this)"
																	value="${list.get(i).getCourse_Offering().getiD_Course_Offering()}"
																	${disable} ${check}></td>
																<td>${list.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td>${list.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td>${list.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td>${list.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td>${list.get(i).getCourse_Offering().getMax_Size()}</td>
																<td>${list.get(i).getCourse_Offering().getMax_Size() - list.get(i).getCourse_Offering().getCurrent_Size()}</td>
																<td>${list.get(i).getTheoretical()}</td>
																<td>${list.get(i).getTeaching_Day()}</td>
																<td>${list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getEnd_Slot() - list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getStudy_place()}</td>
																<td>${list.get(i).getProfessor().getProfessor_Name()}</td>
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:when test="${i <= list.size()-2 && i >= 1}">
														<c:choose>
															<c:when
																test="${list.get(i).getCourse_Offering().getiD_Course_Offering().equals(list.get(i+1).getCourse_Offering().getiD_Course_Offering())}">
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle"><input
																	type="checkbox" onclick="test(this)"
																	value="${list.get(i).getCourse_Offering().getiD_Course_Offering()}"
																	${disable} ${check}></td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getMax_Size()}</td>
																<td rowspan="2"
																	style="text-align: center; vertical-align: middle">${list.get(i).getCourse_Offering().getMax_Size() - list.get(i).getCourse_Offering().getCurrent_Size()}</td>
																<td>${list.get(i).getTheoretical()}</td>
																<td>${list.get(i).getTeaching_Day()}</td>
																<td>${list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getEnd_Slot() - list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getStudy_place()}</td>
																<td>${list.get(i).getProfessor().getProfessor_Name()}</td>
															</c:when>
															<c:when
																test="${list.get(i).getCourse_Offering().getiD_Course_Offering().equals(list.get(i-1).getCourse_Offering().getiD_Course_Offering())}">
																<td>${list.get(i).getTheoretical()}</td>
																<td>${list.get(i).getTeaching_Day()}</td>
																<td>${list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getEnd_Slot() - list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getStudy_place()}</td>
																<td>${list.get(i).getProfessor().getProfessor_Name()}</td>
															</c:when>
															<c:otherwise>
																<td><input type="checkbox" onclick="test(this)"
																	value="${list.get(i).getCourse_Offering().getiD_Course_Offering()}"
																	${disable} ${check}></td>
																<td>${list.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td>${list.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td>${list.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td>${list.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td>${list.get(i).getCourse_Offering().getMax_Size()}</td>
																<td>${list.get(i).getCourse_Offering().getMax_Size() - list.get(i).getCourse_Offering().getCurrent_Size()}</td>
																<td>${list.get(i).getTheoretical()}</td>
																<td>${list.get(i).getTeaching_Day()}</td>
																<td>${list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getEnd_Slot() - list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getStudy_place()}</td>
																<td>${list.get(i).getProfessor().getProfessor_Name()}</td>
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:when test="${i == list.size()-1}">
														<c:choose>
															<c:when
																test="${list.get(i).getCourse_Offering().getiD_Course_Offering().equals(list.get(i-1).getCourse_Offering().getiD_Course_Offering())}">
																<td>${list.get(i).getTheoretical()}</td>
																<td>${list.get(i).getTeaching_Day()}</td>
																<td>${list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getEnd_Slot() - list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getStudy_place()}</td>
																<td>${list.get(i).getProfessor().getProfessor_Name()}</td>
															</c:when>
															<c:otherwise>
																<td><input type="checkbox" onclick="test(this)"
																	value="${list.get(i).getCourse_Offering().getiD_Course_Offering()}"
																	${disable} ${check}></td>
																<td>${list.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td>${list.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td>${list.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td>${list.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td>${list.get(i).getCourse_Offering().getMax_Size()}</td>
																<td>${list.get(i).getCourse_Offering().getMax_Size() - list.get(i).getCourse_Offering().getCurrent_Size()}</td>
																<td>${list.get(i).getTheoretical()}</td>
																<td>${list.get(i).getTeaching_Day()}</td>
																<td>${list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getEnd_Slot() - list.get(i).getStart_Slot()}</td>
																<td>${list.get(i).getStudy_place()}</td>
																<td>${list.get(i).getProfessor().getProfessor_Name()}</td>
															</c:otherwise>
														</c:choose>
													</c:when>
												</c:choose>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
									</tfoot>
								</table>
							</div>
							<c:if test="${err != null }">
								<div>
									<h3 style="color: red">
										<c:out value="${err}" />
									</h3>
								</div>
							</c:if>
							<div
								style="padding-top: 10px; display: flex; justify-content: flex-end">
								<button onclick="test3()">Lưu đăng ký</button>
							</div>
							<div>
								<h3 style="padding-top: 30px">Danh Sách môn học đã chọn</h3>
								<table id="tableahihi2" class="table table-bordered"
									style="width: 100%;">
									<thead>
										<tr style="border: none">
											<th class="th-sm">Mã MH</th>
											<th class="th-sm">Tên MH</th>
											<th class="th-sm">STC</th>
											<th class="th-sm">Mã lớp</th>
											<th class="th-sm">Theoretical</th>
											<th class="th-sm">Trạng thái môn học</th>
											<th class="th-sm">Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="i" begin="0" end="${list2.size() - 1}">
											<tr>
												<c:choose>
													<c:when test="${i == 0}">
														<c:choose>
															<c:when
																test="${list2.get(i).getCourse_Offering().getiD_Course_Offering().equals(list2.get(i+1).getCourse_Offering().getiD_Course_Offering())}">
																<td rowspan="2" style="vertical-align: middle">${list2.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td rowspan="2" style="vertical-align: middle">${list2.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td rowspan="2" style="vertical-align: middle">${list2.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td rowspan="2" style="vertical-align: middle">${list2.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td>${list2.get(i).getTheoretical()}</td>
																<td><c:choose>
																		<c:when
																			test="${scheduleItems.checkExitsInRealTimeTable(id_Semester,idU,list2.get(i).getiD_Schedule()) == false}">Chưa Lưu Vào CSDL</c:when>
																		<c:otherwise>Đã lưu vào CSDL</c:otherwise>
																	</c:choose></td>
																<td rowspan="2" style="vertical-align: middle"><input
																	type="checkbox" onclick="test2(this)"
																	value="${list2.get(i).getCourse_Offering().getiD_Course_Offering()}"></td>
															</c:when>
															<c:otherwise>
																<td>${list2.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td>${list2.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td>${list2.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td>${list2.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td>${list2.get(i).getTheoretical()}</td>
																<td><c:choose>
																		<c:when
																			test="${scheduleItems.checkExitsInRealTimeTable(id_Semester,idU,list2.get(i).getiD_Schedule()) == false}">Chưa Lưu Vào CSDL</c:when>
																		<c:otherwise>Đã lưu vào CSDL</c:otherwise>
																	</c:choose></td>
																<td><input type="checkbox" onclick="test2(this)"
																	value="${list2.get(i).getCourse_Offering().getiD_Course_Offering()}"></td>
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:when test="${i <= list2.size()-2 && i >= 1}">
														<c:choose>
															<c:when
																test="${list2.get(i).getCourse_Offering().getiD_Course_Offering().equals(list2.get(i+1).getCourse_Offering().getiD_Course_Offering())}">
																<td rowspan="2" style="vertical-align: middle">${list2.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td rowspan="2" style="vertical-align: middle">${list2.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td rowspan="2" style="vertical-align: middle">${list2.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td rowspan="2" style="vertical-align: middle">${list2.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td>${list2.get(i).getTheoretical()}</td>
																<td><c:choose>
																		<c:when
																			test="${scheduleItems.checkExitsInRealTimeTable(id_Semester,idU,list2.get(i).getiD_Schedule()) == false}">Chưa Lưu Vào CSDL</c:when>
																		<c:otherwise>Đã lưu vào CSDL</c:otherwise>
																	</c:choose></td>
																<td rowspan="2" style="vertical-align: middle"><input
																	type="checkbox" onclick="test2(this)"
																	value="${list2.get(i).getCourse_Offering().getiD_Course_Offering()}""></td>
															</c:when>
															<c:when
																test="${list2.get(i).getCourse_Offering().getiD_Course_Offering().equals(list2.get(i-1).getCourse_Offering().getiD_Course_Offering())}">
																<td>${list2.get(i).getTheoretical()}</td>
																<td><c:choose>
																		<c:when
																			test="${scheduleItems.checkExitsInRealTimeTable(id_Semester,idU,list2.get(i).getiD_Schedule()) == false}">Chưa Lưu Vào CSDL</c:when>
																		<c:otherwise>Đã lưu vào CSDL</c:otherwise>
																	</c:choose></td>
															</c:when>
															<c:otherwise>
																<td>${list2.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td>${list2.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td>${list2.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td>${list2.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td>${list2.get(i).getTheoretical()}</td>
																<td><c:choose>
																		<c:when
																			test="${scheduleItems.checkExitsInRealTimeTable(id_Semester,idU,list2.get(i).getiD_Schedule()) == false}">Chưa Lưu Vào CSDL</c:when>
																		<c:otherwise>Đã lưu vào CSDL</c:otherwise>
																	</c:choose></td>
																<td><input type="checkbox" onclick="test2(this)"
																	value="${list2.get(i).getCourse_Offering().getiD_Course_Offering()}"></td>
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:when test="${i == list2.size()-1}">
														<c:choose>
															<c:when
																test="${list2.get(i).getCourse_Offering().getiD_Course_Offering().equals(list2.get(i-1).getCourse_Offering().getiD_Course_Offering())}">
																<td>${list2.get(i).getTheoretical()}</td>
																<td><c:choose>
																		<c:when
																			test="${scheduleItems.checkExitsInRealTimeTable(id_Semester,idU,list2.get(i).getiD_Schedule()) == false}">Chưa Lưu Vào CSDL</c:when>
																		<c:otherwise>Đã lưu vào CSDL</c:otherwise>
																	</c:choose></td>
															</c:when>
															<c:otherwise>
																<td>${list2.get(i).getCourse_Offering().getCourse().getiD_Course()}</td>
																<td>${list2.get(i).getCourse_Offering().getCourse().getName_Course()}</td>
																<td>${list2.get(i).getCourse_Offering().getCourse().getCourse_certificate()}</td>
																<td>${list2.get(i).getCourse_Offering().getClass1().getClass_Code()}</td>
																<td>${list2.get(i).getTheoretical()}</td>
																<td><c:choose>
																		<c:when
																			test="${scheduleItems.checkExitsInRealTimeTable(id_Semester,idU,list2.get(i).getiD_Schedule()) == false}">Chưa Lưu Vào CSDL</c:when>
																		<c:otherwise>Đã lưu vào CSDL</c:otherwise>
																	</c:choose></td>
																<td><input type="checkbox" onclick="test2(this)"
																	value="${list2.get(i).getCourse_Offering().getiD_Course_Offering()}"></td>
															</c:otherwise>
														</c:choose>
													</c:when>
												</c:choose>
											</tr>
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
		function test(ele) {
			if (ele.checked == true) {
				window.location.href = ("/DoAnHTTT/CourseRegisterServlet?ID_CourseOffering="
						+ ele.value + "&action=Add");
			}
		}
		function test2(ele) {
			if (ele.checked == true) {
				window.location.href = ("/DoAnHTTT/CourseRegisterServlet?ID_CourseOffering="
						+ ele.value + "&action=Delete");
			}
		}
		function test3() {
			window.location.href = ("/DoAnHTTT/CourseRegisterServlet?action=AddToReal");
		}
	</script>
</body>
</html>