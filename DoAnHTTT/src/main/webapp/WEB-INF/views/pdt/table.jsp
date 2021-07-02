<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Begin Page Content -->
<jsp:useBean id="semesterDao" scope="request"
	class="httt.DoAnHTTT.database.SemesterDAO" />
<c:set var="tableName" value="${sessionScope['table']}"></c:set>
<c:set var="tableMap" value="${semesterDao.getTableMap(tableName)}"></c:set>
<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Quản Lí User</h1>
	<p class="mb-4">
		<a target="_blank" href="https://datatables.net"></a>.
	</p>
	<!-- Data Example -->
	<div class="card shadow mb-4">
		<div>
			<select class="form-select" aria-label="Default select example"
				onchange="location = this.value;">
				<option value="/DoAnHTTT/getTableForPDT?action=table&table=schedule" <c:if test="${tableName.equals('schedule')}"> selected </c:if>>Schedule</option>
				<option value="/DoAnHTTT/getTableForPDT?action=table&table=course" <c:if test="${tableName.equals('course')}"> selected </c:if>>Course</option>
				<option
					value="/DoAnHTTT/getTableForPDT?action=table&table=course_offering" <c:if test="${tableName.equals('course_offering')}"> selected </c:if>>Course_Offering</option>
				<option value="/DoAnHTTT/getTableForPDT?action=table&table=student" <c:if test="${tableName.equals('student')}"> selected </c:if>>Student</option>
				<option
					value="/DoAnHTTT/getTableForPDT?action=table&table=professor" <c:if test="${tableName.equals('professor')}"> selected </c:if>>Professor</option>
			</select>
		</div>
		<div
			style="display: flex; justify-content: flex-end; text-align: right; padding: 10px 19px">
			<a href="themmoiuser.html">
				<button
					style="border: none; border-radius: 6px; padding: 8px; margin-right: 15px; background-color: #4e73df;">
					<i class="fas fa-plus" style="margin-right: 3px"></i> <span>Thêm</span>
				</button>
			</a>
			<button
				style="border: none; border-radius: 6px; padding: 8px; margin-right: 15px; background-color: #e74a3b;">
				<i class="fas fa-trash" style="margin-right: 5px"></i> <span>Xóa
					tất cả</span>
			</button>
			<button
				style="border: none; border-radius: 6px; padding: 8px; background-color: #1cc88a;">
				<i class="fas fa-file-upload" style="margin-right: 5px"></i> <span>Import
					to Excel</span>
			</button>
		</div>
		<div style="display: flex; padding: 5px 19px">
			<button
				style="padding: 8px 15px; border: 1px solid black; border-right: 1px solid #fff; background-color: #fff;">Copy</button>
			<button
				style="padding: 8px 15px; border: 1px solid black; border-right: 1px solid #fff; background-color: #fff;">CSV</button>
			<button
				style="padding: 8px 15px; border: 1px solid black; border-right: 1px solid #fff; background-color: #fff;">Excel</button>
			<button
				style="padding: 8px 15px; border: 1px solid black; background-color: #fff;">Print</button>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<c:forEach var="entry" items="${tableMap}">
								<th>${entry.key}</th>
							</c:forEach>
							<th>Xóa</th>
							<th>Sửa</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="i" begin="0"
							end="${tableMap.get(tableMap.keySet().toArray()[0]).size()-1}">
							<tr>
								<c:set var="count" value="0"></c:set>
								<c:forEach var="as" items="${tableMap}">
									<td>${as.value.get(i)}</td>
									<c:set var="count" value="${count + 1}" />
									<c:if test="${count == tableMap.size()}">
										<td>
											<button type="button"
												onclick="window.location.href='/DoAnHTTT/getTableForPDT?action=delete&table=${tableName}&id=${tableMap.get(tableMap.keySet().toArray()[1]).get(i)}'">
												<i class="fas fa-trash-alt"></i>
											</button>
										</td>
										<th>
											<button type="button"
												onclick="window.location.href='/DoAnHTTT/getTableForPDT?action=update&table=${tableName}&id=${tableMap.get(tableMap.keySet().toArray()[1]).get(i)}'">
												<i class="fas fa-tools"></i>
											</button>
										</th>
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->