<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Quản Lí User</h1>
	<p class="mb-4">
		<a target="_blank" href="https://datatables.net"></a>.
	</p>
	<!-- Data Example -->
	<div class="card shadow mb-4">
		<div>
			<select class="form-select" aria-label="Default select example">
				<option value="schedule">Schedule</option>
				<option value="course">Course</option>
				<option value="course_offering">Course_Offering</option>
				<option value="student">Student</option>
				<option value="professor">Professor</option>
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
							<th>ID</th>
							<th>Họ tên</th>
							<th>Quyền hạn</th>
							<th>Xóa</th>
							<th>Sửa</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td>1</td>
							<td>PhungDepTrai</td>
							<td>Quản trị danh mục</td>
							<td>
								<button type="button">
									<i class="fas fa-trash-alt"></i>
								</button>
							</td>

							<th>
								<button type="button">
									<i class="fas fa-tools"></i>
								</button>
							</th>


						</tr>
						<tr>
							<td>2</td>
							<td>PhungVipPro</td>
							<td>Quản trị giao diện</td>
							<td>
								<button type="button">
									<i class="fas fa-trash-alt"></i>
								</button>
							</td>

							<th>
								<button type="button">
									<i class="fas fa-tools"></i>
								</button>
							</th>


						</tr>
						<tr>
							<td>3</td>
							<td>PhungCún</td>
							<td>Quản trị thông tin</td>
							<td>
								<button type="button">
									<i class="fas fa-trash-alt"></i>
								</button>
							</td>

							<th>
								<button type="button">
									<i class="fas fa-tools"></i>
								</button>
							</th>

						</tr>
						<tr>
							<td>4</td>
							<td>PhungOs</td>
							<td>Seo website</td>
							<td>
								<button type="button">
									<i class="fas fa-trash-alt"></i>
								</button>
							</td>

							<th>
								<button type="button">
									<i class="fas fa-tools"></i>
								</button>
							</th>


						</tr>
						<tr>
							<td>5</td>
							<td>Phung</td>
							<td>Quản trị danh mục</td>
							<td>
								<button type="button">
									<i class="fas fa-trash-alt"></i>
								</button>
							</td>

							<th>
								<button type="button">
									<i class="fas fa-tools"></i>
								</button>
							</th>

						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->