<!-- Cái master layout này tao ko biết là student vs professor có xài chung 1 cái header footer hay ko-->
<!-- nên tạo kiểu này -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *Must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>Clever - Education &amp; Courses Template | Home</title>

<!-- Favicon -->
<link href="<c:url value='/template/img/core-img/favicon.ico'/>"
	rel="icon">

<!-- Stylesheet -->
<link href="<c:url value='/template/style.css'/>" rel="stylesheet">

<!-- ?o?n CSS cho table -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/select/1.3.1/css/select.dataTables.min.css">
</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<dec:body />
	<%@ include file="/common/footer.jsp"%>
	<!-- ##### Footer Area End ##### -->
	<!-- ##### All Javascript Script ##### -->
	<!-- jQuery-2.2.4 js -->
	<script src="<c:url value='/template/js/jquery/jquery-2.2.4.min.js'/>"></script>
	<!-- Popper js -->
	<script src="<c:url value='/template/js/bootstrap/popper.min.js'/>"></script>
	<!-- Bootstrap js -->
	<script src="<c:url value='/template/js/bootstrap/bootstrap.min.js'/>"></script>
	<!-- All Plugins js -->
	<!-- phần này là phần animation -->
	<!-- <script src="<c:url value='/template/js/plugins/plugins.js'/>"></script> -->
	<!-- <script src="js/plugins/plugins.js"></script> -->
	<!-- Active js -->
	<script src="<c:url value='/template/js/active.js'/>"></script>
	<!-- JS cho table -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tableahihi').DataTable({
				"scrollY" : "300px",
				"scrollCollapse" : false,
				"paging" : false
			});
		});
	</script>
</body>
</html>