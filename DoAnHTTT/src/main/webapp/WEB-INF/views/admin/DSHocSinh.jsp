<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="score" scope="request"
	class="httt.DoAnHTTT.database.Sub_PassDAO" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
<c:set var="id_Semester" value='${requestScope["id_Semester"]}' />
<c:set var="id_Course" value='${requestScope["id_Course"]}' />
<c:set var="listStudent" value='${requestScope["listStudent"]}' />
<main>
<div class="container-fluid">
	<h1 class="mt-4">DS học sinh theo môn</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
		<li class="breadcrumb-item active">DS học sinh theo môn</li>
	</ol>
	<div class="card mb-4">
		<div class="card-header">
			<i class="fas fa-table mr-1"></i> DS học sinh theo môn
		</div>
		<div
			style="padding-top: 10px; display: flex; justify-content: flex-end; padding-right: 20px">
			<button id="submit">Lưu nhập điểm</button>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form action="/DoAnHTTT/AddStudentScore" method="post"
					id="formsubmit">
					<table class="table table-bordered" id="myTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th class="th-sm" hidden="hidden"></th>
								<th class="th-sm">Mã Học Sinh</th>
								<th class="th-sm">Tên Học Sinh</th>
								<th class="th-sm">Điểm</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${listStudent}">
								<tr>
									<td hidden="hidden"><input type="text" hidden="hidden"
										name="id_Course" value="${id_Course}" /></td>
									<td>${item.getId_Student()}</td>
									<td>${item.getName_Student()}</td>
									<td><input type="text" name="${item.getId_Student()}" autocomplete="off"
										style="border-width: 0px; border: none; width: 50px"
										value="${score.getScoreStudentByCourseAndSemester(item.getId_Student(),id_Course,id_Semester)}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>	
</main>
<script>
 document.getElementById("submit").addEventListener('click',()=>{
	document.getElementById("formsubmit").submit();
});
</script>