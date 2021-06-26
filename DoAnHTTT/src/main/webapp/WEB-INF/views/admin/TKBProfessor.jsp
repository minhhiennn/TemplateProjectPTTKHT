<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="scheduleItems" scope="request"
	class="httt.DoAnHTTT.database.Professor_ScheduleDAO" />
<jsp:useBean id="TimetableItems" scope="request"
	class="httt.DoAnHTTT.database.Professor_ScheduleDAO" />
<c:set var="currentUser" value='${sessionScope["currentUser"]}'></c:set>
<c:set var="idU" value='${currentUser.iD_User}'></c:set>
<c:set var="err" value='${requestScope["err"]}' />
<main>
<div class="container-fluid">
	<h1 class="mt-4">View TimeTable</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
		<li class="breadcrumb-item active">View TimeTable</li>
	</ol>
	<div class="card mb-4">
		<div class="card-header">
			<i class="fas fa-table mr-1"></i> Đăng ký môn dạy học
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="myTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th class="th-sm"></th>
							<th class="th-sm">Mã MH</th>
							<th class="th-sm">Tên MH</th>
							<th class="th-sm">STC</th>
							<th class="th-sm">Mã lớp</th>
							<th class="th-sm">Theoretical</th>
							<th class="th-sm">Thứ</th>
							<th class="th-sm">Tiết BD</th>
							<th class="th-sm">ST</th>
							<th class="th-sm">Phòng</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="0" scope="page" />
						<c:forEach var="item"
							items="${scheduleItems.getSubAvaliableForProfessor(idU)}">
							<tr>
								<td><input type="checkbox" id="myCheck${count}"
									onclick="test(this)"
									value="${item.getiD_Schedule()}-${item.getCourse_Offering().getCourse().getiD_Course()}"></td>
								<td>${item.getCourse_Offering().getCourse().getiD_Course()}</td>
								<td>${item.getCourse_Offering().getCourse().getName_Course()}</td>
								<td>${item.getCourse_Offering().getCourse().getCourse_certificate()}</td>
								<td>${item.getCourse_Offering().getClass1().getClass_Code()}</td>
								<td>${item.getTheoretical()}</td>
								<td>${item.getTeaching_Day()}</td>
								<td>${item.getStart_Slot()}</td>
								<td>${item.getEnd_Slot() - item.getStart_Slot()}</td>
								<td>${item.getStudy_place()}</td>
							</tr>
							<c:set var="count" value="${count + 1}" scope="page" />
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div>
		<c:if test="${err != null }">
			<h3 style="color: red">
				<c:out value="${err}" />
			</h3>
		</c:if>
	</div>
	<div class="card mb-4">
		<div class="card-header">
			<i class="fas fa-table mr-1"></i> Danh sách môn học đã đăng ký dạy
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="myTable2" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th class="th-sm">Mã MH</th>
							<th class="th-sm">Tên MH</th>
							<th class="th-sm">STC</th>
							<th class="th-sm">Mã lớp</th>
							<th class="th-sm">Theoretical</th>
							<th class="th-sm">Thứ</th>
							<th class="th-sm">Tiết BD</th>
							<th class="th-sm">ST</th>
							<th class="th-sm">Phòng</th>
							<th class="th-sm">Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count2" value="0" scope="page" />
						<c:forEach var="item"
							items="${scheduleItems.getTimetableForProfessor(idU)}">
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
								<td><input type="checkbox" id="myDelete${count2}"
									onclick="test2(this)"
									value="${item.getiD_Schedule()}-${item.getCourse_Offering().getCourse().getiD_Course()}"></td>
							</tr>
							<c:set var="count2" value="${count2 + 1}" scope="page" />
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</main>
<script>
	function test(ele) {
		if (ele.checked == true) {
			if (ele.checked == true) {
				let listId_Schedule = "";
				let stringSplit = ele.value.split('-');
				let id_Schedule = stringSplit[0];
				listId_Schedule += id_Schedule;
				let id_Course = stringSplit[1];
				let id = ele.id;
				let count = ${count};
				for (let i = 0; i < count; i++) {
					let x = "myCheck" + i;
					if (x != id) {
						let x1 = document.getElementById(x);
						let x1_id_Schedule = x1.value.split('-')[0];
						let x1_id_Course = x1.value.split('-')[1];
						if (id_Course == x1_id_Course) {
							listId_Schedule = listId_Schedule + "-"
									+ x1_id_Schedule;
							break;
						}
					}
				}
				window.location.href = ("/DoAnHTTT/CourseRegisterProfessorServlet?list_ID_Schedule="
						+ listId_Schedule + "&id_Course=" + id_Course + "&action=Add");
			}
		}
	}
	function test2(ele){
    	if(ele.checked == true){
    		let listId_Schedule = "";
        	let stringSplit = ele.value.split('-');
        	let id_Schedule = stringSplit[0];
        	listId_Schedule += id_Schedule;
        	let id_Course = stringSplit[1];
        	let id = ele.id;
        	let count = ${count2};
        		for(let i = 0;i<count;i++){
        			let x = "myDelete"+i;
        			if(x != id){
        				let x1 = document.getElementById(x);
        				let x1_id_Schedule = x1.value.split('-')[0];
        				let x1_id_Course = x1.value.split('-')[1];
        				if(id_Course == x1_id_Course){
        				   listId_Schedule = listId_Schedule + "-" + x1_id_Schedule;
        				   break;
        				}
        			}
        		}
        	window.location.href = ("/DoAnHTTT/CourseRegisterProfessorServlet?list_ID_Schedule="+listId_Schedule+"&id_Course="+id_Course+"&action=Delete");
        	}
    }
</script>
