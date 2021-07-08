<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Begin Page Content -->
<jsp:useBean id="semesterDao" scope="request"
	class="httt.DoAnHTTT.database.SemesterDAO" />
<c:set var="id" value="${requestScope['id']}"></c:set>
<c:set var="flag" value="${requestScope['flag']}"></c:set>
<c:set var="table" value="${requestScope['table']}"></c:set>
<c:set var="tableMap" value="${semesterDao.getMapForPDT(table,id)}"></c:set>
<main>
<div class="container-fluid">
	<h1 class="mt-4">Quản Lý ${table}</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
		<li class="breadcrumb-item active">Quản Lý ${table}</li>
	</ol>
	<div class="card mb-4">
		<div class="card-body">
			<form action="/DoAnHTTT/getTableForPDT" method="post">
				<div class="card shadow mb-4"">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Thông tin chung</h6>
					</div>
					<div class="card-body">
						<c:forEach var="entry" items="${tableMap}">
						<input type="text" name="table" value="${table}" hidden="hidden">
							<div style="display: flex">
								<div style="width: 200px">${entry.key}</div>
								<c:choose>
									<c:when test="${entry.value.size()>1}">
										<select name="${entry.key}" style="width: 600px; padding: 3px">
											<c:forEach var="i" begin="0" end="${entry.value.size()-1}">
												<option value="${entry.value.get(i)}">${entry.value.get(i)}</option>
											</c:forEach>
										</select>
									</c:when>
									<c:otherwise>
										<c:if test="${flag == 'update'}">
											<input value="${entry.value.get(0)}" name="${entry.key}" style="width: 600px; padding: 3px">
										</c:if>
										<c:if test="${flag == 'insert'}">
											<input value="" name="${entry.key}" style="width: 600px; padding: 3px">
										</c:if>
									</c:otherwise>
								</c:choose>
							</div>
							<hr>
						</c:forEach>
					</div>
				</div>
				<div class="card shadow mb-4">
					<div class="card-body">
						<div style="padding-left: 231px">
							<button type="submit" value="${flag}" name="submit"
								style="border: none; background-color: #36b9cc; border-radius: 6px; margin-right: 10px">Lưu</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div style="height: 100vh"></div>
</div>
</main>