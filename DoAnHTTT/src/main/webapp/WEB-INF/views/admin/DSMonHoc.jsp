<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="listSubject" scope="request"
	class="httt.DoAnHTTT.database.Professor_ScheduleDAO" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
<main>
<div class="container-fluid">
	<h1 class="mt-4">DS môn học đã đăng ký theo kỳ</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
		<li class="breadcrumb-item active">DS môn học đã đăng ký theo kỳ</li>
	</ol>
	<div class="card mb-4">
		<div class="card-header">
			<i class="fas fa-table mr-1"></i> DS môn học đã đăng ký theo kỳ
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="myTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th class="th-sm">Mã MH</th>
							<th class="th-sm">Tên MH</th>
							<th class="th-sm">Học kỳ</th>
							<th class="th-sm">DS lớp</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item"
							items="${listSubject.getListSubject(idU)}">
							<tr>
								<td>${item.getId_Course()}</td>
								<td>${item.getName_Course()}</td>
								<td>${item.getId_Semester()}</td>
								<td><a href="/DoAnHTTT/AddStudentScore?id_Course=${item.getId_Course()}">Xem DS lớp</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</main>