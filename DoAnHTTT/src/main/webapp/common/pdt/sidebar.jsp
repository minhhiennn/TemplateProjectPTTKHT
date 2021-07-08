<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.html">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			Admin <sup>NLU</sup>
		</div>
	</a>
	<li class="nav-item dropdown no-arrow"><a
		class="nav-link dropdown-toggle" href="#" id="userDropdown"
		role="button" data-toggle="dropdown" aria-haspopup="true"
		aria-expanded="false"> <img class="img-profile rounded-circle"
			src="img/undraw_profile.svg"> <span class="nav-link">Xin
				Chào Admin</span>
	</a> <!-- Dropdown - User Information -->
		<div
			class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
			aria-labelledby="userDropdown">
			<a class="dropdown-item" href="#"> <i
				class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Hồ Sơ
			</a> <a class="dropdown-item" href="#"> <i
				class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Cài Đặt
			</a> <a class="dropdown-item" href="#"> <i
				class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Hoạt Động
				Đăng Nhập
			</a>
			<div class="dropdown-divider"></div>
			<a class="dropdown-item" href="#" data-toggle="modal"
				data-target="#logoutModal"> <i
				class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> Đăng
				Nhập
			</a>
		</div></li>
	<!-- Divider -->
	<!-- Nav Item - Dashboard -->
	<li class="nav-item"><h6 class="nav-link">Quản lí Trang Chính</h6>
		<a class="nav-link" href="index.html"> <i class="fas fa-home"></i>
			<span>Thống Kê</span>
	</a></li>
	<li class="nav-item"><a class="nav-link" href="/DoAnHTTT/getTableForPDT?action=null">
			<i class="far fa-edit"></i> <span>Maintain Information</span>
	</a></li>
	<li class="nav-item"><a class="nav-link" href="/DoAnHTTT/CloseRegistration"> <i
			class="far fa-edit"></i> <span>Close Registration</span>
	</a></li>
	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>
</ul>
<!-- End of Sidebar -->
