<!-- Master page cho admin -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- css cho admin -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>
<link href="<c:url value='/template/admin/css/styles.css'/>"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css"></script>
</head>
<body class="sb-nav-fixed">
	<%@ include file="/common/admin/header.jsp"%>
	<div id="layoutSidenav">
		<%@ include file="/common/admin/sidenav-menu.jsp"%>
		<div id="layoutSidenav_content">
			<dec:body />
			<%@ include file="/common/admin/footer.jsp"%>
		</div>
	</div>

	<!-- JS cho admin -->

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/template/admin/js/scripts.js'/>"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#myTable').DataTable({
				"bInfo" : false,
				"scrollY" : "300px",
				"scrollCollapse" : false,
				"paging" : false
			});
		});
		$(document).ready(function() {
			$('#myTable2').DataTable({
				"bInfo" : false,
				"scrollY" : "300px",
				"scrollCollapse" : false,
				"paging" : false
			});
		});
	</script>
</body>
</html>