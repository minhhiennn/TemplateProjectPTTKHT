<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="course" scope="request"
	class="httt.DoAnHTTT.database.CourseDAO" />
<jsp:useBean id="courseOffering" scope="request"
	class="httt.DoAnHTTT.database.Course_OfferingDAO" />
<c:set var="list" value='${requestScope["list"]}'></c:set>
<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Quản Lý Đăng Ký</h1>
	<p class="mb-4">
		<a target="_blank" href="https://datatables.net"></a>.
	</p>
	<!-- Data Example -->
	<div class="card shadow mb-4">
		<div
			style="display: flex; justify-content: flex-end; text-align: right; padding: 10px 19px">
			<form action="/DoAnHTTT/CloseRegistration" method="post">
				<button
				    type="submit"
					style="border: none; border-radius: 6px; padding: 8px; margin-right: 15px; background-color: #e74a3b;">
					<i class="fas fa-trash" style="margin-right: 5px"></i> <span>Đóng
						đăng ký tất cả</span>
				</button>
			</form>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>ID Môn Học</th>
							<th>Tên Môn Học</th>
							<th>Class Code</th>
							<th>Sĩ Số</th>
							<th>Số Lượng DK</th>
							<th>ID_Professor</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${list}">
							<tr>
								<td
									<c:if test="${courseOffering.checkCurrentSize(item.getiD_Course_Offering()) || courseOffering.checkProfessor(item.getiD_Course_Offering()) == false}">style="color:red"</c:if>>${item.getCourse().getiD_Course()}</td>
								<td
									<c:if test="${courseOffering.checkCurrentSize(item.getiD_Course_Offering()) || courseOffering.checkProfessor(item.getiD_Course_Offering()) == false}">style="color:red"</c:if>>${course.getNameCourse(item.getiD_Course_Offering())}</td>
								<td
									<c:if test="${courseOffering.checkCurrentSize(item.getiD_Course_Offering()) || courseOffering.checkProfessor(item.getiD_Course_Offering()) == false}">style="color:red"</c:if>>${item.getClass1().getClass_Code()}</td>
								<td
									<c:if test="${courseOffering.checkCurrentSize(item.getiD_Course_Offering()) || courseOffering.checkProfessor(item.getiD_Course_Offering()) == false}">style="color:red"</c:if>>${item.getMax_Size()}</td>
								<td
									<c:if test="${courseOffering.checkCurrentSize(item.getiD_Course_Offering()) || courseOffering.checkProfessor(item.getiD_Course_Offering()) == false}">style="color:red"</c:if>>${item.getCurrent_Size()}</td>
								<th
									<c:if test="${courseOffering.checkCurrentSize(item.getiD_Course_Offering()) || courseOffering.checkProfessor(item.getiD_Course_Offering()) == false}">style="color:red"</c:if>>${courseOffering.getIDProfessor(item.getiD_Course_Offering())}</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>