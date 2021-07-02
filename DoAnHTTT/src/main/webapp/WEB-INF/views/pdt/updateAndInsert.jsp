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

<html>
<form action="/DoAnHTTT/getTableForPDT" method="post">
	<c:forEach var="entry" items="${tableMap}">
		<input type="text" name="table" value="${table}" hidden="hidden">
		<label>${entry.key}</label>
		<c:choose>
			<c:when test="${entry.value.size()>1}">
				<select name="${entry.key}">
					<c:forEach var="i" begin="0" end="${entry.value.size()-1}">
						<option value="${entry.value.get(i)}">${entry.value.get(i)}</option>
					</c:forEach>
				</select>
			</c:when>
			<c:otherwise>
				<c:if test="${flag == 'update'}">
					<input value="${entry.value.get(0)}" name="${entry.key}">
				</c:if>
				<c:if test="${flag == 'insert'}">
					<input value="" name="${entry.key}">
				</c:if>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<button value="${flag}" name="submit">Lưu</button>
</form>
</html>