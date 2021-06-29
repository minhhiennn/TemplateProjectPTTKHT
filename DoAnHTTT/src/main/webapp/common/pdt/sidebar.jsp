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
	<hr class="sidebar-divider my-0">
	<!-- Nav Item - Dashboard -->
	<li class="nav-item"><h6 class="nav-link">Quản lí Trang Chính</h6>
		<a class="nav-link" href="index.html"> <i class="fas fa-home"></i>
			<span>Thống Kê</span>
	</a></li>
	<!-- Heading -->
	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link"
		href="quanlybinhluan.html"> <i class="fas fa-comments"></i> <span>Quản
				Lí Bình Luận</span>
	</a></li>
	<li class="nav-item"><a class="nav-link" href="quanlyhoidap.html">
			<i class="far fa-edit"></i> <span>Quản Lí Hỏi Đáp</span>
	</a></li>
	<!--qua li tài khỏan-->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-user"></i> <span>Cấu
				hình User</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">

				<a class="collapse-item" href="quanlyuser.html">Quản lý user</a> <a
					class="collapse-item" href="danhsachquyen.html">Danh sách quyền</a>
				<a class="collapse-item" href="#">Thông tin user</a>
			</div>
		</div></li>
	<!--quan li bình luận-->
	<li class="nav-item"><a class="nav-link collapsed"
		href="login.html" data-toggle="collapse"
		data-target="#collapseUtilities" aria-expanded="true"
		aria-controls="collapseUtilities"> <i class="far fa-list-alt"></i>
			<span>Quản Lí Sản Phẩm</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">

				<a class="collapse-item" href="Loaidanhmuc.html">Loại danh mục</a> <a
					class="collapse-item" href="SanPham.html">Sản phẩm</a> <a
					class="collapse-item" href="#">Bài viết</a>
			</div>
		</div></li>
	<!--quản lí kho-->
	<li class="nav-item active"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-industry"></i> <span>Quản Lí Kho</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="Bieudo.html">Biểu đồ thông dụng</a>
			</div>
		</div></li>
	<li class="nav-item"><a class="nav-link" href="donhang.html">
			<i class="fas fa-book"></i> <span>Quản Lí Đơn Hàng</span>
	</a></li>
	<!-- Nav Item - Utilities Collapse Menu -->
	<!-- Heading -->
	<li class="nav-item"><h6 class="nav-link">Quản lí Hệ Thống</h6> <a
		class="nav-link" href="#"> </a></li>
	<!--menu dưới-->
	<div class="menu-duoi" aria-labelledby="userDropdown">
		<a class="menu1" href="#"> <i
			class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
		</a> <a class="menu2" href="#"> <i
			class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
		</a> <a class="menu3" href="#"> <i
			class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
		</a> <a class="menu4" href="#" data-toggle="modal"
			data-target="#logoutModal"> <i
			class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>

		</a>
	</div>
	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>
</ul>
<!-- End of Sidebar -->
