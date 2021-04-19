<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>layout-static</title>

</head>
<body>
	<div id="layoutSidenav">
		<%@ include file="/common/admin/sidenav-menu.jsp"%>
		<div id="layoutSidenav_content">
			<main>
			<div class="container-fluid">
				<h1 class="mt-4">Quản Lý Sinh Viên</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
					<li class="breadcrumb-item active">Quản Lý Sinh Viên</li>
				</ol>
				<div class="card mb-4">
					<div class="card-body">
						<form action="${pageContext.request.contextPath}/ManagerServlet"
							method="post" enctype="multipart/form-data">
							<div class="card shadow mb-4"">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Thông tin
										chung</h6>
								</div>
								<div class="card-body">
									<div style="display: flex;">
										<span style="padding-right: 120px; margin-top: 10px">Chọn
											file excel:</span>
										<div style="padding: 5px; border-radius: 3px; width: 600px;">
											<input type="file" name="file" multiple="multiple">
										</div>

									</div>
								</div>
							</div>
							<div class="card shadow mb-4">
								<div class="card-body">
									<div style="padding-left: 231px">
										<button type="submit"
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
		</div>
	</div>
</body>
</html>
